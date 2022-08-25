package task_2.load_instruments;

import java.util.Arrays;

public class LinkParser {
    public static String parseLink(String link) {
        return Arrays.stream(link.split("/")).reduce(((s1, s2) -> s2)).get();
    }
}