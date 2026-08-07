class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Set<String> wordSet = new HashSet(wordList);

        if(!wordSet.contains(endWord)) {
            return 0;
        }

        Map<String, ArrayList<String>> map = new HashMap();

        for(String word : wordList) {
            for(int i = 0; i < word.length(); i++) {
                char[] letters = word.toCharArray();
                letters[i] = '_';
                String pattern = String.valueOf(letters);
                map.putIfAbsent(pattern, new ArrayList());
                map.get(pattern).add(word);
            }
        }

        int result = 1;
        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        visited.add(beginWord);
        queue.offer(beginWord);

        while(!queue.isEmpty()) {
            int level = queue.size();

            for(int i = 0; i < level; i++) {
                String word = queue.poll();

                if(word.equals(endWord)) {
                    return result;
                }

                for(int j = 0; j < word.length(); j++) {
                    char[] letters = word.toCharArray();
                    letters[j] = '_';
                    String pattern = String.valueOf(letters);

                    for(String match : map.get(pattern)) {
                        if(!visited.contains(match)) {
                            visited.add(match);
                            queue.offer(match);
                        }
                    }
                }
            }

            result++;
        }

        return 0;
    }
}
