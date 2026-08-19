class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int LENGTH = gas.length;
        int[] netConsumption = new int[LENGTH];
        int[] netUsage = new int[LENGTH];
        int maxIdx = 0;
        int maxNet = Integer.MIN_VALUE;
        int net = 0;


        for(int i = 0; i < LENGTH; i++) {
            netConsumption[i] = gas[i] - cost[i];
            
            if(i == LENGTH - 1) {
                netUsage[i] = netConsumption[i] + (netConsumption[0]);
            } else {
                netUsage[i] = netConsumption[i] + (gas[i+1] - cost[i+1]);
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
