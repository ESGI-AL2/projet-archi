package use_case;

import domain.dao.OrderDao;
import domain.model.Order;
import domain.model.User;

import java.util.List;

public class DisplayResponseOfUser {
    private User user;
    private final OrderDao orderDao;

    public List<Order> execute() {
        return orderDao.getOrdersOfUser(user);
    }

    public DisplayResponseOfUser(User user, OrderDao orderDao) {
        this.user = user;
        this.orderDao = orderDao;
    }


}
