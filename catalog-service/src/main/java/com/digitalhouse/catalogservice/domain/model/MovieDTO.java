package com.digitalhouse.catalogservice.domain.model;

public class MovieDTO {

    private Long id;
    private String name;
    private String genre;
    private String urlStream;

    public MovieDTO() {
        //No-args constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUrlStream() {
        return urlStream;
    }

    public void setUrlStream(String urlStream) {
        this.urlStream = urlStream;
    }

    @Override
    public String toString() {
        return "{\"MovieDTO\":{"
            + "\"id\":\"" + id + "\""
            + ", \"name\":\"" + name + "\""
            + ", \"genre\":\"" + genre + "\""
            + ", \"urlStream\":\"" + urlStream + "\""
            + "}}";
    }
}
