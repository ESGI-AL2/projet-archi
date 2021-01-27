package infrastructure.factories;

import com.fasterxml.jackson.databind.JsonNode;

import infrastructure.dao.IOrderDao;
import infrastructure.dao.IUserDao;
import domain.Order;
import domain.User;


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
        IUserDao userDao = DaoFactory.getUserDao();
        User user = userDao.getUserById(userId);
        Order order = new Order(id, price, user);
        IOrderDao orderDao= DaoFactory.getOrderDao();
        orderDao.getOrders().add(order);

    }


}
