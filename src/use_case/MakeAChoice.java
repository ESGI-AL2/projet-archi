package use_case;

import domain.dao.ChoiceDao;
import domain.model.Choice;
import domain.model.Order;

import java.time.LocalDateTime;

public class MakeAChoice {
    private final String response;
    private final Order order;
    private final ChoiceDao choiceDao;

    public boolean execute () throws Exception {
        switch (response) {
            case "o":
                Choice choice = new Choice(order, true, LocalDateTime.now());
                choiceDao.addChoice(choice);
                return true;
            case "n":
                choice = new Choice(order, false, LocalDateTime.now());
                choiceDao.addChoice(choice);
                return true;
            default:
                throw new Exception("Merci d'entrer une commande correcte");
        }
    }
    public MakeAChoice (String response, Order order, ChoiceDao choiceDao) {
        this.response = response;
        this.order = order;
        this.choiceDao = choiceDao;
    }
}
