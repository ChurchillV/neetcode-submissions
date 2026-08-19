class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int LENGTH = gas.length;
        int[] netConsumption = new int[LENGTH];
        int[] netUsage = new int[LENGTH];
        int maxIdx = 0;
        int maxNet = Integer.MIN_VALUE;
        int net = 0;


        for(int i = 0; i < LENGTH; i++) {
            netConsumption[i] = gas[i] - cost[i];
        }

        for(int i = 0; i < LENGTH; i++) {

            if(i == LENGTH - 1) {
                netUsage[i] = netConsumption[i] + netConsumption[0];
            } else {
                netUsage[i] = netConsumption[i] + netConsumption[i+1];
            }

            net += netUsage[i];

            if((netUsage[maxIdx] + netConsumption[maxIdx]) <= (netUsage[i] + netConsumption[i])) {
                maxIdx = i;
                maxNet = netUsage[i];
            }
        }

        return net < 0 ? -1 : maxIdx;
    }
}
