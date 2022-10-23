package com.mahiznan.challenges.amazon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AmazonSuggestion {

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        List<List<String>> suggestions = new ArrayList<>();
        for (int i = 1; i < customerQuery.length(); i++) {
            suggestions.add(new ArrayList<>());
        }
        for (String s : repository) {
            System.out.println(s);
            for (int i = 0; i < customerQuery.length() - 1; i++) {
                String subString = customerQuery.substring(0, i + 2);
                if (s.toLowerCase().startsWith(subString)) {
                    if (suggestions.get(i) == null) {
                        List<String> strings = new ArrayList<>();
                        strings.add(s);
                        suggestions.add(strings);
                    } else {
                        suggestions.get(i).add(s);
                    }
                }
            }
        }
        List<List<String>> filteredSuggestions = new ArrayList<>();
        for (List<String> strings : suggestions) {
            Collections.sort(strings);
            List<String> filtered = strings.size() > 3 ? strings.subList(0, 3) : strings;
            filteredSuggestions.add(filtered);
        }

        return filteredSuggestions;
    }


    static int amazonFresh(List<String> codeList, List<String> shoppingCart) {
        System.out.println(codeList);
        System.out.println(shoppingCart);
        int index = 0, winner = 1;
        boolean match = true;
        for (String group : codeList) {
            System.out.println(group);
            String[] groupFruits = group.split(" ");
            for (String gFruit : groupFruits) {
                System.out.println("Checking for " + gFruit);
                while (!gFruit.equals(shoppingCart.get(index))) {
                    index++;
                    match = false;
                }
                if (!match)
                    return 0;
                index++;
            }
        }
        return winner;

    }


    public static void main(String[] args) throws IOException {
        ArrayList<String> repository = new ArrayList<>();
        /*repository.add("bags");
        repository.add("baggage");
        repository.add("banner");
        repository.add("box");
        repository.add("cloths");
        System.out.println(searchSuggestions(repository, "bags"));
        */
        /*
        repository.add("code");
        repository.add("codePhone");
        repository.add("coddle");
        repository.add("coddles");
        repository.add("codes");
        for (List<String> suggestions : searchSuggestions(repository, "coddle")) {
            System.out.println(suggestions);
        }*/
        /*repository.add("abbS");
        repository.add("abc");
        repository.add("Abs");
        repository.add("bcs");
        repository.add("bdsa");
        repository.add("cdde");
        repository.add("rgb");
        repository.add("yjmm");
        repository.add("xxmm");
        repository.add("zeee");
        for (List<String> suggestions : searchSuggestions(repository, "abbs")) {
            System.out.println(suggestions);
        }*/

        List<String> codeList = new ArrayList<>();
        codeList.add("orange");
        codeList.add("apple apple");
        codeList.add("banana orange apple");
        codeList.add("banana");
        List<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("banana");

        System.out.println(amazonFresh(codeList, shoppingCart));

    /*
        3

    apple apricot

    banana anything guava

    papaya anything

    7

    banana

    orange

    guava

    apple

    apricot

    papaya

    kiwi
     */
    }
}
