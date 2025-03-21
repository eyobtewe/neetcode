package heap_n_priority_queue;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwitterTest {

   @Test
   public void testPostTweetAndGetNewsFeed() {
      Twitter twitter = new Twitter();

      // User 1 posts a tweet
      twitter.postTweet(1, 5);

      // User 1's news feed should contain their own tweet
      List<Integer> feed = twitter.getNewsFeed(1);
      assertEquals(1, feed.size());
      assertEquals(5, feed.getFirst());

      // Post multiple tweets and check ordering (most recent to least)
      twitter.postTweet(1, 6);
      feed = twitter.getNewsFeed(1);
      assertEquals(2, feed.size());
      assertEquals(6, feed.getFirst()); // Most recent first
      assertEquals(5, feed.get(1));
   }

   @Test
   public void testFollowAndUnfollow() {
      Twitter twitter = new Twitter();

      // User 1 posts tweets
      twitter.postTweet(1, 5);

      // Initially user 2's feed is empty
      List<Integer> feed = twitter.getNewsFeed(2);
      assertEquals(0, feed.size());

      // User 2 follows user 1
      twitter.follow(2, 1);

      // User 2's feed should now contain user 1's tweets
      feed = twitter.getNewsFeed(2);
      assertEquals(1, feed.size());
      assertEquals(5, feed.getFirst());

      // User 1 posts another tweet
      twitter.postTweet(1, 6);

      // User 2's feed should be updated
      feed = twitter.getNewsFeed(2);
      assertEquals(2, feed.size());
      assertEquals(6, feed.getFirst());
      assertEquals(5, feed.get(1));

      // User 2 unfollows user 1
      twitter.unfollow(2, 1);

      // User 2's feed should now be empty again
      feed = twitter.getNewsFeed(2);
      assertEquals(0, feed.size());
   }

   @Test
   public void testNewsFromMultipleFollowees() {
      Twitter twitter = new Twitter();

      // Multiple users post tweets
      twitter.postTweet(1, 5);
      twitter.postTweet(2, 6);

      // User 3 follows both user 1 and 2
      twitter.follow(3, 1);
      twitter.follow(3, 2);

      // User 3's feed should contain tweets from both followed users
      List<Integer> feed = twitter.getNewsFeed(3);
      assertEquals(2, feed.size());
      assertEquals(6, feed.getFirst()); // Most recent first
      assertEquals(5, feed.get(1));

      // Post more tweets to test chronological ordering
      twitter.postTweet(1, 7);
      feed = twitter.getNewsFeed(3);
      assertEquals(3, feed.size());
      assertEquals(7, feed.getFirst()); // Most recent first
      assertEquals(6, feed.get(1));
      assertEquals(5, feed.get(2));
   }

   @Test
   public void testTenTweetLimit() {
      Twitter twitter = new Twitter();

      // User 1 posts 15 tweets
      for ( int i = 1; i <= 15; i++ ) {
         twitter.postTweet(1, i);
      }

      // User 1's feed should contain only the 10 most recent tweets
      List<Integer> feed = twitter.getNewsFeed(1);
      assertEquals(10, feed.size());

      // The tweets should be in reverse chronological order (15 to 6)
      for ( int i = 0; i < 10; i++ ) {
         assertEquals(15 - i, feed.get(i));
      }
   }

   @Test
   public void testMixedTweetsOrdering() {
      Twitter twitter = new Twitter();

      // Setup: User 2 follows User 1
      twitter.follow(2, 1);

      // Post tweets in alternating order
      twitter.postTweet(1, 1);
      twitter.postTweet(2, 2);
      twitter.postTweet(1, 3);
      twitter.postTweet(2, 4);
      twitter.postTweet(1, 5);

      // User 2's feed should contain tweets from both User 1 and User 2 in chronological order
      List<Integer> feed = twitter.getNewsFeed(2);
      assertEquals(5, feed.size());
      assertEquals(5, feed.getFirst());
      assertEquals(4, feed.get(1));
      assertEquals(3, feed.get(2));
      assertEquals(2, feed.get(3));
      assertEquals(1, feed.get(4));
   }

   @Test
   public void testUsersWithNoTweets() {
      Twitter twitter = new Twitter();

      // User with no tweets should have empty feed
      List<Integer> feed = twitter.getNewsFeed(1);
      assertEquals(0, feed.size());

      // User following another user with no tweets
      twitter.follow(1, 2);
      feed = twitter.getNewsFeed(1);
      assertEquals(0, feed.size());
   }

   @Test
   public void testFollowSelfAndUnfollowSelf() {
      Twitter twitter = new Twitter();

      // User posts a tweet
      twitter.postTweet(1, 5);

      // User should see own tweet regardless of following self
      List<Integer> feed = twitter.getNewsFeed(1);
      assertEquals(1, feed.size());
      assertEquals(5, feed.getFirst());

      // User follows self (should have no effect)
      twitter.follow(1, 1);
      feed = twitter.getNewsFeed(1);
      assertEquals(1, feed.size());
      assertEquals(5, feed.getFirst());

      // User unfollows self (should not affect seeing own tweets)
      twitter.unfollow(1, 1);
      feed = twitter.getNewsFeed(1);
      assertEquals(1, feed.size());
      assertEquals(5, feed.getFirst());
   }

   @Test
   public void testComplexUserGraph() {
      Twitter twitter = new Twitter();

      // Set up a more complex user graph with 5 users
      twitter.postTweet(1, 101);
      twitter.postTweet(2, 201);
      twitter.postTweet(3, 301);
      twitter.postTweet(4, 401);
      twitter.postTweet(5, 501);

      // User 1 follows 2 and 3
      twitter.follow(1, 2);
      twitter.follow(1, 3);

      // User 2 follows 3 and 5
      twitter.follow(2, 3);
      twitter.follow(2, 5);

      // User 3 follows only 4
      twitter.follow(3, 4);

      // User 4 follows 1 and 5
      twitter.follow(4, 1);
      twitter.follow(4, 5);

      // User 5 follows everyone
      twitter.follow(5, 1);
      twitter.follow(5, 2);
      twitter.follow(5, 3);
      twitter.follow(5, 4);

      // Post some more tweets
      twitter.postTweet(2, 202);
      twitter.postTweet(3, 302);

      // Check feeds
      List<Integer> feed1 = twitter.getNewsFeed(1);
      assertEquals(5, feed1.size());
      assertEquals(302, feed1.get(0));
      assertEquals(202, feed1.get(1));
      assertEquals(301, feed1.get(2));
      assertEquals(201, feed1.get(3));

      List<Integer> feed5 = twitter.getNewsFeed(5);
      assertEquals(7, feed5.size());
      assertEquals(302, feed5.get(0));
      assertEquals(202, feed5.get(1));
      assertEquals(501, feed5.get(2));
      assertEquals(401, feed5.get(3));
      assertEquals(301, feed5.get(4));
      assertEquals(201, feed5.get(5));
      assertEquals(101, feed5.get(6));
   }
}