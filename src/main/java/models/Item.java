package models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Item {

    private int id;
    private String link;
    private String description;
    private String title;
    private String pubDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Type(type="text")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Type(type="text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Type(type="text")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}
