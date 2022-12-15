import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("D:\\универ\\3 сем\\java\\lab 2\\task 2_18\\src\\input.txt");
        Scanner sc = new Scanner(fr);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int y = 0; y < n; y++) { //строки
            for (int x = 0; x < m; x++) {
                matrix[y][x] = sc.nextInt();
            }
        }

        int count = 0;
        Set<Integer> column = new HashSet<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                column.add(matrix[y][x]);
            }
            if (column.size() == matrix.length)  {
                count++;
            }
            column.clear();
        }
        System.out.println("This matrix has" + " " + count + " " + "unique columns.");
    }
}