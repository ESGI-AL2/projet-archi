package domain.dao;

import domain.model.Order;
import domain.model.User;

import java.util.List;

public interface OrderDao {

    public List<Order> getOrders();
    public Order getOrderById(int id);
    public List<Order> getOrdersOfUser(User user);
    public void changeOrderState (Order order, String state);

}
