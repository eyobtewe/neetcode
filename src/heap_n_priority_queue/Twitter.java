package heap_n_priority_queue;

import java.util.*;

record Tweet(int index, int tweetId) {
}

class Twitter {

   HashMap<Integer, Set<Integer>> peopleWeFollow;
   HashMap<Integer, Set<Tweet>> tweetMap;
   int counter;

   public Twitter() {
      peopleWeFollow = new HashMap<>();
      tweetMap = new HashMap<>();
      counter = 0;
   }

   //  O(1)
   private void createUser(int userId) {
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

      PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Tweet::index).reversed());

      users.forEach(user -> {
         if ( tweetMap.containsKey(user) )
            maxHeap.addAll(tweetMap.get(user));

      });

      List<Integer> answer = new ArrayList<>();

      for ( int i = 0; i < 10 && !maxHeap.isEmpty(); i++ ) {
         answer.add(maxHeap.poll().tweetId());
      }

      return answer;

   }

   //   O(1)
   public void follow(int followerId, int starId) {

      createUser(followerId);
      createUser(starId);

      Set<Integer> temp = peopleWeFollow.getOrDefault(followerId, new HashSet<>());
      temp.add(starId);
      peopleWeFollow.put(followerId, temp);

   }

   //   O(1) - T
   public void unfollow(int followerId, int starId) {
      createUser(followerId);
      createUser(starId);

      Set<Integer> temp = peopleWeFollow.get(followerId);
      temp.remove(starId);
      peopleWeFollow.put(followerId, temp);

   }
}
