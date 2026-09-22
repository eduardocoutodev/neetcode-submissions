class Twitter {
    private final static int MAX_TWEETS_PER_FEED = 10;
    record Tweet(Integer tweetId, Integer timestamp) {}

    private Integer timer;
    private HashMap<Integer, Set<Integer>> followersOfUser;
    private HashMap<Integer, List<Tweet>> tweetsByUser;

    public Twitter() {
        timer = 0;
        followersOfUser = new HashMap<>();
        tweetsByUser = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        var newTweet = new Tweet(tweetId, timer);
        tweetsByUser.computeIfAbsent(userId, (key) -> new ArrayList<Tweet>()).add(newTweet);
        countTicker();
    }

    public List<Integer> getNewsFeed(int userId) {
        // get friends of user
        Set<Integer> followedUsers = followersOfUser.getOrDefault(
            userId,
            new HashSet<>()
	    );

        List<Tweet> tweets = new ArrayList<Tweet>();

        for(Integer friendUserId: followedUsers){
            var tweetsOfUser = tweetsByUser.get(friendUserId);
            tweets.addAll(tweetsOfUser);
        }

        tweets.addAll(tweetsByUser.getOrDefault(userId, new ArrayList<>()));

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            Comparator.comparingInt(Tweet::timestamp).reversed()
        );

        pq.addAll(tweets);
        var size = pq.size();

        List<Integer> results = new ArrayList<>();
        for(int i=0; i<Math.min(MAX_TWEETS_PER_FEED, size); i++){
            results.add(pq.poll().tweetId());
        }

        return results;
    }

    public void follow(int followerId, int followeeId) {
        // friends.get.add
        followersOfUser.computeIfAbsent(followerId, (key) -> new HashSet<Integer>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // friends.get.remove
        followersOfUser.computeIfAbsent(followerId, (key) -> new HashSet<Integer>())
            .remove(followeeId);
    }

    private void countTicker() {
        timer++;
    }
}
