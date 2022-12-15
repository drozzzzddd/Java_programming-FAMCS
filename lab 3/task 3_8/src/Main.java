import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.util.regex.Pattern;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Main {

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


    public static void main(String[] args) throws IOException {
        String filePath = "D:\\универ\\3 сем\\java\\лаба 3\\strings_lab\\src\\input.txt";

        String str = null;
        try {
            str = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(str);


        Scanner sc = new Scanner(System.in);
        char consonant[] = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ'};
        // int n = sc.nextInt();


        String[] splitString = (str + " ").split("\\p{P}?[ \\t\\n\\r]+");
        String ourFinalString = new String();


        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i].length() != 5) {
                ourFinalString += splitString[i].concat(" ");
                continue;
            } else {
                for (int j = 0; j < consonant.length; j++) {
                    if (splitString[i].toLowerCase().startsWith(String.valueOf(consonant[j]))) {
                        break;
                    }
                    if (j == consonant.length - 1) {
                        ourFinalString += splitString[i].concat(" ");
                    }
                }
            }
        }
        System.out.println(ourFinalString);
        System.out.println();
    }
}
