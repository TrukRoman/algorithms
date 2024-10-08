package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String str = "cccaaa";
        System.out.println(frequencySort(str));
    }

    private static String frequencySort(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            charCountMap.computeIfPresent(symbol, (k, v) -> ++v);
            charCountMap.putIfAbsent(symbol, 1);
        }

        TreeMap<Integer, Set<Character>> countCharListMap = new TreeMap<>(Comparator.reverseOrder());
        charCountMap.forEach((character, count) -> {
            Set<Character> characters = countCharListMap.get(count);
            if (characters != null) {
                characters.add(character);
            } else {
                Set<Character> characterSet = new HashSet<>();
                characterSet.add(character);
                countCharListMap.put(count, characterSet);
            }
        });

        StringBuilder result = new StringBuilder();
        countCharListMap.forEach((count, characters) -> {
            for (Character character : characters) {
                result.append(String.valueOf(character).repeat(count));
            }
        });

        return result.toString();
    }
}
