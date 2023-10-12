package org.example.IO;

import java.io.*;
import java.util.Scanner;

public class FileManager {

    public void stat() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Укажите абсолютный путь к файлу и ключ операции.\nДопустимые операции: -create, -read, -write, -delete, -exit");
            String line = scanner.nextLine();
            if (line.equals("-exit")) {
                break;
            }

            String[] splitLine = line.split(" ");

            if (splitLine.length < 2) {
                System.out.println("Необходимо указать абсолютный путь к файлу и ключ операции.");
                continue;
            }

            String filePath = splitLine[0];
            String operation = splitLine[1];

            switch (operation) {
                case "-create":
                    createFile(filePath);
                    break;
                case "-read":
                    readFile(filePath);
                    break;
                case "-write":
                    if (splitLine.length < 3) {
                        System.out.println("Необходимо указать строку для записи.");
                        return;
                    }
                    String content = splitLine[2];
                    writeFile(filePath, content);
                    break;
                case "-delete":
                    deleteFile(filePath);
                    break;
                default:
                    System.out.println("Недопустимая операция. Допустимые операции: -create, -read, -write, -delete, -exit");
            }
        }
    }

    private static void createFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getAbsolutePath());
            } else {
                System.out.println("Файл уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    private static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    private static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Запись в файл успешно выполнена.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Файл удален: " + file.getAbsolutePath());
            } else {
                System.out.println("Ошибка при удалении файла.");
            }
        } else {
            System.out.println("Файл не существует.");
        }
    }
}