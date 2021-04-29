package collections;

/*
Choosing the Right Map
Having looked at HashMap and LinkedHashMap implementations previously and now TreeMap, it is important to make a brief comparison between the three to guide us on which one fits where.

A hash map is good as a general-purpose map implementation that provides rapid storage and retrieval operations. However, it falls short because of its chaotic and unorderly arrangement of entries.

This causes it to perform poorly in scenarios where there is a lot of iteration as the entire capacity of the underlying array affects traversal other than just the number of entries.

A linked hash map possesses the good attributes of hash maps and adds order to the entries. It performs better where there is a lot of iteration because only the number of entries is taken into account regardless of capacity.

A tree map takes ordering to the next level by providing complete control over how the keys should be sorted. On the flip side, it offers worse general performance than the other two alternatives.

We could say a linked hash map reduces the chaos in the ordering of a hash map without incurring the performance penalty of a tree map.
* */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/* Tree Map
The TreeMap in Java is used to implement Map interface and NavigableMap along with the AbstractMap Class.
The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time,
depending on which constructor is used. This proves to be an efficient way of sorting and storing the key-value pairs.
The storing order maintained by the treemap must be consistent with equals just like any other sorted map,
irrespective of the explicit comparators. The treemap implementation is not synchronized in the sense
that if a map is accessed by multiple threads, concurrently and at least one of the threads modifies the map structurally,
 it must be synchronized externally.
* */

public class TreeMapExamples {

    @Test
    public void testTreeMap(){

     TreeMap<Integer,String> treeMap = new TreeMap<>();

     treeMap.put(2,"2");
     treeMap.put(1,"1");
     treeMap.put(4,"4");
     treeMap.put(17,"17");
     treeMap.put(7,"7");


        System.out.println("treemap size "+treeMap.size());
        System.out.println("treemap ceilingEntry "+treeMap.ceilingEntry(4));

        System.out.println("treemap treeMap.get(\"17\") "+treeMap.get(17));

        Assertions.assertEquals(new TreeMap<Integer,String>(){{put(1,"1");put(2,"2");put(4,"4");put(7,"7");put(17,"17");}},treeMap);

    }

    @Test
    public void givenTreeMap_whenOrdersEntriesByComparator_thenCorrect() {
        TreeMap<Integer, String> map =
            new TreeMap<>(Comparator.reverseOrder());
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");

        Assertions.assertEquals("[5, 4, 3, 2, 1]", map.keySet().toString());
    }

    @Test
    public void givenTreeMap_whenPerformsQueries_thenCorrect() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");

        Integer highestKey = map.lastKey();
        Integer lowestKey = map.firstKey();
        Set<Integer> keysLessThan3 = map.headMap(3).keySet();
        Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

        Assertions.assertEquals(new Integer(5), highestKey);
        Assertions.assertEquals(new Integer(1), lowestKey);
        Assertions.assertEquals("[1, 2]", keysLessThan3.toString());
        Assertions.assertEquals("[3, 4, 5]", keysGreaterThanEqTo3.toString());
    }
    @Test
    public void testTreeMapIteration(){

        // Declaring the tree map of Integer and String
        TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();

        // assigning the values in the tree map
        // using put()
        treemap.put(2, "two");
        treemap.put(0, "zero");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(9, "nine");
        treemap.put(7, "seven");

        System.out.println("treemap "+treemap);
        // putting values in navigable set
        // use of descendingKeySet
        NavigableSet set1 = treemap.descendingKeySet();

        System.out.println("Navigable set values are: " + set1);

        System.out.println("headMap: "+treemap.headMap(0,true));

    }
}
