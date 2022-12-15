import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\универ\\3 сем\\java\\lab 2\\task 2_28\\src\\input.txt");
        Scanner sc = new Scanner(fr);
        int width = sc.nextInt();
        int length = sc.nextInt();
        int[][] matrix = new int[length][width];

        for (int y = 0; y < width; y++) {
            for (int x = 0; x < length; x++) {
                matrix[y][x] = sc.nextInt();
            }
        }
        sc.close();

        int result = 1;
        for(int y = 0; y < matrix.length; y++) {
            int lineSelfMultiply = 0;
            if (y != matrix.length - 1) {
                for (int yPair = y + 1; yPair < matrix.length; yPair++) {
                    int linePairMultiply = 0;
                    for (int x = 0; x < matrix[y].length; x++) {
                        linePairMultiply += matrix[y][x] * matrix[yPair][x];
                        if (yPair == y + 1) {
                            lineSelfMultiply += matrix[y][x] * matrix[y][x];
                        }
                    }
                    if (linePairMultiply != 0) {
                        result = 0;
                    }
                }
            } else {
                for (int x = 0; x < matrix[y].length; x++) {
                    lineSelfMultiply += matrix[y][x] * matrix[y][x];
                }
            }
            if (lineSelfMultiply != 1) {
                result = 0;
            }
        }
        //System.out.println(result);
        if (result == 1){
            System.out.println("Matrix is ortonormical");
        }
        else {
            System.out.println("Matrix is not ortonormical");
        }
    }

}