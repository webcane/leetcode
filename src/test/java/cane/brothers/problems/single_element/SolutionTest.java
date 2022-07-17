package cane.brothers.problems.single_element;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void getSingleElement_one() {
    int[] nums = new int[] {1, 2, 2, 3, 3};
    Solution sol = new Solution();
    assertEquals(1, sol.getSingleElement(nums), "wrong single element");
  }

  @Test()
  void getSingleElement_no_one() {
    int[] nums = new int[] {1, 1, 2, 2, 3, 3};
    Solution sol = new Solution();
    IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () ->
        sol.getSingleElement(nums)
    );
    assertEquals("there is no single element", thrown.getMessage());
  }

  @Test
  void getSingleElement_all() {
    int[] nums = new int[] {1, 2, 3};
    Solution sol = new Solution();
    IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () ->
        sol.getSingleElement(nums)
    );
    assertEquals("there is no single element", thrown.getMessage());
  }
}