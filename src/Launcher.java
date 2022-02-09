import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Enter a command, please :");
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        if (txt.equals("quit"))
        {
            System.out.println("You're exiting the program ...");
        }
        else if (txt.equals("fibo"))
        {
            System.out.println("Enter e number, please : ");
            String n = sc.nextLine();
            int res = fibo(Integer.parseInt(n));
            System.out.println("The result of fibonacci suite  for the number " + n + "is " + res);

        }
        else
        {
            while(!txt.equals("quit"))
            {
                System.out.println("Unknown command !");
                System.out.println("Enter a command, please :");
                txt = sc.nextLine();
            }
            System.out.println("You're exiting the program ...");
            System.out.println("Program exited !");
        }
    }

    public static int fibo(int n)
    {
        int nb1 = 0;
        int nb2 = 1;
        int nb3 = 0;
        for(int i = 2; i < n; i++)
        {
            nb3 = nb1 + nb2;
            nb1 = nb2;
            nb2 = nb3; 
        }
        return nb3;   
    }
}
