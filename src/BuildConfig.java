import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildConfig {
    public static void build(Scanner scan) {
        ArrayList<String> s = new ArrayList<>();
        try {
            System.out.print("Use standard config?\n[Y/n]:");
            if(scan.nextLine().contains("Y")) {
                s.add("main(){ = main(String[] args){");
                s.add("publik = public");
                s.add("klasse = class");
                s.add("statisch = static");
                s.add("nix = void");
                s.add("print = System.out.print");
                s.add("println = println");
            } else {
                System.out.println("Now you can create a Config. Exit with Ctrl + c or type ^C");
                while (true){
                    System.out.print("Write alias: ");
                    String in = scan.nextLine();
                    if(in.contains("^C")) break;
                    System.out.print("Write insert (need to be java code): ");
                    String in2 = scan.nextLine();
                    if(in2.contains("^C")) break;
                    s.add(in.trim() + " = " + in2.trim());
                }
            }

            File dir = new File("./config");
            if(!dir.exists()){
                dir.mkdirs();
            }
            FileWriter w  = new FileWriter(dir + "/" + "Keywords.txt");
            for (int i = 0; i < s.size(); i++) {
                w.write(s.get(i) + "\n");
            }
            w.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
