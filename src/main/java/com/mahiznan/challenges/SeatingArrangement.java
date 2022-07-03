package com.mahiznan.challenges;

/*
You are given an integer n, denoting the number of people who needs to be seated,
and a list of m integers seats, where 0 represents a vacant seat and 1 represents an already occupied seat.

Find whether all n people can find a seat, provided that no two people can sit next to each other.

Example 1:

    Input:
    n = 2
    m = 7
    seats[] = {0, 0, 1, 0, 0, 0, 1}
    Output:
    Yes
    Explanation:
    The two people can sit at index 0 and 4.

Example 2:

    Input:
    n = 1
    m = 3
    seats[] = {0, 1, 0}
    Output:
    No
    Explanation:
    There is no way to get a seat for one person.

Conditions:
    0 <= n <= 105
    1 <= m <= 105
    seats[i] == 0 or seats[i] == 1
 */


//Best Solution
class SeatingArrangementTheirAnswer {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        int available_seats = 0;
        for (int i = 0; i < m; i++) {
            int prev;
            if (i == 0)
                prev = 0;
            else
                prev = seats[i - 1];
            int next;
            if (i == m - 1)
                next = 0;
            else
                next = seats[i + 1];
            if (prev + next + seats[i] == 0) {
                available_seats++;
                i++;
            }
        }
        return available_seats >= n;
    }
}

public class SeatingArrangement {

    public static boolean canSit(int index, int[] seats) {
        if (seats.length == 1)
            return seats[index] == 0;
        if (seats[index] == 1)
            return false;
        if (index == 0)
            return seats[1] == 0;
        if (index == seats.length - 1)
            return seats[seats.length - 2] == 0;
        return seats[index - 1] == 0 && seats[index + 1] == 0;
    }


    public static boolean is_possible_to_get_seats(int n, int index, int[] seats) {
        if (n == 0)
            return true;
        if (index >= seats.length)
            return false;
        if (canSit(index, seats)) {
            seats[index] = 1;
            return is_possible_to_get_seats(n - 1, index + 2, seats);
        } else {
            return is_possible_to_get_seats(n, index + 1, seats);
        }
    }


    public static void main(String[] args) {
//        int n = 2, m = 7;
//        int[] seats = {0, 0, 1, 0, 0, 0, 1};
//        int n = 1;
//        int[] seats = {0, 1, 0};
        int n = 1;
        int[] seats = {0};
        System.out.println(is_possible_to_get_seats(n, 0, seats));
    }
}
