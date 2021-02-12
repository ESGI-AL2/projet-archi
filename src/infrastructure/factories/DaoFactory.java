package infrastructure.factories;

import domain.dao.ChoiceDao;
import domain.dao.OrderDao;
import domain.dao.UserDao;
import infrastructure.dao.memoryList.ChoiceDaoMemoryList;
import infrastructure.dao.memoryList.OrderDaoMemoryList;
import infrastructure.dao.memoryList.UserDaoMemoryList;

public class DaoFactory {

    public static ChoiceDao getChoiceDao() {
        return ChoiceDaoMemoryList.getInstance();
    }

    public static OrderDao getOrderDao() {
        return OrderDaoMemoryList.getInstance();
    }

    public static UserDao getUserDao() {
        return UserDaoMemoryList.getInstance();
    }


}
