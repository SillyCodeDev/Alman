import java.util.ArrayList;
import java.util.StringTokenizer;

public class Formatter {

    public String[] format(String input) {
        try {
            input = input.replace(";", ";\n");
            input = input.replace("{", "{\n");
            input = input.replace("}", "}\n");

            //make end
            String[] end = input.split("\n");
            int tabs = 0;
            String curTabs;
            for (int i = 0; i < end.length; i++) {
                curTabs = "";
                if(end[i].contains("}")) tabs--;
                for (int j = 0; j < tabs; j++) {
                    curTabs = curTabs + "    ";
                }
                end[i] = curTabs + end[i];
                if(end[i].contains("{")) tabs++;
                if(end[i].contains("import") || end[i].contains("}")) end[i] = end[i] + "\n";
            }

            return end;

        } catch (Exception e) {
            System.out.println(e + " Formatter");
            String[] e1 = new String[1];
            e1[0] = e.toString();
            return e1;
        }

    }


}
