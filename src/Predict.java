import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Predict implements Command {
    @Override
    public String name() {
        return "predict";
    }

    @Override
    public Boolean run(Scanner sc) throws IOException {
        System.out.println("Pourriez-vous indiquer le chemin vers le fichier que vous souhaitez lire, svp ? ");
        try {
            String answer = sc.nextLine();
            Path path = Paths.get(answer);
            String content = Files.readString(path);
            content = content.toLowerCase();
            content = content.replaceAll("[^a-zA-Z0-9] ", " ");
            String[] words = content.split(" ");
            HashMap<String, Integer> innerMap = new HashMap<String, Integer>();
            HashMap<String, HashMap<String, Integer>> outerMap = new HashMap<String, HashMap<String, Integer>>();
            for (int i = 0; i < words.length; i++) {
                String c_word = words[i];
                for (int j = i + 1; j < words.length; j++) {
                    int count = 0;
                    String a_word = words[j];
                    for (int k = j+1; k < words.length; k++) {
                        if (a_word.equals(words[k])) {
                            count++;
                        }
                    }
                    innerMap.put(a_word, count);
                }
                List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(innerMap.entrySet());
                sortedEntries.sort(Comparator.<Map.Entry<String, Integer>, Integer>comparing(e -> e.getValue()).reversed());
                outerMap.put(c_word, innerMap);
            }
        } catch (IOException e) {
            System.out.println("Unreadable file: " + e.getClass().getName() + " " + e.getMessage());
        }


        return true;
    }
}
