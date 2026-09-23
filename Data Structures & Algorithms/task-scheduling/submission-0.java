class Solution {
    record PriorityTask(char taskName, int frequency){}
    record CooldownPriorityTask(char taskName, int remainingTasks, int timeToStartAgain){}

    public int leastInterval(char[] tasks, int n) {
        int[] frequencyChar = new int[26];
        for(char task: tasks){
            frequencyChar[task - 'A']++;
        }

        PriorityQueue<PriorityTask> maxHeapByFrequency = new PriorityQueue(
            Comparator.comparingInt(PriorityTask::frequency).reversed()
        );

        for(int i = 0; i < 26; i++){
            int frequency = frequencyChar[i];
            if(frequency == 0) continue;

            maxHeapByFrequency.offer(new PriorityTask((char)('a' + i), frequency));
        }

        int time = 0;
        Deque<CooldownPriorityTask> queue = new ArrayDeque<>();

        while(!maxHeapByFrequency.isEmpty() || !queue.isEmpty()){
            time++;

            if(!maxHeapByFrequency.isEmpty()){
                var nextTask = maxHeapByFrequency.poll();
                if(nextTask.frequency() - 1 > 0){
                    queue.add(new CooldownPriorityTask(nextTask.taskName(),nextTask.frequency() - 1, time + n));
                }
            }else {
                time = queue.peek().timeToStartAgain();
            }

            if(!queue.isEmpty() && queue.peek().timeToStartAgain() == time){
                var cdTask = queue.poll();

                maxHeapByFrequency.offer(new PriorityTask(cdTask.taskName(), cdTask.remainingTasks()));
            }
        }


        return time;
    }
}
