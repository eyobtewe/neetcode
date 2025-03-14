package binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TimeBasedKeyValueStore {
   record Pair(String value, Integer timestamp) {}

   private final HashMap<String, List<Pair>> store;

   public TimeBasedKeyValueStore() {
      store = new HashMap<>();
   }

   public void set(String key, String value, int timestamp) {

      List<Pair> pairs = store.getOrDefault(key, new ArrayList<>());
      pairs.add(new Pair(value, timestamp));

      store.put(key, pairs);

   }

   public String get(String key, int timestamp) {
      String result = "";
      if ( store.containsKey(key) ) {
         List<Pair> pairs = store.get(key);

         int left = 0, right = pairs.size() - 1, mid;

         while ( left <= right ) {

            mid = (left + right) / 2;
            Pair item = pairs.get(mid);

            if ( item.timestamp() == timestamp ) return item.value();
            else if ( item.timestamp() > timestamp ) {
               right = mid - 1;
            } else {
               left = mid + 1;
               result = item.value();
            }

         }

      }

      return result;
   }
}

class main {
   public static void main(String[] args) {
      TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();
      timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.

      System.out.println(timeMap.get("alice", 1));           // return "happy"
      System.out.println(timeMap.get("alice", 2));           // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
      timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
      System.out.println(timeMap.get("alice", 3));           // return "sad"

      // Test Case 1
      TimeBasedKeyValueStore timeMap1 = new TimeBasedKeyValueStore();
      timeMap1.set("foo", "bar", 1);
      System.out.println(timeMap1.get("foo", 1)); // "bar"
      System.out.println(timeMap1.get("foo", 3)); // "bar"
      timeMap1.set("foo", "bar2", 4);
      System.out.println(timeMap1.get("foo", 4)); // "bar2"
      System.out.println(timeMap1.get("foo", 5)); // "bar2"

      // Test Case 2
      TimeBasedKeyValueStore timeMap2 = new TimeBasedKeyValueStore();
      timeMap2.set("love", "high", 10);
      timeMap2.set("love", "low", 20);
      System.out.println(timeMap2.get("love", 5));  // ""
      System.out.println(timeMap2.get("love", 10)); // "high"
      System.out.println(timeMap2.get("love", 15)); // "high"
      System.out.println(timeMap2.get("love", 20)); // "low"
      System.out.println(timeMap2.get("love", 25)); // "low"

      // Test Case 3 (very long get calls)
      TimeBasedKeyValueStore timeMap3 = new TimeBasedKeyValueStore();
      timeMap3.set("foo", "bar", 1);
      for ( int i = 1; i <= 200; i++ ) {
         System.out.println(timeMap3.get("foo", 10000000));
      }
   }
}