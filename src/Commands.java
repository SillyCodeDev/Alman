import java.io.*;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

public class Commands {
    private static final BuildJava BJ = new BuildJava();
    private static final ReadFile RF = new ReadFile();
    public static String build(Scanner scan){
        while (true) {
            System.out.print("Insert File name>");
            String in = scan.nextLine();

            if (!in.contains(".")) {
                in = in + ".alman";
            }

            String filename = in;
            try (BufferedReader ignored = new BufferedReader(new FileReader(filename))) {
                return BJ.build(RF.code(filename), RF.keywords());
            } catch (IOException e) {
                System.out.println("File doesn't exists. Try Again.");
            }
        }

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

    public static void run(String in){
        String aha = in.split(" ")[1];
        if (!aha.contains(".")) {
            aha = aha + ".alman";
        }
        try {
            runShell(BJ.build(RF.code(aha), RF.keywords()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void run(Scanner scanner){
        runShell(build(scanner));
    }

    private static void runShell(String filename){
        try {
            Runtime.getRuntime().exec("cmd /c start  \"Run " + filename  + "\" cmd.exe /K \"cd JavaOut && javac " +
                    filename + ".java &&  java " +
                    filename + "&& echo.  && echo " + filename +" End && pause && exit\"");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
