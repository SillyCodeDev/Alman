import java.io.*;
import java.util.Scanner;

public class Commands {
    private static BuildJava BJ = new BuildJava();
    private static ReadFile RF = new ReadFile();
    public static String build(Scanner scan){
        while (true) {


            System.out.print("Insert File name>");
            String in = scan.nextLine();

            if (!in.contains(".")) {
                in = in + ".alman";
            }

            String filename = in;
            try (BufferedReader ignored = new BufferedReader(new FileReader(filename))) {
                BJ.build(RF.code(filename), RF.keywords());
                break;
            } catch (IOException e) {
                System.out.println("File doesn't exists. Try Again.");
            }
            return filename.split(".")[0];

        }
        return null;
    }

    public static void build(String in) {
        try {
            String aha = in.split(" ")[1];
            if (!aha.contains(".")) {
                aha = aha + ".alman";
            }
            BJ.build(RF.code(aha), RF.keywords());
        } catch (IOException e) {
            System.out.println("Build command failed because of the arguments.");
        }
    }

}
