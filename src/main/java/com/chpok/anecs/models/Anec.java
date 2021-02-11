package com.chpok.anecs.models;

public class Anec {
    private Long id;
    private String text;

    public Anec() {
    }

    public Anec(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Anec(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
