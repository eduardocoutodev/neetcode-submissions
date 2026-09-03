class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // need to discover max value
        int r = piles[0];
        for(int pile: piles){
            r = Math.max(r, pile);
        }
        
        // cant be 0, since its not a valid value for eatingRate
        int l = 1;

        while(l < r){
            int m = l + (r - l) / 2;
            if(canEat(piles, m, h)){
                // Cant discard current value, because may be the lowest value
                r = m;
            }else{
                // too low, can move to m + 1
                l = m + 1;
            }
        }

        return l;
    }

    private boolean canEat(int[] piles, int eatingRate, int maxHours){
        var hoursToEat = 0;
        for(int i = 0; i < piles.length; i++){
            var currentPile = piles[i];
            hoursToEat += (int) Math.ceil((double) currentPile / eatingRate);

            if(hoursToEat > maxHours) return false;
        }
        return true;
    }
}
