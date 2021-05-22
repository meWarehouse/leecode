package com.at.jz;

import com.at.Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zero
 * @create 2021-05-13 16:48
 */
public class JZ2 {


    public static void main(String[] args) {

    }


    public String replaceSpace (String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            sb.append(c==' '?"%20":c);
        }
        return sb.toString();

    }


    public String replaceSpace2 (String s) {
        // write code here

        String replace = s.replace(" ", "%20");

        Matcher matcher = Pattern.compile(s).matcher(" ");
        String all = matcher.replaceAll("%20");

//        Pattern.compile(target.toString(), Pattern.LITERAL).matcher(his).replaceAll(Matcher.quoteReplacement(replacement.toString()));

        return all;
    }

    public static StringBuilder builder;

    public String replaceSpace1 (String s) {
        // write code here

        builder = new StringBuilder(s);

        replace();

        return builder.toString();
    }


    public void replace(){

        int index = builder.lastIndexOf(" ");

        if(index == -1) return;

        builder.replace(index,index+1,"%20");

        replace();

    }
}
