class KthLargest {
    private PriorityQueue<Integer> priorityQueue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.priorityQueue = new PriorityQueue();
        this.k = k;
        for(int num: nums){
            priorityQueue.offer(num);
        }
        pollUntilK();
    }
    
    public int add(int val) {
        priorityQueue.offer(val);
        pollUntilK();
        return priorityQueue.peek();
    }

    private void pollUntilK(){
        while(priorityQueue.size() > k){
            priorityQueue.poll();
        }
    }
}
