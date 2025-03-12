/*
Time Complexity (TC):
O(N * M), where N is the number of words and M is the maximum length of a word (since we iterate through each word and construct a fixed-size frequency array of 26).

Space Complexity (SC):
O(N * M), as we store N words in a HashMap with string keys (each key is a 26-length array converted to a string).

Code Explanation in Three Sentences:
We create a HashMap where keys are character frequency arrays (converted to strings), ensuring anagrams have the same key.
For each word, we compute its character frequency and group it under the corresponding key in the HashMap.
Finally, we return the values of the HashMap, which are lists of grouped anagrams.
 */

 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store grouped anagrams
        // Key: Character frequency representation of the word
        // Value: List of words (anagrams) with the same character count
        Map<String, List<String>> res = new HashMap<>();

        // Iterate through each word in the input array
        for (String s : strs) {
            // Character frequency array of size 26 for 'a' to 'z'
            int[] count = new int[26];

            // Count the occurrences of each character in the word
            for (char c : s.toCharArray()) {
                count[c - 'a']++; // Increment the count for the corresponding character
            }

            // Convert the frequency array to a unique string key
            String key = Arrays.toString(count);

            // If the key does not exist, initialize a new list
            res.putIfAbsent(key, new ArrayList<>());

            // Add the current word to the corresponding anagram group
            res.get(key).add(s);
        }

        // Return all grouped anagrams as a list
        return new ArrayList<>(res.values());
    }
}