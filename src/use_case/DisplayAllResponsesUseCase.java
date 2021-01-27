package use_case;

import domain.Choice;
import infrastructure.dao.IChoiceDao;
import infrastructure.factories.DaoFactory;
import infrastructure.factories.MessageFactory;

import java.util.List;

public class DisplayAllResponsesUseCase {

    private void display() {
        IChoiceDao choiceDao = DaoFactory.getChoiceDao();
        List<Choice> choices = choiceDao.getChoices();
        StringBuilder sb = new StringBuilder();
        for (Choice choice : choices) {
            sb.append(choice.toString());
        }
        MessageFactory.getMessage().send(sb.toString());
    }

    public DisplayAllResponsesUseCase () {
        display();
    }
}
