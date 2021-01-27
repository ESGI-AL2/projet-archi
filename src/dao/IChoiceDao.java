package dao;

import domain.Choice;
import domain.User;

import java.util.List;

public interface IChoiceDao {
    public void addChoice (Choice choice);
    public List<Choice> getChoicesByUser (User user);
    public List<Choice> getChoices();
    public List<Choice> getLastChoicesByUser (User user);
    public List<Choice> getLastChoices ();
}
