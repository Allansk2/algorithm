package com.example.regina.myapplication.algorithm;

/**
 * Created by Allan Zhu on 2019-03-23.
 */
public class GreatestCommonDivisor {

    public static int gcd(int m, int n)
    {
        if(m % n == 0)
            return n;
        else
            return gcd(n, m % n);

    }

    private static int gcdArray(int[] array) {
        // TODO Auto-generated method stub
        if(array == null)
            return 0;
        if(array.length == 0)
            return 0;
        if(array.length < 2)
            return array[0];

        int x = array[0];

        for(int i = 1; i < array.length; i++)
        {
            if(array[i] > 0 && x > 0)
                x = gcd(x,array[i]);
            else
                return 0;
        }

        return x;
    }

}
