/*
Time Complexity: O(N) (looping through pattern and words).
Space Complexity: O(N) (storing mappings in HashMap and HashSet).

The code uses a HashMap to map each character in the pattern to a corresponding word in s, and a HashSet to track already mapped words to avoid duplication.
It iterates over the pattern and words, checking if the character-word mappings are consistent. If any inconsistency is found, it returns false.
If the loop completes without mismatches, it returns true, indicating the pattern is followed correctly.
 */


class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < pattern.length(); i ++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) return false;
            } else {
                if (set.contains(word)) return false;
                map.put(c, word);
                set.add(word);
            }
        }
        return true;
    }
}
