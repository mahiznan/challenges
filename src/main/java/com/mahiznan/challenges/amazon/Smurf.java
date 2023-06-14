package com.mahiznan.challenges.amazon;

import java.util.Objects;

/*

 A geek once visited a magical island where he found a special creature. He named it as Smurf.
 He noticed a very strange thing there. The smurfs resembled the primary colors of light.
 To make it more clear, the primary colors of light are Red(R), Green(G), and Blue(B).
 He talked to one of the smurfs. The smurfs came to know that he is a good programmer.
 The smurfs suggested a deal that they will ask him one question and if he is able to answer that question,
 they will allow the geek to take anything from the island.
The question is as follows:
The smurfs possess a very magical property. When two smurfs of different colors meet with other,
they gets converted into a smurf of the third color. How many minimum number of smurfs will be remaining
after this transformation? The question looked simple to geek. However, the smurfs put another constraint
to make the geek think more. The two smurfs must be adjacent to each other  to make the transformation take place.
There are n smurfs the colors of which are given in an array a[].

Example

Input: n = 5
a = {'R' , 'G', 'B', 'R', 'B'}
Output: 1
Explanation: First 'R' and 'G' makes 'B'.
Then 'B' and 'R' makes 'G' and that 'G'
with 'B' at index 2 makes 'R', Now the 'R'
and the last 'B' makes 'G'.

Input: n = 2
a = {'R', 'R'}
Output: 2
Explanation: There are two 'R' s. So
they cannot change to anything else.

 */
public class Smurf {

    static int minFind(int n, String[] a) {
        int r = 0, g = 0, b = 0;
        for (int i = 0; i < n; i++)
            if (Objects.equals(a[i], "R"))
                r++;
            else if (Objects.equals(a[i], "G"))
                g++;
            else
                b++;
        //All same color
        if (r == n || g == n || b == n)
            return n;
        //All or even or all or add
        if ((r % 2 == 0 && g % 2 == 0 && b % 2 == 0) || (r % 2 == 1 && g % 2 == 1 && b % 2 == 1))
            return 2;
        return 1;
    }

    public static void main(String[] args) {
//        String[] smurfs = {"R", "G", "B", "R", "B"}; //1
//        String[] smurfs = {"R", "R"}; //2
//        String[] smurfs = {"G", "R", "B", "G", "R", "R", "G", "G", "G", "G", "B", "B", "B", "B", "G", "B", "B", "G"};//1
//        String[] smurfs = {"G", "B", "B", "G"};//2
//        String[] smurfs = {"R", "G", "B", "G", "B", "R", "B", "R", "G"};//2
//        String[] smurfs = {"G", "G", "R", "R", "B", "B"};//2
        String[] smurfs = {"R", "R", "R", "R", "R", "R"};//2
        System.out.println(minFind(smurfs.length, smurfs));
        System.out.println(findMinApproach2(smurfs.length, smurfs));
    }

    static int findMinApproach2(int n, String[] a) {
        int r = 0, g = 0, b = 0;
        for (int i = 0; i < n; i++)
            if (Objects.equals(a[i], "R"))
                r++;
            else if (Objects.equals(a[i], "G"))
                g++;
            else b++;
        if ((r == 0 && g == 0) || (r == 0 && b == 0) || (g == 0 && b == 0))
            return n;
        return (r % 2 == g % 2 && g % 2 == b % 2) ? 2 : 1;
    }
}
