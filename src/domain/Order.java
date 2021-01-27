package domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                price == order.price &&
                user.equals(order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, user);
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", userId=" + user.getId() +
                ", state='" + state + '\'' +
                '}' + "\n";
    }
}
