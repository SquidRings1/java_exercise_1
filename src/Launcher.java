import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        System.out.println("Hello World");
        String actual_path = System.getProperty("user.dir");
        System.out.println("Current directory: " + actual_path);
        var scanner = new Scanner(System.in);
        List<Command> commands = new ArrayList<>();
        commands.add(new Quit());
        commands.add(new Fibo());
        commands.add(new Freq());

        for (;;) {
            String entry = scanner.nextLine();
            boolean commandfound = false;
            for (Command command : commands) {
                if (command.name().equals(entry)) {
                    if (command.run(scanner)) {
                        return;
                    }
                    commandfound = true;
                    break;
                }
            }
            if (!commandfound) {
                System.out.println("Unknown command");
            }
        }
    }
}
