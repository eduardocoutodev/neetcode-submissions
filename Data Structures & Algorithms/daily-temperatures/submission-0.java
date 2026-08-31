class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        record TemperatureTracking(int index, int temperature){}
        int[] answer = new int[temperatures.length];

        var waitingQueue = new ArrayDeque<TemperatureTracking>();

        for(int i = 0; i < temperatures.length; i++){
            var currentTemperature = temperatures[i];
            while(!waitingQueue.isEmpty()){
                var waitingTemperature = waitingQueue.peekFirst();
                // No need to calculate on below or equal temperature
                if(waitingTemperature.temperature >= currentTemperature) break;

                waitingQueue.pop();
                answer[waitingTemperature.index] = i - waitingTemperature.index;
            }

            waitingQueue.push(new TemperatureTracking(i, currentTemperature));            
        }
        
        return answer;
    }
}
