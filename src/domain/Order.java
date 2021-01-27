package domain;

public class Order {
    private int id;
    private int price;
    private User user;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(int id, int price, User user) {
        super();
        this.id = id;
        this.price = price;
        this.user = user;
        this.state = "undefined";
    }


}
