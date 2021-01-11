package main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonConstructor {

	private JsonNode json;
	
	public JsonConstructor (String urlstring) throws IOException {
		URL url = new URL(urlstring);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		try {
		    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
		    String s = readStream(in);
		    System.out.println(s);
		    
		} finally {
		    urlConnection.disconnect();
		}
	}
	
	private String readStream(InputStream is) throws IOException {
	    StringBuilder sb = new StringBuilder();  
	    BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);  
	    for (String line = r.readLine(); line != null; line =r.readLine()){  
	        sb.append(line);  
	    }  
	    is.close();  
	    return sb.toString();
	}
}
