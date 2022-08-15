package com.epam.tat.listprocessor.impl;

import com.epam.tat.listprocessor.IListProcessor;

import java.util.*;
import java.util.function.Function;

/**
 * Function Description:
 * Complete the functions below. All methods must work with list of String.
 * <p>
 * In case of incorrect input values or inability to perform an action, the method should throw an appropriate
 * exception.
 */
public class ListProcessor implements IListProcessor {
    /**
     * Find the second by length string in a list.
     * <p>
     * Ex.:
     * From list:
     * {"a", "aa", "aaaaa", "aaaa", "aaa"}
     * will be return "aaaa"
     *
     * @param list - input data
     * @return second by length string in the input list
     */
    @Override
    public String getSecondStringByLength(List<String> list) {
        list.sort(Comparator.comparing(String::length));
        return list.get(list.size() - 2);
    }

    /**
     * Sort list by string length.
     * <p>
     * Ex.:
     * From list:
     * {"a", "aa", "aaA", "aAa", "aaa", "Aa"}
     * will be return
     * {"a", "Aa", "aa", "aAa", "aaA", "aaa"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByLength(List<String> list) {
        list.sort(Comparator.comparing(String::length));
        return list;
    }

    /**
     * Sort list or array by count of vowels in string.
     * If the number of vowels in several words is the same, the order is alphabetical.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Nike", "Puma", "Adidas", "Timberland"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByCountOfVowels(List<String> list) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'));
        Function<String, Integer> getCount = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                int count = 0;
                for (int i = 0; i < s.length(); i++)
                    count += set.contains(s.charAt(i)) ? 1 : 0;
                return count;
            }
        };
        Comparator<String> comparator = (s1, s2) -> Integer.compare(getCount.apply(s1), getCount.apply(s2));

        list.sort(comparator.thenComparing(String::compareTo));
        return list;
    }


    /**
     * Sort list or array by count of consonants in string.
     * If the number of consonants in several words is the same, the order is alphabetical.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Nike", "Puma", "Adidas", "Timberland"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByCountOfConsonants(List<String> list) {
        Set<Character> set = new HashSet<>(Arrays.asList('b', 'c', 'd', 'f', 'g', 'h',
                'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z',
                'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z'));
        Function<String, Integer> getCount = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                int count = 0;
                for (int i = 0; i < s.length(); i++)
                    count += set.contains(s.charAt(i)) ? 1 : 0;
                return count;
            }
        };
        Comparator<String> comparator = (s1, s2) -> Integer.compare(getCount.apply(s1), getCount.apply(s2));

        list.sort(comparator.thenComparing(String::compareTo));
        return list;
    }

    /**
     * Change by places first and last symbols in each second string of list.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Puma", "eikN", "Timberland", "sdidaA"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list) {
        for (int i = 1; i <= list.size(); i = i + 2) {
            if (list.get(i).length() >= 2) {
                char[] chars = list.get(i).toCharArray();
                char first = chars[0];
                chars[0] = chars[chars.length - 1];
                chars[chars.length - 1] = first;
                String str = new String(chars);
                list.set(i, str);
            }
        }
        return list;
    }

    /**
     * Revert strings of list.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"amuP", "ekiN", "dnalrebmiT", "sadidA"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> reverseStringsOfList(List<String> list) {
        List<String> reversedList = new ArrayList<>();
        for (String s : list) {
            reversedList.add(new StringBuilder(s).reverse().toString());
        }

        return reversedList;
    }
}
