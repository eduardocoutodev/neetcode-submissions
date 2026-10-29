class Solution {
    record DestinationWithMoney(int destination, int cost){}
    record DestinationWithMoneyAndStops(int destination, int cost, int stops){}

    Map<Integer, List<DestinationWithMoney>> adjacencies = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // priority queue for steps
        // if priority queue empty or smaller than K then return -1
        int[][] dist = new int[n][k + 5];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        for(int i = 0; i < n; i++){
            adjacencies.put(i, new ArrayList<>());
        }

        for(int[] flight: flights){
            int source = flight[0];
            int dest = flight[1];
            int price = flight[2];
            adjacencies.get(source).add(new DestinationWithMoney(dest, price));
        }
        
        PriorityQueue<DestinationWithMoneyAndStops> pq = new PriorityQueue<>(
            Comparator.comparingInt(DestinationWithMoneyAndStops::cost)
        );
        pq.offer(new DestinationWithMoneyAndStops(src, 0, -1));

        // TODO, add optimization to skip when current step >= k

        while(!pq.isEmpty()){
            DestinationWithMoneyAndStops current = pq.poll();
            int cost = current.cost();
            int dest = current.destination();
            int stops = current.stops();

            if(dst ==  dest) return cost;
            // dist[dest][stops + 1] -> in case we already have found a smaller path
            if(stops >= k || dist[dest][stops + 1] < cost) continue;

            List<DestinationWithMoney> adjacenciesList = adjacencies.get(dest);
            for(DestinationWithMoney neighboor: adjacenciesList){
                int nDestination = neighboor.destination();
                int nCost = neighboor.cost();

                int nextCost = cost + nCost;
                int nextStops = stops + 1;

                if(dist[nDestination][nextStops + 1] > nextCost){
                    dist[nDestination][nextStops + 1] = nextCost;
                    pq.offer(new DestinationWithMoneyAndStops(nDestination, nextCost, nextStops));
                }
            }
        }

        return -1;
    }
}
