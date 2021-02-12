package use_case;

import domain.model.User;

public class SendMail {
    private final User user;

    public String execute () {
        return String.format ("Message envoyé à l'adresse mail %s : Cher(e) %s %s, vous venez de modifier vos choix concernant les billets en votre possession.", user.getEmail(), user.getFirstName(), user.getLastName());
    }
    public SendMail(User user) {
        this.user = user;

    }
}
