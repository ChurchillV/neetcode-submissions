class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            int difference = target - sum;

            if(difference < 0) {
                right--;
            } else if(difference > 0) {
                left++;
            } else {
                return new int[]{ left+1, right+1};
            }
        }

        return new int[]{-1, -1};
    }
}
