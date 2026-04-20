package com.zakariya.scraper;

import java.time.LocalDateTime;

/**
 * Class that acts as an object for the parser to pass scraped data through
 * Formats Data into an object that is then written to the Repository
 */

class ScrapedData {

    private String title;
    private String content;
    private String url;
    private LocalDateTime capturedAt;

    public ScrapedData(String title, String content, String url, LocalDateTime capturedAt) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.capturedAt = capturedAt;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getUrl() {
        return this.url;
    }

    public LocalDateTime getCapturedAt() {
        return this.capturedAt;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }

    public void setUrl(String newUrl) {
        this.url = newUrl;
    }

    public void setCapturedAt(LocalDateTime newCapturedAt) {
        this.capturedAt = newCapturedAt;
    }

    @Override
    public String toString() {
        return "Book[Title=" + title + ", Content=" + content + ", URL =" + url + ", CapturedAt ="
                + capturedAt;
    }

}
