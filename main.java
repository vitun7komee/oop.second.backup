import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        System.out.println("\nEnter string:");
        String string = InputHandler.string();

        System.out.println("\nEnter substring:");
        String substring = InputHandler.string();

        boolean loop = true;
        Template template = new Naive();

        while (loop) 
        {
            menu.show();

            switch (menu.getChoice()) {
                case 1:
                    template = new Naive();
                    break;
                case 2:
                    template = new KnutaMorrisaPratta();
                    break;
                case 3:
                    template = new RabinKarp();
                    break;
                case 4:
                    System.out.println("Enter string:");
                    string = InputHandler.string();
                    break;
                case 5:
                    System.out.println("Enter substring:");
                    substring = InputHandler.string();
                    break;
                case 6:
                    loop = false;
                    break;
            }

            if (loop)
                System.out.println(template.isSubstring(string, substring));
        }
    }
}
