class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
                                    .boxed()
                                    .collect(Collectors.toSet());

        int longestSequenceLength = 0;

        for(int num : set) {
            if(!set.contains(num-1)) {
                int sequenceLength = 1;
                int nextNumber = num+1;
                while(set.contains(nextNumber)) {
                    sequenceLength++;
                    nextNumber++;
                }

                longestSequenceLength = Math.max(longestSequenceLength, sequenceLength);
            }
        }

        return longestSequenceLength;
    }
}
