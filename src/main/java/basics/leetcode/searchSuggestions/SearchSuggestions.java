package basics.leetcode.searchSuggestions;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/search-suggestions-system/
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null || searchWord == null || products.length == 0 || searchWord.length() == 0) return null;


        List<List<String>> returnVal = new ArrayList<>(searchWord.length());

        Arrays.sort(products);

        for (int i = 0; i < searchWord.length(); i++) {
            String subString = searchWord.substring(0, i + 1);
            List<String> l = new ArrayList<>(products.length);
            for (String product : products) {
                if (product.startsWith(subString) && l.size() < 3) {
                    l.add(product);
                }
            }
            returnVal.add(l);
        }
        return returnVal;
    }

}

public class SearchSuggestions {
    public static void main(String[] args) {
        var res = new Solution().suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
        var expectedOutput = Arrays.asList(Arrays.asList("mobile", "moneypot", "monitor"),
                                              Arrays.asList("mobile", "moneypot", "monitor"), Arrays.asList("mouse", "mousepad"),
                                              Arrays.asList("mouse", "mousepad"), Arrays.asList("mouse", "mousepad")).toArray();
    // TODO:  too complex to compare.  Later.
    }
}
