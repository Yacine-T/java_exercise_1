import java.io.IOException;
import java.util.Scanner;

public interface Command {
    public abstract String name();
    public abstract Boolean run(Scanner sc) throws IOException;
}
