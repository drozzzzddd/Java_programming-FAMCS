import java.io.*;
import java.text.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("D:\\универ\\3 сем\\java\\lab 2\\task 2_8\\src\\input.txt");
        Scanner sc = new Scanner(fr);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(var i : matrix){
            for(int j = 0; j < m;j++){
                i[j] =sc.nextInt();
            }
        }

        int counter = 0;
        int tmpCounter = 0;
        int answer = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    tmpCounter++;
                    if (j == matrix[i].length -2){
                        if (tmpCounter > counter) {
                            counter = tmpCounter;
                            answer = i;
                        }
                        tmpCounter = 0;
                    }
                }
                if (matrix[i][j] != matrix[i][j + 1]) {
                    if (tmpCounter > counter) {
                        answer = i;
                        counter = tmpCounter;
                    }
                    tmpCounter = 0;
                }
                //   if(matrix[i][j] == matrix[i][j])
            }
        }
        if(answer == 0) {
            System.out.print("No such line!");
        }
        else
            System.out.print("Line " + answer + " contains the longest sequence of identical elements (line numbering starts from 0!)");
    }
}