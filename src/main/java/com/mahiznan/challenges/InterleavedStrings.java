package com.mahiznan.challenges;

public class InterleavedStrings {

    public static void main(String[] args) {
//        String stirng1 = "XYZ", string2 = "ABC", string3 = "XYAZBC"; // true
//        String string1 = "YX", string2 = "X", string3 = "XXY"; //false
//        String string1 = "XYYY", string2 = "XXYYXY", string3 = "XYYXXXXXYX"; //false
        String string1 = "aabcc", string2 = "dbbca", string3 = "aadbcbbcac"; //true
//        String string1 = "XY", string2 = "WZ", string3 = "WZXY"; //true

        System.out.println(isInterLeave(string1, string2, string3));
    }

    static boolean isInterLeave(String a, String b, String c) {
        // Find lengths of the two strings
        int M = a.length(), N = b.length();

        // Let us create a 2D table to store
        // solutions of sub problems. C[i][j]
        // will br true if C[0..i+j-1] is an
        // interleaving of A[0..i-1] and B[0..j-1].
        boolean[][] IL = new boolean[M + 1][N + 1];

        // IL is default initialised by false

        // C can be an interleaving of A and B
        // only if the sum of lengths of A and B
        // is equal to length of C
        if ((M + N) != c.length())
            return false;

        // Process all characters of A and B

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {

                // Two empty strings have an
                // empty strings as interleaving
                if (i == 0 && j == 0)
                    IL[i][j] = true;

                    // A is empty
                else if (i == 0) {
                    if (b.charAt(j - 1) == c.charAt(j - 1))
                        IL[i][j] = IL[i][j - 1];
                }

                // B is empty
                else if (j == 0) {
                    if (a.charAt(i - 1) == c.charAt(i - 1))
                        IL[i][j] = IL[i - 1][j];
                }

                // Current character of C matches
                // with current character of A,
                // but doesn't match with current
                // character if B
                else if (a.charAt(i - 1) == c.charAt(i + j - 1) &&
                        b.charAt(j - 1) != c.charAt(i + j - 1))
                    IL[i][j] = IL[i - 1][j];

                    // Current character of C matches
                    // with current character of B, but
                    // doesn't match with current
                    // character if A
                else if (a.charAt(i - 1) != c.charAt(i + j - 1) &&
                        b.charAt(j - 1) == c.charAt(i + j - 1))
                    IL[i][j] = IL[i][j - 1];

                    // Current character of C matches
                    // with that of both A and B
                else if (a.charAt(i - 1) == c.charAt(i + j - 1) &&
                        b.charAt(j - 1) == c.charAt(i + j - 1))
                    IL[i][j] = (IL[i - 1][j] || IL[i][j - 1]);
            }
        }
        return IL[M][N];
    }
}
