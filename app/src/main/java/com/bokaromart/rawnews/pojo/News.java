package com.bokaromart.rawnews.pojo;

/**
 * Created by ashdey on 8/14/16.
 */
public class News {
    private String title;
    private String description;
    private String link;
    private String author;
    private String guid;
    private String pubDate;
    private NewsCommonAttributes newsCommonAttributes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public NewsCommonAttributes getNewsCommonAttributes() {
        return newsCommonAttributes;
    }

    public void setNewsCommonAttributes(NewsCommonAttributes newsCommonAttributes) {
        this.newsCommonAttributes = newsCommonAttributes;
    }

    @Override
    public String toString() {
        return "FeedMessage [title=" + title + ", description=" + description
                + ", link=" + link + ", author=" + author + ", guid=" + guid
                + "]";
    }
}
