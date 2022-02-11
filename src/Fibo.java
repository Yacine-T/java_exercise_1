import java.util.Scanner;

public class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public Boolean run(Scanner sc) {
        System.out.println("Enter a number :\n");
        int n = sc.nextInt();
        int nb1 = 0;
        int nb2 = 1;
        int nb3 = 0;
        for (int i = 2; i <= n; i++) {
            nb3 = nb1 + nb2;
            nb1 = nb2;
            nb2 = nb3;
        }
        System.out.println(nb3);
        return true;
    }

}
