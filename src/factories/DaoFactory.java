package factories;

import dao.IChoiceDao;
import dao.IOrderDao;
import dao.IUserDao;
import dao.memoryList.ChoiceDaoMemoryList;
import dao.memoryList.OrderDaoMemoryList;
import dao.memoryList.UserDaoMemoryList;

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
