class TimeMap {
    public Map<String, TreeMap<Integer, String>> data;

    public TimeMap() {
        this.data = new TreeMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        this.data.computeIfAbsent(key, val -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!data.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> timestamps = data.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);

        return entry == null ? "" : entry.getValue();
    }
}
