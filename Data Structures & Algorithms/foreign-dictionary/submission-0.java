class Solution {
    private Map<Character, HashSet<Character>> order = new HashMap();
    private Map<Character, Boolean> onPath = new HashMap();
    StringBuilder result = new StringBuilder();

    public String foreignDictionary(String[] words) {
        for(String word : words) {
            for(Character c : word.toCharArray()) {
                order.computeIfAbsent(c, ch -> new HashSet());
            }
        }

        for(int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            int minLength = Math.min(w1.length(), w2.length());

            if(
                (w1.length() > w2.length()) &&                   
                (w1.substring(0, minLength).equals(w2.substring(0, minLength)))
            ) {
                return "";
            }

            for(int j = 0; j < minLength; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    order.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for(Character c : order.keySet()) {
            if(dfs(c)) {
                return "";
            }
        }

        return result.reverse().toString();

    }

    private boolean dfs(Character c) {
        if(onPath.containsKey(c)) {
            return onPath.get(c);
        }

        onPath.put(c, true);

        for(Character neighbor : order.get(c)) {
            if(dfs(neighbor)) {
                return true;
            }
        }

        onPath.put(c, false);
        result.append(c);
        return false;
    }
}
