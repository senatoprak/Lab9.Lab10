package Lab10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task4 {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("studentsEN.txt"));
             FileWriter fw = new FileWriter("studentsENwith5.txt")) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] word = line.split("\\s+");
                String surname = word[0].trim();
                String name = word[1].trim();
                String score = word[2].trim();

                if (score.equals("5")) {
                    System.out.println("Surname = " + surname + " name = " + name + " score = " + score);
                    fw.write(surname + "\s" + name + "\s" + score + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Error IO");
        }
    }
}

