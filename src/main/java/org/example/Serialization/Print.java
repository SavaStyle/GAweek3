package org.example.Serialization;

import java.io.*;

public class Print {
    Person before = new Person("Person", 25, "Сидит дома");


    public void init() {
        System.out.println("До сериализации");
        System.out.println(before);

        try {
            FileOutputStream fileOut = new FileOutputStream("Person.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(before);
            out.close();
            fileOut.close();
        } catch (
                IOException i) {
            i.printStackTrace();
        }

        Person after = null;
        try {
            FileInputStream fileIn = new FileInputStream("Person.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            after = (Person) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("\nПосле сериализации");
        System.out.println(after + "\n");
    }
}
