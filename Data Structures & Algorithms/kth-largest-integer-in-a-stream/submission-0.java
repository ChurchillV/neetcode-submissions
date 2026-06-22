class KthLargest {
    private int kth;
    private List<Integer> values;

    public KthLargest(int k, int[] nums) {
        kth = k;
        values = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public int add(int val) {
        values.add(val);
        Collections.sort(values);

        int size = values.size();

        int result = -1;

        for(int i = size-1; i >= (size - kth); i--) {
            result = i;
        }

        return values.get(result);

    }
}
