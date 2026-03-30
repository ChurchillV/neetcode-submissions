class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int diff = target - number;

            if(map.containsKey(diff)) {
                return new int[] { map.get(diff), i};
            }

            map.put(number, i);
        }

        return new int[] { };
    }
}
