package use_case;

import domain.model.Choice;
import domain.dao.ChoiceDao;

import java.util.List;

public class DisplayLastChoiceofEachUser {

    private final ChoiceDao choiceDao;

    public List<Choice> execute() {
        return choiceDao.getLastChoices();

    }

    public DisplayLastChoiceofEachUser(ChoiceDao choiceDao) {
        this.choiceDao = choiceDao;
    }
}
