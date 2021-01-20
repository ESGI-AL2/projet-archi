package main;


import Utility.JsonConstructor;
import Utility.ScannerProject;


import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

    JsonConstructor json = new JsonConstructor();
    json.init();
    ScannerProject sp = ScannerProject.getInstance();
    sp.start();




    }



}
