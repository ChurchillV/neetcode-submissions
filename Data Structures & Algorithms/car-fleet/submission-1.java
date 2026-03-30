class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));
        Stack<Double> fleetSpeeds = new Stack();

        for(int[] car : pair) {
            int pos = car[0];
            int spd = car[1];

            double timeTaken = (double)(target - pos) / spd;

            if(fleetSpeeds.isEmpty() || timeTaken > fleetSpeeds.peek()) {
                fleetSpeeds.push(timeTaken);
            }
        }

        return fleetSpeeds.size();
    }
}
