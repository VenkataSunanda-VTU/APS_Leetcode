class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // Step 1: find total sum of array
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        int leftSum = 0;
        // Step 2: calculate answer for each index
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            int leftPart = nums[i] * i - leftSum;
            int rightPart = rightSum - nums[i] * (n - i - 1);
            result[i] = leftPart + rightPart;
            leftSum += nums[i];
        }
        return result;
    }
}
