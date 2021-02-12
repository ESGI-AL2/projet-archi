package use_case;

import domain.dao.ChoiceDao;

public class DeleteChoices {

    private final ChoiceDao choiceDao;

    public void execute() {
        choiceDao.deleteAll();
    }

    public DeleteChoices(ChoiceDao choiceDao) {
        this.choiceDao = choiceDao;
    }
}
