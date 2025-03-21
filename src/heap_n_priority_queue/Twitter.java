package heap_n_priority_queue;

import java.util.*;

record Tweet(int index, int tweetId) {
   @Override
   public String toString() {
      return "{" + index +
            ", " + tweetId +
            '}';
   }
}

class Twitter {

   HashMap<Integer, Set<Integer>> usersAndTheirFollowers;
   HashMap<Integer, Set<Integer>> peopleWeFollow;
   LinkedHashMap<Integer, Set<Tweet>> tweetMap;
   int counter;

   public Twitter() {
      usersAndTheirFollowers = new HashMap<>();
      peopleWeFollow = new HashMap<>();
      tweetMap = new LinkedHashMap<>();
      counter = 0;
   }

   //  O(1)
   private void createUser(int userId) {
      usersAndTheirFollowers.putIfAbsent(userId, new HashSet<>());
      peopleWeFollow.putIfAbsent(userId, new HashSet<>());
      tweetMap.putIfAbsent(userId, new HashSet<>());
   }

   //      O(1)
   public void postTweet(int userId, int tweetId) {
      createUser(userId);

      Set<Tweet> myTweets = tweetMap.get(userId);
      myTweets.add(new Tweet(counter++, tweetId));

      tweetMap.put(userId, myTweets);

   }

   public List<Integer> getNewsFeed(int userId) {
      Set<Integer> users = new HashSet<>(); // O(u) - Space
      users.add(userId);

      if ( peopleWeFollow.containsKey(userId) )
         users.addAll(peopleWeFollow.get(userId));

      Queue<Tweet> maxHeap = new LinkedList<>();

      users.forEach(u -> {
         if ( tweetMap.containsKey(u) )
            maxHeap.addAll(tweetMap.get(u));
      });

      System.out.println(maxHeap.stream().toList());

      List<Integer> tweets = maxHeap.stream()
            .sorted(Comparator.comparingInt(Tweet::index).reversed())
            .map(Tweet::tweetId)
            .limit(10).toList();

      System.out.println(tweets);
      return tweets;

   }

   //   O(1)
   public void follow(int followerId, int starId) {

      createUser(followerId);
      createUser(starId);

      Set<Integer> temp = usersAndTheirFollowers.getOrDefault(starId, new HashSet<>());
      temp.add(followerId);
      usersAndTheirFollowers.put(starId, temp);
      temp.clear();

      temp = peopleWeFollow.getOrDefault(followerId, new HashSet<>());
      temp.add(starId);
      peopleWeFollow.put(followerId, temp);

   }

   //   O(1) - T
   public void unfollow(int followerId, int starId) {
      createUser(followerId);
      createUser(starId);

      Set<Integer> temp = usersAndTheirFollowers.get(starId);
      temp.remove(followerId);
      usersAndTheirFollowers.put(starId, temp);
      temp.clear();

      temp = peopleWeFollow.get(followerId);
      temp.remove(starId);
      peopleWeFollow.put(followerId, temp);

   }
}
