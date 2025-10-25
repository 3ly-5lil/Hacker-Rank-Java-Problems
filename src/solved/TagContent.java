package solved;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContent {
    public static void main(String[] args) {
        String line = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>";

        //Write your code here
        String regex = "<([^>]+)>([^<]+)</\\1>";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(line);

        while (m.find()) {
            String content = m.group(2);
            System.out.println(content);
        }

    }
}



