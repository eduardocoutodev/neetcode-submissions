class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Comparator.reverseOrder()
        );

        for(int num: stones){
            pq.offer(num);
        }

        while(pq.size() > 1){
            int num1 = pq.poll();
            int num2 = pq.poll();
            int result = Math.abs(num1 - num2);
            if(result > 0) pq.offer(result);
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
