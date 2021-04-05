package streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testSkip() {


    }

    @Test
    public void testLimit() {


    }

    @Test
    public void testSorted() {


    }

    @Test
    public void testDistinct() {


    }

    @Test
    public void testMap() {


    }

    @Test
    public void testFlatMap() {


    }
}
