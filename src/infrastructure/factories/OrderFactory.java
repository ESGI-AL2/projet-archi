package infrastructure.factories;

import com.fasterxml.jackson.databind.JsonNode;

import domain.dao.OrderDao;
import domain.dao.UserDao;
import domain.model.Order;
import domain.model.User;


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
        UserDao userDao = DaoFactory.getUserDao();
        User user = userDao.getUserById(userId);
        Order order = new Order(id, price, user);
        OrderDao orderDao= DaoFactory.getOrderDao();
        orderDao.getOrders().add(order);

    }


}
