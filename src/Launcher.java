import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Entrer un chaine de caractères");
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        if (txt.equals("quit"))
        {
            System.out.println("You're exiting the program");
        }
        else
        {
            while(!txt.equals("quit"))
            {
                System.out.println("Unknown command");
                txt = sc.nextLine();
            }
            System.out.println("You're exiting the program");
        }
    }
}
