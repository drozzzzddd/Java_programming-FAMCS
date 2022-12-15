package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;
import java.text.NumberFormat;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Main {
    public static double ArrangeInRowTeylor(int k, double x) {
        double y = x;
        double s = x;
        double epsilon = pow(10.0, -k);

        if (x > 1 || x < -1) {
            return Double.parseDouble("NaN");
        }

        for (int i = 1; abs(y) >= epsilon; i++) {
            y = (((2 * i) - 1) * ((2 * i) - 1) * y * x * x) / (2 * i) / ((2 * i) + 1);
            s += y;
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        System.out.println( ArrangeInRowTeylor(3, -2));
    }
}