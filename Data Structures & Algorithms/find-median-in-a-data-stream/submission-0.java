class MedianFinder {
    PriorityQueue<Integer> lowerHalf;
    PriorityQueue<Integer> higherHalf;

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(
            Comparator.reverseOrder()
        );
        higherHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lowerHalf.offer(num);
        if(!higherHalf.isEmpty() && lowerHalf.peek() > higherHalf.peek()){
            higherHalf.offer(lowerHalf.poll());
        }

        if(higherHalf.size() > lowerHalf.size() + 1){
            lowerHalf.offer(higherHalf.poll());
        }

        if(lowerHalf.size() > higherHalf.size() + 1){
            higherHalf.offer(lowerHalf.poll());
        }
    }
    
    public double findMedian() {
        // if both heaps size are equal, peek from both and divide
        // in case size are different, pick from the biggest size
        if(lowerHalf.size() > higherHalf.size()){
            return (double) lowerHalf.peek();
        }else if (higherHalf.size() > lowerHalf.size()){
            return (double) higherHalf.peek();
        }
        
        return (double) (higherHalf.peek() + lowerHalf.peek()) / 2;
    }
}
