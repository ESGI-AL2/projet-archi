package infrastructure.factories;

import infrastructure.dao.IChoiceDao;
import infrastructure.dao.IOrderDao;
import infrastructure.dao.IUserDao;
import infrastructure.dao.memoryList.ChoiceDaoMemoryList;
import infrastructure.dao.memoryList.OrderDaoMemoryList;
import infrastructure.dao.memoryList.UserDaoMemoryList;

public class DaoFactory {

    public static IChoiceDao getChoiceDao(){
        return ChoiceDaoMemoryList.getInstance();
    }

    public static IOrderDao getOrderDao(){
        return OrderDaoMemoryList.getInstance();
    }

    public static IUserDao getUserDao(){
        return UserDaoMemoryList.getInstance();
    }


}
