package com.example.regina.myapplication.algorithm;

/**
 * Created by Allan Zhu on 2019-03-23.
 */
public class RemoveVowels {
    private static String removeV(String string) {
        // TODO Auto-generated method stub
        StringBuffer sb = new StringBuffer();
        String vowel ="aeiouAEIOU";

        for(int i = 0; i < string.length(); i++)
        {
            char c = string.charAt(i);
            if(vowel.indexOf(c) == -1)
                sb.append(c);
        }
        return sb.toString();
    }


}
