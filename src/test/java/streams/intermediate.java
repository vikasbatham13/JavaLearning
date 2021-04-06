package streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// filter()
//map()
//flatMap()
//distinct()
//sorted() stateful , natural order
//peek()

/*limit() - stateful unlike skip(), which consumes the entire stream, as soon as limit() reaches the maximum number of items,
it doesn't consume any more items and simply returns the resulting stream. Hence,
we say that limit() is a short-circuiting operation.*/


/*  skip()  stateful Generally skip() is a cheap operation,
 it can be quite expensive on ordered parallel pipelines, especially for large values of n. */

public class intermediate {

    @Test
    public void testFilter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // predicate are functional interfaces
        Predicate<Integer> greaterThan3 = x -> x > 3;

        assertEquals(Arrays.asList(4, 5, 6, 7, 8, 9, 10), list.stream()
            .filter(greaterThan3)
            .collect(Collectors.toList()));

    }

    @Test
    public void testPeek() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // predicate are functional interfaces
        Predicate<Integer> greaterThan3 = x -> x > 3;

        List<Integer> response = list.stream()
            .filter(greaterThan3).peek(System.out::println)
            .collect(Collectors.toList());

        assertEquals(Arrays.asList(4, 5, 6, 7, 8, 9, 10), response);

    }

    // This is statefull
    @Test
    public void testSkip() {
        List<Integer> listInteger = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .filter(i -> i % 2 == 0)
            .skip(2) // skip first 2 records which are 2 and 4
            .collect(Collectors.toList());
        System.out.println(listInteger);
        assertArrayEquals(Arrays.asList(6, 8, 10).toArray(), listInteger.toArray());

    }

    @Test
    public void testLimit() {

        List<Integer> listInteger = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .filter(i -> i % 2 == 0)
            .limit(2) // limit first 2 records which are 2,4
            .collect(Collectors.toList());
        System.out.println(listInteger);
        assertArrayEquals(Arrays.asList(2, 4).toArray(), listInteger.toArray());
    }

    // This is stateful
    @Test
    public void testSorted() {

        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

        List<Integer> sortedList = list.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println(sortedList);

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), sortedList);

    }
    // This is stateful

    @Test
    public void testSortedUsingInbuiltComparator() {

        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

        List<Integer> sortedList = list.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        System.out.println(sortedList);

        assertEquals(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1), sortedList);

    }

    @Test
    public void testSortedUsingCustomComparator() {

        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

        Comparator<Integer> reverse = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        List<Integer> sortedList = list.stream()
            .sorted(reverse)
            .collect(Collectors.toList());
        System.out.println(sortedList);

        assertEquals(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1), sortedList);

    }

    @Test
    public void testSortedUsingLambda() {

        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

        List<Integer> sortedList = list.stream()
            .sorted((a, b) -> b.compareTo(a))
            .collect(Collectors.toList());
        System.out.println(sortedList);

        assertEquals(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1), sortedList);

    }

    // This is stateful
    @Test
    public void testDistinct() {


    }

    @Test
    public void testMap() {
        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> listOfIntegers = listOfStrings.stream()
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        System.out.println(listOfIntegers);

        assertEquals(Arrays.asList(1, 2, 3, 4, 5), listOfIntegers);
    }

    @Test
    public void testFlatMap() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> integerList = listOfLists.stream().flatMap(i -> i.stream()).collect(Collectors.toList());

        String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};

        List<String> listOfAllChars = Arrays.stream(dataArray)
            .flatMap(x -> Arrays.stream(x))
            .collect(Collectors.toList());

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), integerList);
        assertEquals(Arrays.asList("a","b","c","d","e","f","g","h"), listOfAllChars);

    }
}
