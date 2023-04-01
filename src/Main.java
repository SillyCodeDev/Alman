import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //check for config
        if (!new File("./config/Keywords.txt").exists()) {
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
                    System.out.println("run = run a .java file");

                    //exit as last
                    System.out.println("exit = to exit");
                    break;

                case "build":
                    Commands.build(scan);
                    break;

                case "run":
                    Commands.run(scan);
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    if (in.contains("build")) {
                        Commands.build(in);
                    } else if (in.contains("run")) {
                        Commands.run(in);
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