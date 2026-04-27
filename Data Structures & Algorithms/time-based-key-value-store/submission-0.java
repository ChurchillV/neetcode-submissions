class TimeMap {
    public Map<String, Map<Integer, String>> data;

    public TimeMap() {
        this.data = new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.data.computeIfAbsent(key, val -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(this.data.containsKey(key)) {
           if(this.data.get(key).containsKey(timestamp)) {
            return this.data.get(key).get(timestamp);
           } else {
            int time = timestamp - 1;
            while(time > 0) {
                if(this.data.get(key).containsKey(time)) {
                    return this.data.get(key).get(time);
                } else {
                    time--;
                }
            }
           }
        }

        return "";
    }
}
