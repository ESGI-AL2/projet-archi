package factories;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import model.Order;
import model.User;

public class OrderFactory {
	private List<Order> orders = new ArrayList<Order>();
	private static OrderFactory instance ;
	
	private OrderFactory () {			
	}
	
	public static OrderFactory getInstance() {
		if (instance == null) {
			instance = new OrderFactory() ;}
		return instance ;
	}

	public void addOrder (JsonNode json) {
		int id = json.get("id").intValue();
		int price = json.get("price").intValue();
		int userId = json.get("userId").intValue();
		UserFactory userFactory = UserFactory.getInstance();
		User user = userFactory.getUserById(userId);
		Order order = new Order (id, price, user);
		orders.add(order);
	}
	
	public List<Order> getOrders () {
		return orders;
	}
	
	public Order getOrderById (int id)
	{
		for (Order order: orders) {
			if (order.getId() == id) {
				return order;
			}
		}
		return null;
	}
}
