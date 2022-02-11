import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Freq implements Command{
    @Override
    public String name() {

        return "freq";
    }

    @Override
    public Boolean run(Scanner sc) throws IOException {
        System.out.println("Pourriez-vous indiquer le chemin vers le fichier que vous souhaitez lire, svp ? ");
        String answer = sc.nextLine();
        Path path = Paths.get(answer);
        String content = Files.readString(path);
        content = content.toLowerCase();
        content = content.replaceAll("[^a-zA-Z0-9] ", " ");
        String[] words = content.split(" ");
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

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordsOcc.entrySet());
        sortedEntries.sort(Comparator.<Map.Entry<String, Integer>, Integer>comparing(e -> e.getValue()).reversed());
        for (int i = 0; i < 3; i++) {
            System.out.print(sortedEntries.get(i).getKey() + " ");
        }
        return true;
    }
}
