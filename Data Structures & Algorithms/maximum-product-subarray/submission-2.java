class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMax = 1;
        int currentMin = 1;

        for(int num: nums) {
            if(num == 0) {
                maxProduct = Math.max(maxProduct, 0);
                currentMax = 1;
                currentMin = 1;
                continue;
            }

            int temp = currentMax * num;
            currentMax = Math.max(temp, currentMin * num);
            currentMax = Math.max(currentMax, num);

            currentMin = Math.min(temp, currentMin * num);
            currentMin = Math.min(currentMin, num);

            maxProduct = Math.max(currentMax, maxProduct);
        }

        return maxProduct;
    }
}
