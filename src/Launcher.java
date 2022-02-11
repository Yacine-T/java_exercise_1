import java.io.IOException;
import java.util.*;

public class Launcher {
    public static void main(String[] args) throws IOException {
        List<Command> cmd = new ArrayList<Command>();
        cmd.add(new Quit());
        cmd.add(new Fibo());
        cmd.add(new Freq());
        cmd.add(new Predict());

        System.out.println("Enter a command, please :\n");
        try (Scanner sc = new Scanner(System.in)) {
            String txt = sc.nextLine();
            while (!txt.equals(cmd.get(0).name())) {

                if (txt.equals(cmd.get(1).name())) {
                    cmd.get(1).run(sc);
                    System.exit(0);

                } else if (txt.equals(cmd.get(2).name())) {
                    cmd.get(2).run(sc);
                    System.exit(0);
                } else if (txt.equals(cmd.get(3).name())) {
                    cmd.get(3).run(sc);
                    System.exit(0);
                } else {

                    System.out.println("Unknown command !");
                    System.out.println("Enter a command, please :");
                    txt = sc.nextLine();
                }
            }
            cmd.get(0).run(sc);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
