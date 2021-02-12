package use_case;

import domain.model.Choice;
import domain.dao.ChoiceDao;

import java.util.List;

public class DisplayAllResponses {

    private final ChoiceDao choiceDao;

    public List<Choice> execute() {
        return choiceDao.getChoices();
    }

    public DisplayAllResponses(ChoiceDao choiceDao) {
        this.choiceDao = choiceDao;
        execute();
    }
}

