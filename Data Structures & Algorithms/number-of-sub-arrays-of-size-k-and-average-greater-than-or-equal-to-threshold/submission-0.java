class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int biggerThanThreshold = 0;
        List<Integer> avgThreshold = new ArrayList<Integer>(k);

        int left = 0;
        for(int right = 0; right < arr.length; right++){
            if(right - left + 1 > k){
                left++;
                avgThreshold.remove(0);
            }

            avgThreshold.add(arr[right]);

            if(avgThreshold.size() == k && calculateSubArrayAverage(avgThreshold) >= threshold){
                biggerThanThreshold++;
            }
        }
        

        return biggerThanThreshold;
    }

    private double calculateSubArrayAverage(List<Integer> nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return (double) sum / nums.size();
    }
}