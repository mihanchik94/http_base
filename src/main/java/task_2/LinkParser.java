package task_2;

import java.util.Arrays;

public class LinkParser {
    public static String parse(String link) {
        return Arrays.stream(link.split("/")).reduce((s, s1) -> s1).get();
    }
}