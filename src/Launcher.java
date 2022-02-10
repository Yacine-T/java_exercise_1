import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Launcher {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a command, please :");
        try (Scanner sc = new Scanner(System.in)) {
            String txt = sc.nextLine();
            while (!txt.equals("quit")) {

                if (txt.equals("fibo")) {
                    System.out.println("Enter a number, please : ");
                    String n = sc.nextLine();
                    int res = fibo(Integer.parseInt(n));
                    System.out.println(res);
                    System.exit(0);

                } else if (txt.equals("freq")) {
                    System.out.println("Pourriez-vous indiquer le chemin vers le fichier que vous souhaitez lire, svp ? ");
                    Path path = Paths.get(sc.nextLine());
                    String content = Files.readString(path);
                    freq(content);
                    System.exit(0);
                } else {

                    System.out.println("Unknown command !");
                    System.out.println("Enter a command, please :");
                    txt = sc.nextLine();
                }
            }
            System.out.println("You're exiting the program ...");
            System.out.println("Program exited !");
            System.exit(0);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void freq(String str) {
        String[] words = str.split(" ");
        HashMap<String, Integer> wordsOcc = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            String c_word = words[i];
            for (int j = 0; j < words.length; j++) {
                if (c_word.equals(words[j])) {
                    count++;
                }
            }
            wordsOcc.put(c_word, count);
        }

        List<Entry<String, Integer>> sortedEntries = new ArrayList<>(wordsOcc.entrySet());
        sortedEntries.sort(Comparator.<Entry<String, Integer>, Integer>comparing(e -> e.getValue()).reversed());
        for (int i = 0; i < 3; i++) {
            System.out.print(sortedEntries.get(i).getKey() + " ");
        }
    }

    public static int fibo(int n) {
        int nb1 = 0;
        int nb2 = 1;
        int nb3 = 0;
        for (int i = 2; i <= n; i++) {
            nb3 = nb1 + nb2;
            nb1 = nb2;
            nb2 = nb3;
        }
        return nb3;
    }
}
