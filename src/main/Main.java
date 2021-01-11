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

import factories.OrderFactory;
import factories.UserFactory;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        //JsonConstructor jsonconstructor = new JsonConstructor("http://demo2009247.mockable.io/user/123");
        /*URL url = new URL("http://demo2009247.mockable.io/user/123");
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.connect();
		InputStream inputStream = urlConnection.getInputStream();
		String result = readStream(inputStream);
		System.out.println(result);*/
		
		StringBuilder contentOfUser = new StringBuilder();
		Stream<String> linesOfUser = Files.lines(Paths.get("resources/user.json"));
		contentOfUser.append(linesOfUser.collect(Collectors.joining(System.lineSeparator())));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonOfUsers = mapper.readTree(contentOfUser.toString());
        UserFactory userFactory = UserFactory.getInstance();
        for (JsonNode json : jsonOfUsers) {
        	userFactory.addUser(json);
        }
        System.out.println(userFactory.getUsers().get(0).getFirstName());
        StringBuilder contentOfOrder = new StringBuilder();
		Stream<String> linesOfOrder = Files.lines(Paths.get("resources/order.json"));
		contentOfOrder.append(linesOfOrder.collect(Collectors.joining(System.lineSeparator())));
        JsonNode jsonOfOrders = mapper.readTree(contentOfOrder.toString());
        OrderFactory orderFactory = OrderFactory.getInstance();
        for (JsonNode json : jsonOfOrders) {
        	orderFactory.addOrder(json);
        }
        System.out.println(orderFactory.getOrders().get(0).getPrice());
	}
	
	private static String readStream(InputStream is) throws IOException {
	    StringBuilder sb = new StringBuilder();  
	    BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);  
	    for (String line = r.readLine(); line != null; line =r.readLine()){  
	        sb.append(line);  
	    }  
	    is.close();  
	    return sb.toString();
	}

}
