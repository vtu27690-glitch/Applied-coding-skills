import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert the character counts into a unique key
            String key = Arrays.toString(count);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}



Input
strs =
["eat","tea","tan","ate","nat","bat"]
Output
[["eat","tea","ate"],["bat"],["tan","nat"]]
Expected
[["bat"],["nat","tan"],["ate","eat","tea"]]
