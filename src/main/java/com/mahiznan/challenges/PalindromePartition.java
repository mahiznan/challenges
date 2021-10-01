package com.mahiznan.challenges;

public class PalindromePartition {

    static void printPalindromePatterns(String string) {
        int cLength = 1, sLength = string.length();
        String cWord;
        while (cLength < sLength) {
            for (int i = 0; i + cLength <= sLength; i++) {
                cWord = string.substring(i, i + cLength);
                if (isPalindrome(cWord)) {
                    System.out.print(cWord + " ");
                }
            }
            cLength++;
            System.out.println();
        }


    }

    private static boolean isPalindrome(String word) {
        //System.out.println("Checking word for palindrome " + word);
        String reverseWord = new StringBuilder(word).reverse().toString();
        return word.equals(reverseWord);

//        List<int> charList = word.chars().collect(Collectors.toList());
//        Collections.reverse(word.toCharArray());
//        String reverse =   (word.toCharArray()).toString();

//        return true;
    }

    public static void main(String[] args) {
        String word = "madam";
        printPalindromePatterns(word);
    }
}
