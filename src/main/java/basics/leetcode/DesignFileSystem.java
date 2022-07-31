package basics.leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/design-file-system/
public class DesignFileSystem {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        Assertions.assertTrue(fs.createPath("/leet", 1));
        Assertions.assertTrue(fs.createPath("/leet/code", 2));
        Assertions.assertEquals(1, fs.get("/leet"));
        Assertions.assertFalse(fs.createPath("/leet/code", 3));
        Assertions.assertFalse(fs.createPath("/leet/bad/fail", 3));
        Assertions.assertEquals(2, fs.get("/leet/code"));
    }
}

class FileSystem {

    private final Map<String, Integer> filePathToValuesMap;

    public FileSystem() {
        filePathToValuesMap = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (path == null || path.trim().length() == 0 || path.equals("/")) {
            return false;
        }

        String[] splitBySeparator = path.split("/");
        if (splitBySeparator.length > 0) {
            String s = "";

            for (int i = 0; i < splitBySeparator.length; i++) {

                if (splitBySeparator[i].equals("")) {
                    continue;
                }

                if (i < splitBySeparator.length - 1) {
                    s += "/" + splitBySeparator[i];
                }

                if (i < splitBySeparator.length - 1 && !filePathToValuesMap.containsKey(s)) {
                    return false;
                }


                if (i == splitBySeparator.length - 1) {
                    if (filePathToValuesMap.containsKey(s + "/" + splitBySeparator[i])) {
                        return false;
                    }

                    filePathToValuesMap.put(s + "/" + splitBySeparator[i], value);
                }
            }
        }
        // System.out.println(filePathToValuesMap);
        return true;

    }

    public int get(String path) {
        return filePathToValuesMap.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */