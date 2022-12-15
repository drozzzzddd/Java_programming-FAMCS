import java.io.*;
import java.util.Scanner;
import java.lang.String;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileFilter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Vector;
public class Main {
    public static void main(String[] args) throws IOException {
        FileReader file_reader = new FileReader("D:\\универ\\3 сем\\java\\lab 5\\out\\production\\counters\\input.txt");
        Scanner sc = new Scanner(file_reader);
        String text = sc.nextLine();
        file_reader.close();
        FileWriter fw = new FileWriter("D:\\универ\\3 сем\\java\\lab 5\\out\\production\\counters\\output.txt");
        fw.write(text);
        fw.write('\n');
        fw.write("after find:");
        fw.write('\n');
        String[] all = text.split("[\\s\\,\\;\\ ]");

        double i;
        int x;
        for (String one : all) {
            if (one != "") {
                if (one.matches("((\\+||\\-)?([0-9]\\.?\\d*))") == true) {
                    fw.write(one);
                    fw.write('\n');
                }
            }
        }
        fw.close();
    }
}