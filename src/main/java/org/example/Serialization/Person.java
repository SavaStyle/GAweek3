package org.example.Serialization;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
public class Person implements Serializable {

    private String name;
    private int age;
    private transient String profession;

    public Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                '}';
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeUTF(name);
        oos.writeInt(age);
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        name = ois.readUTF();
        age = ois.readInt();
        if (age < 3) {
            setProfession("Сидит дома");
        } else if (age < 7) {
            setProfession("Ходит в детский сад");
        } else if (age < 17) {
            setProfession("Учится в школе");
        } else if (age < 24) {
            setProfession("Учится в институте");
        } else if (age < 65) {
            setProfession("Работает");
        } else {
            setProfession("На пенсии");
        }
    }
}
