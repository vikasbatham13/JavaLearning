package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
/* HashMap is similar to the HashTable, but it is unsynchronized. It allows to store the null keys as well, but there should be only one null key object
 and there can be any number of null values.
HashMap doesn’t allow duplicate keys but allows duplicate values.
 That means A single key can’t contain more than 1 value but more than 1 key can contain a single value.
 HashMap allows null key also but only once and multiple null values.

Using an Iterator: Iterator is an interface in java.util package which is used to iterate through a collection.
hm.entrySet() is used to retrieve all the key-value pairs called Map.Entries and stores internally into a set.
hm.entrySet().iterator() returns a iterator which acts as a cursor and points at the first element of the set and moves on till the end.
hmIterator.hasNext() checks for the next element in the set and returns a boolean
hmIterator.next() returns the next element(Map.Entry) from the set.
mapElement.getKey() returns the key of the associated Map.Entry
mapElement.getValue() return the value of the associated Map.Entry

 */

public class HashMapExample {

    @Test
    public void testHasMap() {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);

        map.forEach((K, V) -> {
            System.out.println("Key: " + K + " Value: " + V);
        });

        assertEquals(5, map.size());
        assertEquals(true, map.containsKey("4"));
        assertEquals(true, map.containsValue(4));


        assertEquals(Optional.of(1), Optional.ofNullable(map.getOrDefault(6, 1)));

    }

    @Test
    public void testHasMapIteration() {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);

        Iterator it = map.entrySet().iterator();

        assertEquals(5, map.size());



    }

}
