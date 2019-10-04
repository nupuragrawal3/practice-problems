import java.util.Arrays;

/*
* Solution to https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
* */

public class FindPivot {
    public static void main(String[] args) {
        int[] a = {1, 7, 3, 6, 5, 6};
        int pivot = getPivot(a);
        System.out.println(pivot);
    }

    private static int getPivot(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return 0;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum - nums[0] == 0) {
            return 0;
        }
        int sumOnRight;
        int sumOnLeft = 0;
        for (int i = 0; i < length - 1; i++) {
            sumOnLeft = sumOnLeft + nums[i];
            sumOnRight = sum - (sumOnLeft + nums[i + 1]);
            if (sumOnRight == sumOnLeft) {
                return i + 1;
            }
        }
        return -1;
    }
}

/*int length = a.length;
        int sum = 0;
        for (int k = 0; k < a.length; k++) {
            sum = sum + a[k];
        }
        int sumOnRight = 0;
        int sumOnLeft = 0;
        for (int i = length - 1; i > 0; i--) {
            sumOnRight = sumOnRight + a[i];
            sumOnLeft = sum - (sumOnRight + a[i - 1]);
            if (sumOnRight == sumOnLeft) {
                return i - 1;
            }
        }
        return -1;*/