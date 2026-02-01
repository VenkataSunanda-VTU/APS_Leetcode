class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int head = 0;
        int tail = n - 1;
        int index = n - 1;
        while (head <= tail) {
            int leftSquare = nums[head] * nums[head];
            int rightSquare = nums[tail] * nums[tail];
            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                head++;
            } else {
                result[index] = rightSquare;
                tail--;
            }
            index--;
        }
        return result;
    }
}
