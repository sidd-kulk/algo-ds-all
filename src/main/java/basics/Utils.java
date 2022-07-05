package basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class Utils {

    public static int max(int... nums) {
        return Arrays.stream(nums).max().orElseThrow();
    }

    public static int min(int... nums) {
        return Arrays.stream(nums).min().orElseThrow();
    }

    public static String sortString(String s) {
        return s.chars().sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append).toString();
    }

    public static Map frequencyMap(String s) {
        if (s == null) return null;

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }

        return map;
    }
}
