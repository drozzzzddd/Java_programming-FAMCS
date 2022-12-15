package org.example;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static java.lang.Math.*;
import static org.example.Main.ArrangeInRowTeylor;

import static java.lang.Math.sqrt;


public class MainTest {
    @Test
    public void FirstTest(){
        double x = 0.1;
        int k = 3;
        double expected = asin(x);
        double result = ArrangeInRowTeylor(k,x);

        Assertions.assertEquals(expected, result,k);
    }

    @Test
    public void SecondTest(){
        double x = -0.1;
        int k = 3;
        double expected = asin(x);
        double result = ArrangeInRowTeylor(k,x);

        Assertions.assertEquals(expected, result,k);
    }
    @Test
    public void ThirdTest(){
        int x = 2;
        int k = 0;
        String expected = String.valueOf(asin(x));
        String result = String.valueOf(ArrangeInRowTeylor(k,x));

        Assertions.assertEquals(Double.parseDouble(expected), Double.parseDouble(result),k);
    }
}