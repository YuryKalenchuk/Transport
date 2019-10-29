package entity;

public class Feedback extends BaseEntity {
    private Driver driver;
    private User user;
    private String text;
    private int rating;

    public Feedback(Driver driver, User user, String text, int rating) {
        this.driver = driver;
        this.user = user;
        this.text = text;
        this.rating = rating;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
