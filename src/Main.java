import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //set up the classes
        BuildJava BJ = new BuildJava();
        ReadFile RF = new ReadFile();

        //check for config
        try (BufferedReader ignored1 = new BufferedReader(new FileReader("config/Keywords.txt"))){

        } catch (Exception e) {
            System.out.println("Config missing.");
            BuildConfig.build(scan);
        }

        //ask for commands
        System.out.println("Type help for help.");
        while (true) {
            System.out.print("Alman Command>");
            String in = scan.nextLine().trim();
            switch (in) {
                case "help":
                    System.out.println("build = build a .java file");
                    //System.out.println("run = run a .java file");
                    //System.out.println("jar = jar the input file ");

                    //exit as last
                    System.out.println("exit = to exit");
                    break;

                case "build":
                    Commands.build(scan);
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    if (in.contains("build")) {
                        Commands.build(in);
                    }

                    //command failed
                    else {
                        System.out.println("Command not found.");
                    }

                    break;
            }
        }


    }
}