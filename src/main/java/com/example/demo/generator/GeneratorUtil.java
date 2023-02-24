package com.example.demo.generator;

public class GeneratorUtil {

    public static String nextCode(String current) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;

        for (int i = current.length() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                int charParse = current.charAt(i) + carry;
                if (charParse > 122) {
                    charParse = charParse - 26;
                } else {
                    carry = 0;
                }
                stringBuilder.append((char) charParse);
            } else {
                int intParse = Integer.parseInt(String.valueOf(current.charAt(i))) + carry;
                if (i == current.length() - 1) {
                    intParse = intParse + 1;
                }
                carry = intParse / 10;
                intParse = intParse % 10;
                stringBuilder.append(intParse);
            }
        }

        if (carry > 0) {
            stringBuilder.append("0a");
        }

        return stringBuilder.reverse().toString();
    }
}
