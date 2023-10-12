package org.example;

import org.example.Java8.StreamAPI;
import org.example.Serialization.Print;

public class Main {
    public static void main(String[] args) {

        Print printSerialization = new Print();
        StreamAPI streamAPI = new StreamAPI();

        printSerialization.init();
        streamAPI.init();
    }
}