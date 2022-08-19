package com.epam.tat.listprocessor.impl;

import com.epam.tat.listprocessor.IListProcessor;
import com.epam.tat.listprocessor.exception.ListProcessorException;

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
        if (list.isEmpty()) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("Unexpected exception type thrown");
            throw new ListProcessorException("There are NO any values! Empty", e.getCause());
        } else if (list.size() == 1) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("Unexpected exception type thrown");
            throw new ListProcessorException("There is ONLY ONE value!", e.getCause());
        } else if (list.contains(null)) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("Unexpected exception type thrown");
            throw new ListProcessorException("There are NO any values! Empty list!", e.getCause());
        } else if (list.listIterator().toString().equals(list.listIterator().toString())) {
            throw new ListProcessorException("There is ONLY ONE value!");
        } else {
            list.sort(Comparator.comparing(String::length));
            return list.get(list.size() - 2);
        }
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
        if (list.isEmpty()) {
            throw new ListProcessorException("There are NO any values! Empty list!");
        } else if (list.contains(null)) {
            NullPointerException e = new NullPointerException("Unexpected exception type thrown");
            throw new ListProcessorException("There are NO any values! Empty list!", e.getCause());
        } else {
            list.sort(Comparator.comparing(String::length));
            return list;
        }
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
        if (list.isEmpty()) {
            throw new ListProcessorException("There are NO any values! Empty list!");
        } else if (list.contains(null)) {
            NullPointerException e = new NullPointerException("Unexpected exception type thrown");
            throw new ListProcessorException("The input list can't be null!", e.getCause());
        } else if (list.toString().contains(set.toString())) {
            throw new ListProcessorException("There is no one vowels!");
        } else {
            Comparator<String> comparator = (s1, s2) -> Integer.compare(getCount.apply(s1), getCount.apply(s2));
            list.sort(comparator.thenComparing(String::compareTo));
            return list;
        }
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
        if (list.isEmpty()) {
            throw new ListProcessorException("There are NO any values! Empty list!");
        } else if (list.listIterator().toString().contains(set.toString())) {
            throw new ListProcessorException("There are NO any consonants!");
        } else if (list.contains(null)) {
            NullPointerException e = new NullPointerException("Unexpected exception type throw");
            throw new ListProcessorException("The input list can't be null!", e.getCause());
        } else {
            Comparator<String> comparator = (s1, s2) -> Integer.compare(getCount.apply(s1), getCount.apply(s2));
            list.sort(comparator.thenComparing(String::compareTo));
            return list;
        }
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
        if (list.size() == 1) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("Unexpected exception type thrown");
            throw new ListProcessorException("There is ONLY ONE value! The method could not be executed!", e.getCause());
        } else if (list.isEmpty()) {
            throw new ListProcessorException("There are NO any values! Empty list!");
        } else if (list.contains(null)) {
            NullPointerException e = new NullPointerException("Unexpected exception type thrown");
            throw new ListProcessorException("The input list can't be null!", e.getCause());
        } else {
            for (int i = 1; i < list.size(); i = i + 2) {
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
        if (list.isEmpty()) {
            throw new ListProcessorException("There are NO any values! Empty list!");
        } else if (list.contains(null)) {
            NullPointerException e = new NullPointerException("Unexpected exception type thrown");
            throw new ListProcessorException("The input list can't be null!", e.getCause());
        } else {
            List<String> reversedList = new ArrayList<>();
            for (String s : list) {
                reversedList.add(new StringBuilder(s).reverse().toString());
            }
            return reversedList;
        }

    }
}
