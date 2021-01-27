package infrastructure.dao;

import domain.Order;
import domain.User;

import java.util.List;

public interface IOrderDao {

    public List<Order> getOrders();
    public Order getOrderById(int id);
    public List<Order> getOrdersOfUser(User user);
    public void changeOrderState (Order order, String state);

}
