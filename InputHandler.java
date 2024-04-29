import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {
    
    static String string() throws IOException {
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        do {
            System.out.print("--> ");
            string = bfn.readLine().toLowerCase();
            if (string.isEmpty())
                System.out.println("\nPlease enter valid string: ");
        } while (string.isEmpty());
        return string;
    }

    static Integer integer() throws IOException
    {
       
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));
        String digit = null;
        boolean isValidNumeric = false;
        do {
            System.out.print("--> ");
            digit = bfn.readLine();
            isValidNumeric = !digit.isEmpty() && isNumeric(digit);
            if (!isValidNumeric)
                System.out.println("\nPlease enter valid number: ");
        } while (!isValidNumeric);
        return Integer.parseInt(digit);
    }

    static boolean isNumeric(String string)
    {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
