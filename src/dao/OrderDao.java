package dao;

import java.util.ArrayList;
import java.util.List;

import model.Order;
import model.User;

public class OrderDao {
    private List<Order> orders = new ArrayList<Order>();
    private static OrderDao instance;

    private OrderDao() {
    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOrdersOfUser(User user) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUser().equals(user)) {
                result.add(order);
            }
        }
        return result;
    }


}
