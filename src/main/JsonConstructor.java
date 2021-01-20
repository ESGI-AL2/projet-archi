package main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import factories.OrderFactory;
import factories.UserFactory;

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
        UserDao userDao = UserDao.getInstance();
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
