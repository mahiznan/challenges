package com.mahiznan.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*

Given an array A[ ] of positive integers of size N, where each value represents the number of
chocolates in a packet. Each packet can have a variable number of chocolates.
There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student
and minimum number of chocolates given to a student is minimum.

Ex: 01
Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between maximum chocolates
and minimum chocolates is 9 - 3 = 6 by choosing following
 M packets :{3, 4, 9, 7, 9}.

Ex: 02
Input:
N = 7, M = 3
A = {7, 3, 2, 4, 9, 12, 56}
Output: 2
Explanation: The minimum difference between maximum chocolates
and minimum chocolates is 4 - 2 = 2 by choosing following
M packets :{3, 2, 4}.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
1 ≤ Ai ≤ 109
1 ≤ M ≤ N
 */

public class ChocolateDistribution {

    public static void main(String[] args) {
        /*ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(4);
        a.add(1);
        a.add(9);
        a.add(56);
        a.add(7);
        a.add(9);
        a.add(12);*/

        /*
        ArrayList<Integer> a = new ArrayList<>();
        a.add(7);
        a.add(3);
        a.add(2);
        a.add(4);
        a.add(9);
        a.add(12);
        a.add(56);
        System.out.println(findMinDiff(a, a.size(), 3));
*/
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(829, 736, 204, 349, 16, 181, 225, 424, 779, 957, 922, 433, 198, 268, 522, 676, 220, 948, 546, 422, 53, 554, 100, 1004, 915, 199, 340, 894, 185, 950, 257, 214, 675, 993, 72, 565, 322, 153, 778, 584, 982, 318, 335, 758, 865, 315, 899, 374, 241, 870, 144, 870, 854, 87, 436, 655, 126, 326, 917, 872, 13, 474, 786, 167, 185, 304, 635, 359, 741, 312, 172, 415, 451, 358, 342, 479, 512, 543, 374, 481, 243, 530, 562, 549, 830, 114, 401, 476, 120, 609, 603, 98, 817, 287, 105, 86, 24, 635, 718, 612, 58, 586, 118, 741, 748, 822, 670, 69, 218, 368, 428, 589, 105, 408, 160, 409, 10, 268, 363, 789, 128, 688, 974, 732, 237, 357, 199, 210, 591, 445, 144, 882, 17, 1006, 408, 682, 935, 173, 279, 678, 953, 612, 548, 890, 980, 471, 920, 388, 549, 284, 1000, 281, 280, 154, 535, 919, 568, 59, 363, 146, 24, 212, 593, 483, 945, 548, 843, 190, 581, 203, 753, 675, 803, 206, 534, 640, 292, 712, 756, 869, 182, 75, 538, 703, 46, 231, 253, 17, 923, 714, 669, 800, 497, 209, 746, 406, 292, 293, 70, 817, 453, 730, 373, 645, 674, 20, 266, 695, 896, 915, 811, 219, 300, 424, 745, 641, 331, 560, 720, 835, 303, 977, 270, 979, 619, 963, 674, 91, 88, 265, 746, 948, 361, 55, 346, 386, 427, 335, 401, 976, 458, 887, 854, 488, 416, 60, 235, 278, 775, 109, 529, 630, 593, 681, 325, 19, 270, 563, 609, 961, 558, 591, 141, 29, 847, 45, 344, 380, 441, 766, 674, 1001, 304, 692, 116, 475, 626, 815, 634, 862, 290, 637, 127, 409, 268, 833, 378, 856, 66, 48, 248, 426, 206, 344, 305, 414, 657, 818, 432, 625, 51, 641, 597, 659, 339, 419, 757, 124, 914, 928, 877, 1009, 292, 393, 962, 91, 919, 10, 213, 258, 126, 323, 213, 37, 728, 699, 294, 445, 805, 750, 368, 267, 640, 162, 995, 367, 667, 948, 330, 667, 616, 816, 749, 631, 628, 880, 107, 118, 793, 36, 927, 361, 540, 475, 291, 866, 635, 1009, 546, 372, 811, 778, 75, 201, 17, 935, 771, 676, 360, 414, 617, 248, 723, 998, 272, 776, 187, 699, 97, 73, 955, 302, 695, 597, 666, 689, 727, 433, 328, 498, 511, 505, 165, 94, 398, 771, 39, 440, 373, 433, 762, 746, 797, 995));
        System.out.println(findMinDiff(a, a.size(), 1));

        // A = {3, 4, 1, 9, 56, 7, 9, 12}
    }

    static long findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        if (m == 1)
            return 0;
        int minPos = 0, min = a.get(minPos), diff = Integer.MAX_VALUE;
        for (int i = m - 1; i < n; i++) {
            int max = a.get(i);
            if (diff > (max - min))
                diff = max - min;
            min = a.get(++minPos);
        }
        return diff;
    }
}
