class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        record Car(int position, int speed){}
        Car[] cars = new Car[position.length];

        for(int i = 0; i < position.length; i ++){
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (a, b) -> b.position - a.position);
        var stack = new ArrayDeque<Double>();
        for(var car : cars){
            double hoursToTarget =
    (double) (target - car.position()) / car.speed();
            // Only push new values, in case it has lower timeToTarget than car infront, otherwise both will be a fleet
            if(!stack.isEmpty() && hoursToTarget <= stack.peek()){
                continue;
            }

            stack.push(hoursToTarget);
        }

        return stack.size();
    }
}
