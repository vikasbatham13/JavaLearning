package streams;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class mapvsflatmap {

    @Test
    public void testJavaStreamMap(){
        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> listOfIntegers = listOfStrings.stream()
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        System.out.println(listOfIntegers);

        assertEquals(Arrays.asList(1,2,3,4,5),listOfIntegers);
    }

    @Test
    public void testJavaFlatMap(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> integerList = listOfLists.stream().flatMap(i -> i.stream()).collect(Collectors.toList());

        assertEquals(Arrays.asList(1,2,3,4,5,6,7,8,9),integerList);
    }
}
