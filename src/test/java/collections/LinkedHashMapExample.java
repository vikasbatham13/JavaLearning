package collections;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
orders its entries according to how they're inserted into the map. It also guarantees that this order will be maintained throughout the life cycle of the map:
* */
public class LinkedHashMapExample {

    @Test
    public void testLinkedHasMap() {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);

        Set<Integer> keys = map.keySet();

        Integer [] arr = keys.toArray(new Integer[0]);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(new Integer(i + 1), arr[i]);
        }

    }

    @Test
    public void givenLinkedHashMap_whenAccessOrderWorks_thenCorrect() {

        /*
        LinkedHashMap provides a special constructor which enables us to specify,
        among custom load factor (LF) and initial capacity, a different ordering mechanism/strategy called access-order:

LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, .75f, true);
The first parameter is the initial capacity,
followed by the load factor and the last param is the ordering mode.
So, by passing in true, we turned on access-order, whereas the default was insertion-order.
        * */

        LinkedHashMap<Integer, String> map
            = new LinkedHashMap<>(16, .75f, true);
        map.put(1, null);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);
        map.put(5, null);

        Set<Integer> keys = map.keySet();
        assertEquals("[1, 2, 3, 4, 5]", keys.toString());

        map.get(4);
        assertEquals("[1, 2, 3, 5, 4]", keys.toString());

        map.get(1);
        assertEquals("[2, 3, 5, 4, 1]", keys.toString());

        map.get(3);
        assertEquals("[2, 5, 4, 1, 3]", keys.toString());
    }
}
