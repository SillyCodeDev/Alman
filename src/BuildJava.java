import java.util.regex.Pattern;

public class BuildJava {

    public String build(String inputString, String[] keywordFileStrings) {
        try {
            // separate the keywords
            //vars
            String[] keywords = new String[keywordFileStrings.length];
            String[] insertKeywordsWords = new String[keywordFileStrings.length];

            // get the keywords in the Strings
            for (int i = 0; i < insertKeywordsWords.length; i++) {
                keywords[i] = keywordFileStrings[i].split("=")[0].trim();
                insertKeywordsWords[i] = keywordFileStrings[i].split("=")[1].trim();
            }

            //replace in file bzw. inputString

            for (int i = 0; i < keywords.length; i++) {
                inputString = inputString.replace(keywords[i], insertKeywordsWords[i]);

            }

            //make class name to file name
            String filename = "RenamePls";
            if (inputString.contains("class")) {
                String[] line = inputString.split(Pattern.quote("{"));
                String[] classSplit = line[0].split("class");
                filename = classSplit[1].trim();
            }

            Formatter formatter = new Formatter();
            try {
                WriteJava.toFile(formatter.format(inputString), filename);
                return filename;
            } catch (Exception e) {
                // scheisse
                System.out.println(e + " BuildJava:36");
            }
        } catch (Exception e){

        }
        return null;

    }
}
