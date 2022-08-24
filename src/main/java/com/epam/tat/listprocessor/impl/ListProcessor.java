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
    private final static String unexpectedExceptionTypeThrown = "Unexpected exception type thrown";
    private final static String thereAreNoAnyValuesEmptyList = "There are NO any values! Empty list!";
    private final static String theInputListCannotBeNull = "The input list can't be null!";
    @Override
    public String getSecondStringByLength(List<String> list) {
        if (list == null || list.isEmpty()) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException(unexpectedExceptionTypeThrown);
            throw new ListProcessorException(thereAreNoAnyValuesEmptyList, e.getCause());
        } else if (list.size() == 1) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException(unexpectedExceptionTypeThrown);
            throw new ListProcessorException("There is ONLY ONE value!", e.getCause());
        } else {
            list.sort(Comparator.comparing(String::length));
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1).length() != list.get(i).length()) {
                    return list.get(list.size() - 2);
                }
            }
            throw new ListProcessorException("There is ONLY ONE value!");
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
        if (list == null) {
            NullPointerException e = new NullPointerException(unexpectedExceptionTypeThrown);
            throw new ListProcessorException(thereAreNoAnyValuesEmptyList, e.getCause());
        } else if (list.isEmpty()) {
            throw new ListProcessorException(thereAreNoAnyValuesEmptyList);
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
        Function<String, Integer> getCount = (s) -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++)
                count += set.contains(s.charAt(i)) ? 1 : 0;
            return count;
        };
        if (list == null) {
            NullPointerException e = new NullPointerException(unexpectedExceptionTypeThrown);
            throw new ListProcessorException(theInputListCannotBeNull, e.getCause());
        } else if (list.isEmpty()) {
            throw new ListProcessorException(thereAreNoAnyValuesEmptyList);
        } else if ((!list.toString().contains("a") && !list.toString().contains("e") && !list.toString().contains("i") &&
                !list.toString().contains("o") && !list.toString().contains("u") && !list.toString().contains("y") &&
                !list.toString().contains("A") && !list.toString().contains("E") && !list.toString().contains("I") &&
                !list.toString().contains("O") && !list.toString().contains("U") && !list.toString().contains("Y"))) {
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
        Function<String, Integer> getCount = (s) -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++)
                count += set.contains(s.charAt(i)) ? 1 : 0;
            return count;
        };
        if (list == null) {
            NullPointerException e = new NullPointerException(unexpectedExceptionTypeThrown);
            throw new ListProcessorException(theInputListCannotBeNull, e.getCause());

        } else if (!list.toString().contains("b") && !list.toString().contains("c") && !list.toString().contains("d") &&
                !list.toString().contains("f") && !list.toString().contains("g") &&
                !list.toString().contains("h") && !list.toString().contains("j") && !list.toString().contains("k") &&
                !list.toString().contains("l") && !list.toString().contains("m") && !list.toString().contains("n") &&
                !list.toString().contains("p") && !list.toString().contains("q") && !list.toString().contains("r") &&
                !list.toString().contains("s") && !list.toString().contains("t") && !list.toString().contains("v") &&
                !list.toString().contains("w") && !list.toString().contains("x") && !list.toString().contains("z") &&
                !list.toString().contains("B") && !list.toString().contains("C") && !list.toString().contains("D") &&
                !list.toString().contains("F") && !list.toString().contains("G") &&
                !list.toString().contains("H") && !list.toString().contains("J") && !list.toString().contains("K") &&
                !list.toString().contains("L") && !list.toString().contains("N") && !list.toString().contains("O") &&
                !list.toString().contains("P") && !list.toString().contains("Q") && !list.toString().contains("R") &&
                !list.toString().contains("S") && !list.toString().contains("T") && !list.toString().contains("V") &&
                !list.toString().contains("W") && !list.toString().contains("X") && !list.toString().contains("Z")) {
            throw new ListProcessorException("There are NO any consonants!");
        } else if (list.isEmpty()) {
            throw new ListProcessorException(thereAreNoAnyValuesEmptyList);
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
        if (list == null || list.contains(null)) {
            NullPointerException e = new NullPointerException(unexpectedExceptionTypeThrown);
            throw new ListProcessorException(theInputListCannotBeNull, e.getCause());
        } else if (list.isEmpty()) {
            throw new ListProcessorException(thereAreNoAnyValuesEmptyList);
        } else if (list.size() == 1) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException(unexpectedExceptionTypeThrown);
            throw new ListProcessorException("There is ONLY ONE value! The method could not be executed!", e.getCause());
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
        if (list == null || list.contains(null)) {
            NullPointerException e = new NullPointerException(unexpectedExceptionTypeThrown);
            throw new ListProcessorException(theInputListCannotBeNull, e.getCause());
        } else if (list.isEmpty()) {
            throw new ListProcessorException(thereAreNoAnyValuesEmptyList);
        } else {
            List<String> reversedList = new ArrayList<>();
            for (String s : list) {
                reversedList.add(new StringBuilder(s).reverse().toString());
            }
            return reversedList;
        }

    }
}
