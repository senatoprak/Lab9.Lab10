package Lab10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

 class Task6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first 3 digits of the bank account: ");
        String prefix = scanner.nextLine().trim();

        if (!prefix.matches("\\d{3}")) {
            System.out.println("Please enter exactly 3 digits!");
            return;
        }

        String urlString = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            String bankCode = null;
            String bankName = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                StringBuilder digits = new StringBuilder();
                for (char ch : line.toCharArray()) {
                    if (Character.isDigit(ch)) {
                        digits.append(ch);
                    } else {
                        break;
                    }
                }

                if (digits.length() >= 3 && digits.substring(0, 3).equals(prefix)) {
                    bankCode = digits.toString();
                    bankName = line.substring(digits.length()).trim();
                    break;
                }
            }

            reader.close();

            if (bankName != null) {
                System.out.println("Bank code: " + bankCode);
                System.out.println("Bank name: " + bankName);
            } else {
                System.out.println("No bank found with these 3 digits.");
            }

        } catch (Exception e) {
            System.out.println("Error while loading or processing the file: " + e.getMessage());
        }
    }
}
