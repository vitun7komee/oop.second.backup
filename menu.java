import java.io.IOException;

public class menu {

    static void show() {
        System.out.println("\nSelect the search method:");
        System.out.println("\t[1] Naive algorithm");
        System.out.println("\t[2] The algorithm of Knuta-Morrisa-Pratta");
        System.out.println("\t[3] The algorithm of Rabin-Karp");
        System.out.println("\t[4] Input new string");
        System.out.println("\t[5] Input new substring");
        System.out.println("\t[6] Exit");
    }

    static Integer getChoice() throws IOException {
        Integer choice = -1;
        do {
            choice = InputHandler.integer();
            if (choice < 1 || choice > 6)
                System.out.println("Please enter a number between 1 and 6!");
        } while (choice < 1 || choice > 6);
        return choice;
    }
}
