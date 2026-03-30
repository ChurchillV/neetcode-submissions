class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 0;

        int highSpeed = Arrays.stream(piles)
                                .max()
                                .getAsInt();
        
        int lowSpeed = 1;


        while(lowSpeed <= highSpeed) {
            int currentSpeed = lowSpeed + (highSpeed - lowSpeed)/2; // Get middle portion
            int totalHours = 0;

            // check total time for that speed
            for(int i = 0; i < piles.length; i++) {
                totalHours += (currentSpeed + piles[i] - 1)/currentSpeed;
            }

            if(totalHours <= h) {
                minSpeed = currentSpeed;
                highSpeed = currentSpeed-1;        
            } else {
                lowSpeed = currentSpeed+1;
            }
        }
        

        return minSpeed;
    }
}
