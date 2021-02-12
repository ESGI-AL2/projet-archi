package domain.dao;

import domain.model.Choice;
import domain.model.User;

import java.util.List;

public interface ChoiceDao {
    public void addChoice (Choice choice);
    public List<Choice> getChoicesByUser (User user);
    public List<Choice> getChoices();
    public List<Choice> getLastChoicesByUser (User user);
    public List<Choice> getLastChoices ();
    public void deleteAll ();
}
