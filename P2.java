/*
Time Complexity (TC)
O(n), where n is the length of the strings, as we iterate through them once.

Space Complexity (SC)
O(1), since at most 26 character mappings are stored in the HashMap and HashSet.

Explanation in Three Sentences
The function first checks if the lengths of s and t are different; if so, they cannot be isomorphic.
A HashMap stores mappings from characters in s to t, and a HashSet ensures that no two different characters from s map to the same character in t.
If a conflict arises (i.e., a character in s maps to a different character in t than before, or a character in t is already mapped to a different character), the function returns false; otherwise, it returns true.
 */


class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++)

        {

            char c = s.charAt(i);

            char d = t.charAt(i);

            if (!map.containsKey(c))

            {

                if (set.contains(d))

                    return false;

                map.put(c, d);

                set.add(d);

            }

            else

            {

                if (map.get(c) != d)

                {
                    set.add(d);

                    return false;
                }

            }

        }
        return true;
    }
}