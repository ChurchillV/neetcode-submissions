class MedianFinder {

    PriorityQueue<Integer> stream;

    public MedianFinder() {
        stream = new PriorityQueue();
    }
    
    public void addNum(int num) {
        stream.offer(num);
    }
    
    public double findMedian() {
        List<Integer> values = new ArrayList();
        PriorityQueue<Integer> streamCopy = new PriorityQueue();
        streamCopy.addAll(stream);

        while(!streamCopy.isEmpty()) {
            values.add(streamCopy.poll());
        }

        int size = values.size();
        int half = size/2;
        return (size % 2 == 0) ? (values.get(half - 1) + values.get(half))/2.0
        : values.get(half);

    }
}
