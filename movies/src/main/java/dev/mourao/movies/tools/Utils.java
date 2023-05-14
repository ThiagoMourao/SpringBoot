package dev.mourao.movies.tools;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Utils {

    private static final Logger log = Logger.getLogger(Utils.class);

    public static Boolean detectPlagium(String original, String possibleCopy) {
        var string1 = original;
        if (string1.isBlank()) {
            string1 = "This is a test string with more than fifty characters. This is a test string with more than fifty characters.";
        }

        var string2 = possibleCopy;
        if (string2.isBlank()) {
            string2 = "This is a test string with more than fifty characters. This is a test string with more than fifty characters.";
        }

        int maxCharacter = 50;
        int count = 0;
        for (int i = 0; i < string1.length(); i++) {
            for (int j = i + 1; j <= string1.length(); j++) {
                var substring = string1.substring(i, j);
                if (substring.length() > maxCharacter && string2.contains(substring)) {
                    count++;
                }
            }
        }
        return count > 0;
    }

    public static Optional<Integer> bitwiseComparator(int number1, int number2) {
        return Optional.of(number1 & number2);
    }

    public static String getText(String v1) {
        try {
            Optional<String> test = Optional.ofNullable(v1);
            return test.orElseGet(() -> "");
        } catch (ArithmeticException ex) {
            log.error("Unable to get value");
            return "";
        }
    }

    public static String getText2(String v1) {
        try {
            return Objects.requireNonNullElse(v1, "");
        } catch (ArithmeticException ex) {
            log.error("Unable to get value");
            return "";
        }
    }
}
