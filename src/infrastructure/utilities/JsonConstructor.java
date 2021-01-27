package infrastructure.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.dao.IUserDao;
import infrastructure.factories.DaoFactory;
import infrastructure.factories.OrderFactory;
import infrastructure.factories.UserFactory;

public class JsonConstructor {

    private JsonNode json;

    public JsonConstructor() throws IOException {

    }



    public void init () throws IOException {
        StringBuilder contentOfUser = new StringBuilder();
        Stream<String> linesOfUser = Files.lines(Paths.get("resources/user.json"));
        contentOfUser.append(linesOfUser.collect(Collectors.joining(System.lineSeparator())));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonOfUsers = mapper.readTree(contentOfUser.toString());
        UserFactory userFactory = UserFactory.getInstance();
        for (JsonNode json : jsonOfUsers) {
            userFactory.addUser(json);
        }
        IUserDao userDao = DaoFactory.getUserDao();
        StringBuilder contentOfOrder = new StringBuilder();
        Stream<String> linesOfOrder = Files.lines(Paths.get("resources/order.json"));
        contentOfOrder.append(linesOfOrder.collect(Collectors.joining(System.lineSeparator())));
        JsonNode jsonOfOrders = mapper.readTree(contentOfOrder.toString());
        OrderFactory orderFactory = OrderFactory.getInstance();
        for (JsonNode json : jsonOfOrders) {
            orderFactory.addOrder(json);
        }
    }
}
