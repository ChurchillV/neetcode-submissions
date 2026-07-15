class Twitter {
    Map<Integer, PriorityQueue<int[]>> feeds; // userID, (postsId, timestamp)[]
    Map<Integer, Set<Integer>> users; // userID, follows[]
    int time;
    Comparator<int[]> comp;

    public Twitter() {
        this.feeds = new HashMap();
        this.users = new HashMap();
        this.time = 0;
        this.comp = (a, b) -> Integer.compare(b[1], a[1]);
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        // Add to the user's feed
        feeds.computeIfAbsent(userId, f -> new PriorityQueue<int[]>(comp)).offer(new int[] {tweetId, time});
        System.out.println("Feed for user " + userId + ": " + feeds.get(userId) + " [POST TWEET]");
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> userFeed = new PriorityQueue(comp);
        userFeed.addAll(feeds.getOrDefault(userId, new PriorityQueue<int[]>(comp)));

        for(int followee : users.getOrDefault(userId, new HashSet<>())) {
            userFeed.addAll(feeds.getOrDefault(followee, new PriorityQueue<int[]>(comp)));
        }

        List<Integer> finalFeed = new ArrayList();
        int count = 0;
        while(!userFeed.isEmpty() && count < 10) {
            finalFeed.add(userFeed.poll()[0]);
            count++;
        }

        System.out.println("Feed for user " + userId + ": " + finalFeed + "[GET NEWS FEED]");

        return finalFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        users.computeIfAbsent(followerId, f -> new HashSet()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }

        users.computeIfAbsent(followerId, f -> new HashSet()).remove(followeeId);
    }
}
