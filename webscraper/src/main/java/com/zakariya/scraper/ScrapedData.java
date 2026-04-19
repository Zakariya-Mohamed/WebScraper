package com.zakariya.scraper;

/**
 * Class that acts as an object for the parser to pass scraped data through
 * Formats Data into an object that is then written to the Repository
 */

class ScrapedData {

    private String title;
    private Double price;
    private float starRating;
    private boolean availibility;

    public ScrapedData(String title, Double price, float starRating, boolean availibility) {
        this.title = title;
        this.price = price;
        this.starRating = starRating;
        this.availibility = availibility;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    public float getStarRating() {
        return this.starRating;
    }

    public boolean getAvailibility() {
        return this.availibility;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setPrice(Double newPrice) {
        this.price = newPrice;
    }

    public void setStarRating(float newStarRating) {
        this.starRating = newStarRating;
    }

    public void setAvailibility(boolean newAvailibility) {
        this.availibility = newAvailibility;
    }

    @Override
    public String toString() {
        return "Book[Title=" + title + ", Price=" + price + ", Star Rating=" + starRating + ", Availibility="
                + availibility;
    }

}
