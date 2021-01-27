package infrastructure.utilities;

import infrastructure.dao.IChoiceDao;
import infrastructure.dao.IOrderDao;
import infrastructure.dao.IUserDao;
import domain.Choice;
import domain.Order;
import domain.User;
import infrastructure.factories.DaoFactory;
import infrastructure.factories.MessageFactory;
import use_case.DeleteChoicesUseCase;
import use_case.DisplayAllResponsesUseCase;
import use_case.DisplayLastChoiceofEachUserUseCase;
import use_case.DisplayResponseOfUserUseCase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ScannerProject {

    private IOrderDao orderDao =DaoFactory.getOrderDao();
    private IUserDao userDao = DaoFactory.getUserDao();
    private IChoiceDao choiceDao = DaoFactory.getChoiceDao();
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
            MessageFactory.getMessage().send("Pour vous connecter en tant qu'admin, écrivez \"admin\", pour vous connecter en tant qu'utilisateur, entrez votre id, pour quitter le programme, entrez \"end\"");
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
                            MessageFactory.getMessage().send("Utilisateur inconnu");
                        }
                    }
                    catch (Exception e) {
                        MessageFactory.getMessage().send("Merci d'entrer une commande correcte");
                    }

                }


            }


        }


    private void userChoice(User user) {
        MessageFactory.getMessage().send("Pour chaque billet, choisissez \"o\" si vous voulez le conservez et \"n\" si voue ne voulez pas le conserver");
        List<Order> ordersOfUser = orderDao.getOrdersOfUser(user);
        for (Order order : ordersOfUser) {
            MessageFactory.getMessage().send("billet n°".concat(String.valueOf(order.getId()).concat(" au prix de : ").concat(String.valueOf(order.getPrice()))));
            boolean endLoop = false;
            while (!endLoop) {
                String s = scanner.nextLine();
                switch (s) {
                    case "o":
                        endLoop = true;
                        Choice choice = new Choice(order, true, LocalDateTime.now());
                        choiceDao.addChoice(choice);
                        break;
                    case "n":
                        endLoop = true;
                        choice = new Choice(order, false, LocalDateTime.now());
                        choiceDao.addChoice(choice);
                        break;
                    default:
                        MessageFactory.getMessage().send("Merci d'entrer une commande correcte");
                }
            }
        }
        // TODO mail
    }

    private void menuAdmin() {
        boolean endAdmin = false;
        while (!endAdmin) {
            MessageFactory.getMessage().send("Pour consulter tous les choix, écrivez \"tous\", pour consulter les derniers choix de chaque utilisateur, écrivez \"dernier\", pour effacer tous les choix écrivez \"delete\", pour retourner au menu principal, entrez \"menu\"");
            String s = scanner.nextLine();
            switch (s) {
                case "tous":
                    new DisplayAllResponsesUseCase();
                    break;
                case "dernier":
                    new DisplayLastChoiceofEachUserUseCase();
                    break;
                case "delete":
                    new DeleteChoicesUseCase();
                    break;
                case "menu":
                    endAdmin = true;
                    break;
                default:
                    MessageFactory.getMessage().send("Merci d'entrer une commande correcte");

            }

        }
    }

    private void menuUser (User user) {
        boolean endUser = false;
        while (!endUser) {
            MessageFactory.getMessage().send("Pour consulter vos billets, écrivez \"consulter\", pour choisir si vous voulez conserver ou non vos billets, écrivez \"choisir\", pour retourner au menu principal, écrivez \"menu\"");
            String s = scanner.nextLine();
            switch (s) {
                case "consulter":
                    new DisplayResponseOfUserUseCase(user);
                    break;
                case "choisir":
                    userChoice (user);
                    break;
                case "menu":
                    endUser = true;
                    break;
                default:
                    MessageFactory.getMessage().send("Merci d'entrer une commande correcte");

            }
        }

    }


}
