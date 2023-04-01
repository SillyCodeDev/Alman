import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteJava {
    public static void toFile(String [] lines, String filename) throws IOException {
        String[] name = filename.split("\\.");
        File dir = new File("./JavaOut");
        if(!dir.exists()){
            dir.mkdirs();
        }
        FileWriter w = new FileWriter(dir + "/" + name[0] + ".java");
        for (int k = 0; k < lines.length; k++) {
            if(k == lines.length - 1){
                w.write(lines[k]);
            } else {
                w.write(lines[k] + "\n");
            }

        }
        w.close();

    }
}
