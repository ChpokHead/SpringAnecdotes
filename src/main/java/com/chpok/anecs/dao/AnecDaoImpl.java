package com.chpok.anecs.dao;

import com.chpok.anecs.models.Anec;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class AnecDaoImpl implements AnecDao{

    JdbcTemplate template;

    //language=SQL
    private String SQL_GET_RANDOM_LIST = "select * from chpok_anecdot order by random() limit 1000;";

    //language=SQL
    private String SQL_GET_ANEC_BY_ID = "select * from chpok_anecdot where id=?";

    //language=SQL
    private String SQL_INSERT_ANEC = "insert into chpok_anecdot(anecdot_text) values(?) on conflict do nothing;";



    RowMapper<Anec> rowMapper = (resultSet, i) -> {
        return new Anec(resultSet.getLong("id"), resultSet.getString("anecdot_text"));
    };

    @Autowired
    public AnecDaoImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
        initDb();

    }

    @Override
    public void save(Anec anec) {

    }

    @Override
    public Optional<Anec> get(Long id) {
        List<Anec> anecList = template.query(SQL_GET_ANEC_BY_ID, rowMapper, id);

        if (anecList.isEmpty())
            return Optional.empty();

        return Optional.of(anecList.get(0));
    }

    @Override
    public void update(Anec anec) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Anec> getAll() {
        return null;
    }

    @Override
    public Optional<Anec> getRandomAnec() {
        return Optional.of(template.query(SQL_GET_RANDOM_LIST, rowMapper).get(0));
    }

    @Override
    public void initDb() {
        try {
            Document doc = Jsoup.connect("https://4tob.ru/anekdots/tag/black").get();
            Elements anecs = doc.select("p");

            //Удаляем шапку страницы и добавляем в бд последующие анекдоты
            for (int i = 2; i < anecs.size(); i++){
                template.update(SQL_INSERT_ANEC, anecs.get(i).outerHtml());
            }
        } catch (IOException e) {
            System.err.println("CHECK YOUR INTERNET CONNECTION!");
        }

    }
}
