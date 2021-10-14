package com.mahiznan.challenges;

public class CowsFooLand {

    //Slow
    static int totalAnimal(long N) {
        int i = 1, j = 0, t = 0;
        while (N > 0) {
            t = (i + j) % 1000000007;
            j = i;
            i = t;
            N--;
            System.out.println(N + " => " + t);
        }
        return t;
    }

    static void multiply(int a[][], int b[][])
    {
        // Creating an auxiliary matrix to
        // store elements of the
        // multiplication matrix
        int mul[][] = new int[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                mul[i][j] = 0;
                for (int k = 0; k < 3; k++)
                    mul[i][j] += a[i][k]
                            * b[k][j];
            }
        }

        // storing the multiplication
        // result in a[][]
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)

                // Updating our matrix
                a[i][j] = mul[i][j];
    }

    static int power(int F[][], int n)
    {
        int M[][] = {{1, 1, 1}, {1, 0, 0},
                {0, 1, 0}};

        // Multiply it with initial values
        // i.e with F(0) = 0, F(1) = 1,
        // F(2) = 1
        if (n == 1)
            return F[0][0] + F[0][1];

        power(F, n / 2);

        multiply(F, F);

        if (n%2 != 0)
            multiply(F, M);

        // Multiply it with initial values
        // i.e with F(0) = 0, F(1) = 1,
        // F(2) = 1
        return F[0][0] + F[0][1] ;
    }

    static int findNthTerm(int n)
    {
        int F[][] = {{1, 1, 1}, {1, 0, 0},
                {0, 1, 0}} ;

        return power(F, n-2);
    }

    public static void main(String[] args) {
        int N = 47;
        System.out.println(totalAnimal(N));
        System.out.println(totalAnimal(N % 1000000007));
        System.out.println(findNthTerm(N));
//        System.out.println(1134903170%1000000007);
//        System.out.println(971215059%1000000007);
    }
}

/*
Input:
44

Its Correct output is:
134903163

And Your Code's output is:
1134903170
 */
