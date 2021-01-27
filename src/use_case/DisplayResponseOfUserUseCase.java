package use_case;

import infrastructure.dao.IOrderDao;
import domain.Order;
import domain.User;
import infrastructure.factories.DaoFactory;
import infrastructure.factories.MessageFactory;

import java.util.List;

public class DisplayResponseOfUserUseCase {
    private User user;

    private void display() {
        StringBuilder sb = new StringBuilder();
        IOrderDao orderDao = DaoFactory.getOrderDao();
        List<Order> orders = orderDao.getOrdersOfUser(user);
        for (Order order : orders) {
            sb.append(order.toString());
        }
        MessageFactory.getMessage().send(sb.toString());

    }

    public DisplayResponseOfUserUseCase(User user) {
        this.user = user;
        display();
    }


}
