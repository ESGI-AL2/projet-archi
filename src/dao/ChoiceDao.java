package dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import factories.OrderFactory;
import model.Association;
import model.Choice;
import model.Order;
import model.User;

public class ChoiceDao {
	private List<Choice> choices = new ArrayList<Choice>();
	private static ChoiceDao instance;

	private ChoiceDao() {
	}

	public static ChoiceDao getInstance() {
		if (instance == null) {
			instance = new ChoiceDao();
		}
		return instance;
	}
	
	public void addChoice (Choice choice) {
		choices.add(choice);
	}
	public List<Choice> getChoicesByUser (User user) {
		List <Choice> result = new ArrayList<Choice>();
		for (Choice choice: this.choices) {
			if (choice.getOrder().getUser().equals(user) ) {
				result.add(choice);
			}
		}
		return result;
	}
	public List<Choice> getChoices() {
		return choices;
	}
	
	public List<Choice> getLastChoicesByUser (User user) {
		List <Choice> result = new ArrayList<Choice>();
		List <Choice> userChoices = getChoicesByUser(user);
		Map <Order, LocalDateTime> last = new HashMap <>();
		for (Choice choice: userChoices) {
			if (!last.containsKey(choice.getOrder())) {
				last.put(choice.getOrder(), choice.getLdt());
			}
			else {
				if (choice.getLdt().isAfter(last.get(choice.getOrder()))) {
					last.replace(choice.getOrder(), choice.getLdt());
				}
			}
		}
		return result;
	}
	public List<Choice> getLastChoices () {
		List <Choice> result = new ArrayList<Choice>();
		for (User user : UserDao.getInstance().getUsers()) {
			List <Choice> userChoices = getChoicesByUser(user);
			Map <Order, Association> last = new HashMap <>();
			for (Choice choice: userChoices) {
				if (!last.containsKey(choice.getOrder())) {
					last.put(choice.getOrder(), new Association (choice.isConserved(), choice.getLdt()));
				}
				else {
					if (choice.getLdt().isAfter(last.get(choice.getOrder()).getLdt())) {
						last.replace(choice.getOrder(), new Association (choice.isConserved(), choice.getLdt()));
					}
				}
			}
			for (Order order : last.keySet()) {
                  Choice choice = new Choice (order, last.get(order).isConserved(), last.get(order).getLdt());
                  result.add(choice);
			}
		}

		return result;
	}

}
