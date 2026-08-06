class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordList.add(beginWord);

        if(!wordSet.contains(endWord)) {
            // System.out.println("Word not in list");
            return 0;
        }

        Map<String, ArrayList<String>> map = new HashMap();

        for(String word : wordList) {
            for(int i = 0; i < word.length(); i++) {
                char[] letters = word.toCharArray();
                letters[i] = '_';
                String pattern = String.valueOf(letters);
                // System.out.println("Added pattern: " + pattern);
                map.putIfAbsent(String.valueOf(letters), new ArrayList());
                map.get(pattern).add(word);
                // System.out.println("Map: " + map);
            }
        }

        int result = 1;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(beginWord);
        // System.out.println("Queue: " + queue);
        // System.out.println("Map: " + queue);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // process entire level at once
            
            for (int k = 0; k < levelSize; k++) {
                String word = queue.poll();
                
                if (word.equals(endWord)) {
                    return result;
                }
                
                for (int i = 0; i < word.length(); i++) {
                    char[] letters = word.toCharArray();
                    letters[i] = '_';
                    String pattern = String.valueOf(letters);
                    
                    for (String match : map.get(pattern)) {
                        if (!visited.contains(match)) {
                            visited.add(match);
                            queue.offer(match);
                        }
                    }
                }
            }
            
            result++;  // only increment after finishing a full level
        }

        // System.out.println("Word not found");
        return 0;
    }
}
