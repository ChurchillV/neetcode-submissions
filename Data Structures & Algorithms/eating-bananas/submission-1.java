class Solution {
     public boolean checkSpeed(int[] piles, int speed, int maxHours) {
        int totalHours = 0;
        for(int i = 0; i < piles.length; i++) {
            totalHours += (speed + piles[i] -1)/speed;
        }

        return totalHours <= maxHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 0;

        int highSpeed = Arrays.stream(piles)
                                .max()
                                .getAsInt();
        
        int lowSpeed = 1;


        while(lowSpeed <= highSpeed) {
            int currentSpeed = lowSpeed + (highSpeed - lowSpeed)/2; // Get middle portion

            if(checkSpeed(piles, currentSpeed, h)) {
                minSpeed = currentSpeed;
                highSpeed = currentSpeed-1;        
            } else {
                lowSpeed = currentSpeed+1;
            }
        }
        

        return minSpeed;
    }
}
