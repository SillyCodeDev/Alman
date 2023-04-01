import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

public class ReadFile {
    public String code(String filename){
        //vars
        int lineNumb = 0;
        String[] res;
        BufferedReader br;
        StringJoiner join = new StringJoiner("");

        try {
            br = new BufferedReader(new FileReader(filename));

            Path path = Paths.get(filename);
            lineNumb = (int) Files.lines(path).count();


            String in;

            for (int i = 0; i < lineNumb; i++) {
                in = br.readLine().trim();
                if(in != null){
                    join.add(in);
                }

            }
            br.close();
            res = delUnusedLines(join.toString());
            if(res.length == 1){
                return res[0];
            } else if(res.length == 0){
                System.out.println("File is Empty.");
                System.exit(2);
            } else {
                System.out.println("Something went wrong with the File.");
                System.exit(2);
            }

        } catch (Exception e) {
            // scheisse gelaufen
            System.out.println(e + " ReadFile:49");
        }


        return null;
    }


    private String[] delUnusedLines(String inputString) {

        //vars

        /*  haut bloß 2 weg
        String[] j = join.toString().split(Pattern.quote("||"));
        for (int k = 0; k < j.length; k++) {
            join2.add(j[k]);
        }
        */

        String[] s = inputString.split("  ");

        int lines = 0;

        for (int i = 0; i < s.length; i++) {
            //System.out.println(s[i]);
            if(!s[i].equals("")){
                lines++;
            }
        }


        String[] resultStrings = new String[lines];
        lines = 0;

        for (int i = 0; i < s.length; i++) {
            //System.out.println(s[i]);
            if(!s[i].equals("")){
                resultStrings[lines] = s[i];
                lines++;
            }
        }


        return resultStrings;
    }


    public String[] keywords() throws IOException {
        //vars
        String[] result;
        StringJoiner join = new StringJoiner(";");
        String line;

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("./config/Keywords.txt"));

            while (true) {
                line = br.readLine();

                if(line != null){
                    join.add(line.trim());
                } else {
                    break;
                }
            }

            result = join.toString().split(";");

            br.close();

            return result;

        } catch (FileNotFoundException e) {
            // scheise gelaufen
        }


        return null;
    }
}
