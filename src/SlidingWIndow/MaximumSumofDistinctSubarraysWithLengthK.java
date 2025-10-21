package SlidingWIndow;

import java.util.HashSet;

public class MaximumSumofDistinctSubarraysWithLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        long sum = 0, max = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right]) || right - left + 1 > k) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            if (right - left + 1 == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // Add a main method so you can run it in IntelliJ
    public static void main(String[] args) {
        MaximumSumofDistinctSubarraysWithLengthK obj = new MaximumSumofDistinctSubarraysWithLengthK();
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println("Result: " + obj.maximumSubarraySum(nums, k));
    }
}
