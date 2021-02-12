package infrastructure.dao.memoryList;

import java.util.ArrayList;
import java.util.List;

import domain.dao.OrderDao;
import domain.model.Order;
import domain.model.User;

public class OrderDaoMemoryList implements OrderDao {
    private List<Order> orders = new ArrayList<Order>();
    private static OrderDaoMemoryList instance;

    private OrderDaoMemoryList() {
    }

    public static OrderDaoMemoryList getInstance() {
        if (instance == null) {
            instance = new OrderDaoMemoryList();
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
            if (order.getUser() == user) {
                result.add(order);
            }
        }
        return result;
    }

    @Override
    public void changeOrderState(Order order, String state) {
        for (Order o : orders) {
            if (o == order) {
                o.setState(state);
            }
        }

    }


}
