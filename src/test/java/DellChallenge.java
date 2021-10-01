import org.junit.Test;

import java.util.Arrays;

public class DellChallenge {

    //n = [9, 3, 4, 6, 0, 1, 2]
    @Test
    public void findNthLargest() {
        int[] numbers = {9, 3, 4, 6, 0, 1, 2};
        int n = 5;
        int[] res = {-1, -1, -1, -1, -1};
        for (int i : numbers) {
            for (int j = 0; i < res.length; i++) {
                if (i > res[i]) {
                    for (int k = res.length - 1; i > j; i--) {
                        res[k] = res[k - 1];
                    }
                    res[j] = i;
                    break;
                }
            }
        }
        System.out.println(res[n - 1]);
    }

    @Test
    public void sortArray() {
        int[] numbers = {9, 3, 4, 6, 0, 1, 2};

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }


}