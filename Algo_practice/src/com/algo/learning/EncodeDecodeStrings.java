package com.algo.learning;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    public String encode(List<String> planStrings) {
        // use | as separator
        StringBuilder stringBuilder = new StringBuilder();
        for (String str: planStrings
             ) {
        stringBuilder.append("|")
                     .append(str.length())
                     .append(str);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String encodedString) {
        List<String> originalStrings = new ArrayList<>();
        int pipe=0;
        int start = pipe+2;
        int end = 0;
        int length = 0;
        if (!encodedString.isEmpty()) {
            length = Character.getNumericValue(encodedString.charAt(pipe+1));
            end = start+length;
        }
        String word = encodedString.substring(start,end);
        originalStrings.add(word);
        while (end<encodedString.length()) {
            if(end <= encodedString.length()) {
                pipe = end;
                start = pipe+2;
                length = Character.getNumericValue(encodedString.charAt(pipe+1));
                end = start+length;
                word = encodedString.substring(start,end);
                originalStrings.add(word);
            }
        }
        return originalStrings;
    }
    public static void main(String[] args) {
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        String encoded = encodeDecodeStrings.encode(List.of("lint", "code", "love", "you"));
        System.out.println(encoded);
        System.out.println(encodeDecodeStrings.decode(encoded));
    }
}
