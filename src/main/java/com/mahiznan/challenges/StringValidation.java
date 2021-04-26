package com.mahiznan.challenges;

public class StringValidation {

    public static void main(String args[]) {
//        System.out.println(validate("arrb6???4xxbl5???eee5"));
        System.out.println(validate("aa6?9"));
//        System.out.println(validate("acc?7??sss?3rr1??????5"));
//        System.out.println(validate("5??aaaaaaaaaaaaaaaaaaa?5?5"));
        System.out.println(validate("9???1???9??1???9"));
    }


    public static boolean validate(String str) {
        boolean res = true;
        String pattern = "123456789";
        int qCount, total;
        for (int i = 0; i < str.length(); i++) {
            if (pattern.indexOf(str.charAt(i)) >= 0) {
                qCount = 0;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == '?') {
                        qCount++;
                    } else if (pattern.indexOf(str.charAt(j)) >= 0) {
                        total = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(j));
                        if (total == 10) {
                            res = qCount == 3 && res;
                        }
                    }
                }
            }
        }
        return res;
    }
}
