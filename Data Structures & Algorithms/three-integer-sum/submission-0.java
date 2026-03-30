class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> numsArray = Arrays.stream(nums)
                                    .boxed()
                                    .sorted()
                                    .collect(Collectors.toList());

        List<List<Integer>> result = new ArrayList<>();

        int numsLength = nums.length;

        for(int i = 0; i < numsLength; i++) {
            if(i > 0 && numsArray.get(i) == numsArray.get(i-1)) {
                continue;
            }
            
            int left = i+1;
            int right = numsLength - 1;

            while(left < right) {
                int sum = numsArray.get(i) + numsArray.get(left) + numsArray.get(right);
                if(sum == 0) {
                    result.add(Arrays.asList(numsArray.get(i), numsArray.get(left), numsArray.get(right)));
                    left++;
                    right--;

                    while(left < right && numsArray.get(left-1) == numsArray.get(left)) {
                        left++;
                    }

                    while(left < right && numsArray.get(right+1) == numsArray.get(right)) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
