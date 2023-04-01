import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BuildConfig {
    public static void build(Scanner scan) {
        File dir = new File("./config");
        if(!dir.exists()){
            dir.mkdirs();
        }
        try {
            FileWriter w  = new FileWriter(dir + "/" +"Keywords.txt");
            System.out.print("Use standard config?\n[Y/n]:");
            if(scan.nextLine().contains("Y")) {
                w.write("main(){ = public static void main(String[] args){\n");
                w.write("publik = public\n");
                w.write("klasse = class\n");
                w.write("statisch = static\n");
                w.write("nix = void\n");
                w.write("print = System.out.print\n");
                w.write("println = println\n");
            } else {
                System.out.println("Now you can create a Config. Exit with Ctrl + c or type ^C");
                while (true){
                    System.out.print("Write alias: ");
                    String in = scan.nextLine();
                    if(in.contains("^C")) break;
                    System.out.print("Write insert (need to be java code): ");
                    String in2 = scan.nextLine();
                    if(in2.contains("^C")) break;
                    w.write(in.trim() + " = " + in2.trim());
                }
            }
            w.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
