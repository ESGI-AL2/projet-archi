package Utility;

import dao.ChoiceDao;
import dao.OrderDao;
import dao.UserDao;
import model.Choice;
import model.Order;
import model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ScannerProject {

    private OrderDao orderDao = OrderDao.getInstance();
    private UserDao userDao = UserDao.getInstance();
    private ChoiceDao choiceDao = ChoiceDao.getInstance();
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
            System.out.println("Pour vous connecter en tant qu'admin, écrivez \"admin\", pour vous connecter en tant qu'utilisateur, entrez votre id, pour quitter le programme, entrez \"end\"");
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
                            userchoice(user);
                        }
                        else {
                            System.out.println("Merci d'entrer une commande correcte");
                        }
                    }
                    catch (Exception e) {
                        System.out.println("Merci d'entrer une commande correcte");
                    }

                }


            }


        }


    private void userchoice(User user) {
        System.out.println("Pour chaque billet, choisissez \"o\" si vous voulez le conservez et \"n\" si voue ne voulez pas le conserver");
        List<Order> ordersOfUser = orderDao.getOrdersOfUser(user);
        for (Order order : ordersOfUser) {
            System.out.println("billet n°".concat(String.valueOf(order.getId()).concat(" au prix de : ").concat(String.valueOf(order.getPrice()))));
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
                        System.out.println("Merci d'entrer une commande correcte");
                }
            }
        }
        // TODO mail
    }

    private void menuAdmin() {
        boolean endAdmin = false;
        while (!endAdmin) {
            System.out.println("Pour consulter tous les choix, écrivez \"tous\", pour consulter les derniers choix de chaque utilisateur, écrivez \"dernier\", pour effacer tous les choix écrivez \"delete\", pour retourner au menu principal, entrez \"menu\"");
            String s = scanner.nextLine();
            switch (s) {
                case "tous":
                    for (Choice choice : choiceDao.getChoices()) {
                        choice.print();
                    }
                    break;
                case "dernier":
                    for (Choice choice : choiceDao.getLastChoices()) {
                        choice.print();
                    }
                    break;
                case "delete":
                    choiceDao.getChoices().clear();
                    break;
                case "menu":
                    endAdmin = true;
                    break;
                default:
                    System.out.println("Merci d'entrer une commande correcte");

            }

        }
    }


}
