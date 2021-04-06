package streams;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/* forEach()
For parallel streams, the forEach() operation does not guarantee the order of elements in the stream, as doing so would sacrifice the benefit of parallelism
Collection.forEach() uses the collection's iterator (if one is specified). That means that the processing order of the items is defined. In contrast, the processing order of Collection.stream().forEach() is undefined.
If we need to traverse the same data source again, we must return to the data source to get a new stream.
*/

/*
forEachOrdered() - While the forEachOrdered() operation respects the the encounter order of the Stream if the stream has a defined encounter order. This behavior is true for parallel streams as well as sequential streams.
* */
//toArray()
//reduce()
//collect()
//min()
//max()
//count()
//anyMatch()
//allMatch()
//noneMatch()
//findFirst()
//findAny()

public class terminal {

    @Test
    public void testForEach() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 10);
        hashMap.put("B", 20);
        hashMap.put("C", 30);
        hashMap.put("D", 40);
        hashMap.put("E", 50);
        hashMap.put("F", 60);
        List<Integer> ld = new ArrayList();

        hashMap.forEach((k, v) -> {
            if (k.equals("F") || k.equals("D"))
                ld.add(v);
        });

        Assertions.assertEquals(Arrays.asList(40, 60), ld);
        // order of elements are not guaranteed here
    }

    @Test
    public void testForEachOrdered() {
        List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);
        list.stream().parallel().forEach(System.out::println);        // elements can come in any order

        System.out.println("\n");

        list.stream().parallel().forEachOrdered(System.out::println); // elements will always come in order
        System.out.println("\n");

        list.stream()
            .sorted(Comparator.reverseOrder())
            .forEachOrdered(System.out::println);
    }

    @Test
    public void testToArray() {
        Stream<String> testStream = Stream.of("learning","java","jolly","joy");

        Object[] ar = testStream.filter(str -> str.startsWith("j")).toArray();

        Assertions.assertEquals(Arrays.asList("java","jolly","joy").toString(),Arrays.toString(ar));
    }

    @Test
    public void testMin() {
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

        Optional<Integer> minNumber = list.stream()
            .min((i, j) -> i.compareTo(j));

        System.out.println(minNumber.get());

        Comparator<Integer> minComparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        };

        Optional<Integer> minNumber2 = list.stream()
            .min(minComparator);

        System.out.println(minNumber2.get());

    }

    @Test
    public void testMax() {
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

        Optional<Integer> maxNumber = list.stream()
            .max((i, j) -> i.compareTo(j));

        System.out.println(maxNumber.get());

        Comparator<Integer> maxComparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer n1, Integer n2) {
                return n1.compareTo(n2);
            }
        };

        Optional<Integer> maxNumber2 = list.stream()
            .max(maxComparator);

        System.out.println(maxNumber2.get());

    }

    @Test
    public void testCount(){
        long count = Stream.of("how","to","do","in","java")
            .count();
        System.out.printf("There are %d words in the stream %n", count);

        count = IntStream.of(1,2,3,4,5,6,7,8,9)
            .count();
        System.out.printf("There are %d integers in the stream %n", count);

        count = LongStream.of(1,2,3,4,5,6,7,8,9)
            .filter(i -> i%2 == 0)
            .count();
        System.out.printf("There are %d even numbers in the stream %n", count);

    }

    @Test
    public void testCountUsingCollectors(){
        long count = Stream.of("how","to","do","in","java")
            .collect(Collectors.counting());
        System.out.printf("There are %d words in the stream %n", count);

        count = Stream.of(1,2,3,4,5,6,7,8,9)
            .collect(Collectors.counting());
        System.out.printf("There are %d integers in the stream %n", count);

        count = Stream.of(1,2,3,4,5,6,7,8,9)
            .filter(i -> i%2 == 0)
            .collect(Collectors.counting());
        System.out.printf("There are %d even numbers in the stream %n", count);
    }

    @Test
    public void testanyMatch(){
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        boolean match = stream.anyMatch(s -> s.contains("four"));

        Assertions.assertTrue(match);
    }

    @Test
    public void testallMatch(){
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        Predicate<String> containsDigit = s -> s.contains("\\d+") == false;
        boolean match = stream.allMatch(containsDigit);

        Assertions.assertTrue(match);
    }

    @Test
    public void testnoneMatch(){
        Stream<String> stream = Stream.of("one", "two", "three", "four");

        boolean match = stream.noneMatch( s -> s.contains("\\d+") );

        Assertions.assertTrue(match);
    }

    @Test
    public void testFindFirst(){
        Optional<String> one = Stream.of("one", "two", "three", "four")
            .findFirst();
        System.out.println(one.get());
        System.out.println("\n");

        Optional<String> two =  Stream.of("one", "two", "three", "four")
            .parallel()
            .findFirst();
        System.out.println(two.get());
    }

    @Test
    public void testFindAny(){
        Optional<String> one = Stream.of("one", "two", "three", "four")
            .findAny();
        System.out.println(one.get());
        System.out.println("\n");

        Optional<String> two =  Stream.of("one", "two", "three", "four")
            .parallel()
            .findAny();
        System.out.println(two.get());
    }
}
