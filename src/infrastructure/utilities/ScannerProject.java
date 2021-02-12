package infrastructure.utilities;

import domain.dao.ChoiceDao;
import domain.dao.OrderDao;
import domain.dao.UserDao;
import domain.model.Choice;
import domain.model.Order;
import domain.model.User;
import infrastructure.factories.DaoFactory;
import infrastructure.factories.MessageFactory;
import use_case.*;

import java.util.List;
import java.util.Scanner;

public class ScannerProject {

    private OrderDao orderDao =DaoFactory.getOrderDao();
    private UserDao userDao = DaoFactory.getUserDao();
    private ChoiceDao choiceDao = DaoFactory.getChoiceDao();
    private Message message = MessageFactory.getMessage();
    private Scanner scanner = new Scanner(System.in);
    private static ScannerProject instance;

    private ScannerProject() {
    }

    public static ScannerProject getInstance() {
        if (instance == null) {
            instance = new ScannerProject();
        }
        return instance;
    }

    public void start() {
        boolean endProgram = false;
        while (!endProgram) {
            message.send("Pour vous connecter en tant qu'admin, écrivez \"admin\", pour vous connecter en tant qu'utilisateur, entrez votre id, pour quitter le programme, entrez \"end\"");
            String s = scanner.nextLine();
            switch (s) {
                case "admin":
                    menuAdmin();
                    break;
                case "end":
                    endProgram = true;
                    break;
                default:
                    try {
                        int userId = Integer.parseInt(s);
                        List <Integer> existingId = userDao.getAllId();
                        if (existingId.contains(userId)) {
                            User user = userDao.getUserById(userId);
                            menuUser(user);
                        }
                        else {
                            message.send("Utilisateur inconnu");
                        }
                    }
                    catch (Exception e) {
                        message.send("Merci d'entrer une commande correcte");
                    }

                }


            }


        }


    private void userChoice(User user) throws Exception {
        message.send("Pour chaque billet, choisissez \"o\" si vous voulez le conservez et \"n\" si voue ne voulez pas le conserver");
        List<Order> ordersOfUser = orderDao.getOrdersOfUser(user);
        for (Order order : ordersOfUser) {
            message.send("billet n°".concat(String.valueOf(order.getId()).concat(" au prix de : ").concat(String.valueOf(order.getPrice()))));
            boolean endLoop = false;
            while (!endLoop) {
                endLoop = false;
                String s = scanner.nextLine();
                endLoop = new MakeAChoice (s, order, choiceDao).execute();
            }
        }
        message.send(new SendMail(user).execute());
    }

    private void menuAdmin() {
        boolean endAdmin = false;
        while (!endAdmin) {
            message.send("Pour consulter tous les choix, écrivez \"tous\", pour consulter les derniers choix de chaque utilisateur, écrivez \"dernier\", pour effacer tous les choix écrivez \"delete\", pour retourner au menu principal, entrez \"menu\"");
            String s = scanner.nextLine();
            switch (s) {
                case "tous":
                    List<Choice> allChoices = new DisplayAllResponses(choiceDao).execute();
                    print(allChoices);
                    break;
                case "dernier":
                    List<Choice> lastChoices = new DisplayLastChoiceofEachUser(choiceDao).execute();
                    print(lastChoices);
                    break;
                case "delete":
                    new DeleteChoices(choiceDao).execute();
                    break;
                case "menu":
                    endAdmin = true;
                    break;
                default:
                    message.send("Merci d'entrer une commande correcte");

            }

        }
    }

    private void menuUser (User user) throws Exception {
        boolean endUser = false;
        while (!endUser) {
            message.send("Pour consulter vos billets, écrivez \"consulter\", pour choisir si vous voulez conserver ou non vos billets, écrivez \"choisir\", pour retourner au menu principal, écrivez \"menu\"");
            String s = scanner.nextLine();
            switch (s) {
                case "consulter":
                    List<Order> orders = new DisplayResponseOfUser(user, orderDao).execute();
                    print (orders);
                    break;
                case "choisir":
                    userChoice (user);
                    break;
                case "menu":
                    endUser = true;
                    break;
                default:
                    message.send("Merci d'entrer une commande correcte");

            }
        }

    }
    private <T> void print (List<T> list) {
    for (T object : list) {
        message.send(object.toString());
    }
    }


}
