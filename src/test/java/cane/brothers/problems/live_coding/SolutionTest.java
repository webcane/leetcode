package cane.brothers.problems.live_coding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cane.brothers.problems.live_coding.Solution.*;
import static cane.brothers.problems.search_duplicates.Solution.containsDuplicate;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test_removeZeroValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 0);
        map.put("c", 20);
        map.put("d", 0);

        removeZeroValues(map); // {a=10, c=20}

        assertEquals(map, Map.of("a", 10, "c", 20));
    }

    @Test
    void test_keyOfMaxValue() {
        Map<String, Integer> map = Map.of("alice", -10, "bob", -5, "charlie", -20);

        assertEquals("bob", keyOfMaxValue(map));
    }


    @Test
    void test_findMin() {
        assertEquals(1, findMin(List.of(5, 2, 8, 1)));   // 1
        assertEquals(-20, findMin(List.of(-10, -3, -20))); // -20
        assertEquals(7, findMin(List.of(7)));            // 7
        assertEquals(null, findMin(List.of()));             // null
    }

    @Test
    void test_findMax() {
        assertEquals(7, findMax(new int[]{3, 7, 2}));       // 7
        assertEquals(-2, findMax(new int[]{-5, -2, -10}));   // -2
        assertEquals(Integer.MIN_VALUE, findMax(new int[]{Integer.MIN_VALUE})); // Integer.MIN_VALUE
        assertEquals(null, findMax(new int[]{}));              // null
    }

    @Test
    void test_longestWord() {
        assertEquals("", longestWord(List.of(""))); // Ожидается ""
        assertEquals("elephant", longestWord(List.of("cat", "elephant", "dog"))); // "elephant"
        assertEquals("java", longestWord(List.of("java", "code", "test"))); // "java" — первое из слов максимальной длины
        assertEquals("a", longestWord(List.of("a"))); // "a"
        assertEquals(null, longestWord(List.of())); // null
    }

    @Test
    void test_mostFrequent() {
        assertEquals("a", mostFrequent(new String[]{"a", "b", "a", "c", "a", "b"})); // "a"
        assertEquals("x", mostFrequent(new String[]{"x", "y", "x", "y"})); // "x" или "y"
        assertEquals("hello", mostFrequent(new String[]{"hello"})); // "hello"
        assertEquals(null, mostFrequent(new String[]{})); // null
    }

    @Test
    void test_groupByLength() {
//        assertEquals(
//        groupByLength(new String[]{"a", "cat", "to", "dog", "hi"});
// {
//   1=[a],
//   2=[to, hi],
//   3=[cat, dog]
// }

//        groupByLength(new String[]{});
// {}

//        groupByLength(new String[]{"", "a", ""});
// {
//   0=["", ""],
//   1=["a"]
// }
    }

    @Test
    void test_sortByLength() {
        List<String> words = new ArrayList<>(List.of("dog", "a", "cat", "bb", "apple", "ant"));

        sortByLength(words);  // [a, bb, ant, cat, dog, apple]

        assertEquals(List.of("a", "bb", "ant", "cat", "dog", "apple"), words);
    }

    @Test
    void test_sortByLengthDescending() {
        List<String> words = new ArrayList<>(List.of("cat", "apple", "dog", "banana", "ant", "bee"));

        sortByLengthDescending(words); // [banana, apple, ant, bee, cat, dog]

        assertEquals(List.of("banana", "apple", "ant", "bee", "cat", "dog"), words);
    }

    @Test
    void test_sortEmployees() {
//        List<Employee> employees = new ArrayList<>(List.of(
//                new Employee("Bob", 30, 5000),
//                new Employee("Alice", 25, 7000),
//                new Employee("Charlie", 30, 7000),
//                new Employee("David", 25, 7000)
//        ));
//
//        sortEmployees(employees);
    }

    @Test
    void test_filter() {
// filter(List.of(1, 2, 3, 4), n -> n % 2 == 0);
//// [2, 4]
//
//filter(List.of("cat", "a", "dog"), s -> s.length() > 1);
//// [cat, dog]
//
//filter(List.of(), x -> true);
//// []
    }

    @Test
    void test_map() {
//        map(List.of(1, 2, 3), n -> n * 2); // [2, 4, 6]

//        map(List.of("cat", "dog"), String::length); // [3, 3]

//        map(List.of(), Object::toString); // []
    }
}