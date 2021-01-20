package factories;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import dao.OrderDao;
import dao.UserDao;
import model.Order;
import model.User;


public class OrderFactory {

    private static OrderFactory instance;

    private OrderFactory() {
    }

    public static OrderFactory getInstance() {
        if (instance == null) {
            instance = new OrderFactory();
        }
        return instance;
    }

    public void addOrder(JsonNode json) {
        int id = json.get("id").intValue();
        int price = json.get("price").intValue();
        int userId = json.get("userId").intValue();
        UserDao userDao = UserDao.getInstance();
        User user = userDao.getUserById(userId);
        Order order = new Order(id, price, user);
        OrderDao orderDao = OrderDao.getInstance();
        orderDao.getOrders().add(order);
    }


}
