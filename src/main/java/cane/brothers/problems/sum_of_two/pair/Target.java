package cane.brothers.problems.sum_of_two.pair;

import java.util.Set;

/**
 * Record representing a target sum with functionality to find pairs of array elements
 * that sum to the target value.
 *
 * <p>This class encapsulates the "Two Sum" problem logic, finding all unique pairs
 * of indices (i, j) where the elements at those indices sum to the target value.</p>
 *
 * <p><strong>Design Principles:</strong></p>
 * <ul>
 *   <li>Follows Single Responsibility Principle (SRP) by delegating finding logic to {@link TargetFinder}</li>
 *   <li>Follows Dependency Inversion Principle (DIP) by depending on {@link TargetFinder} abstraction</li>
 * </ul>
 *
 * <p><strong>Example usage:</strong></p>
 * <pre>{@code
 * Target target = new Target(9);
 * int[] nums = {2, 7, 11, 15};
 * Set<Pair<Integer, Integer>> pairs = target.findPairs(nums);
 * // Returns a set containing Pair(0, 1) since nums[0] + nums[1] = 2 + 7 = 9
 * }</pre>
 *
 * @param target The target sum value to find pairs for
 * @see TargetFinder
 * @see HashTargetFinder
 * @see ArrayValidator
 */
public record Target(int target) {

    private static final ArrayValidator DEFAULT_VALIDATOR = new ArrayValidator();
    private static final TargetFinder DEFAULT_FINDER = new HashTargetFinder();

    /**
     * Finds all unique pairs of indices (i, j) such that nums[i] + nums[j] equals the target value,
     * where i &lt; j.
     *
     * <p>The method validates the input array before processing and uses a hash-based
     * approach for efficient pair detection.</p>
     *
     * <p><strong>Constraints:</strong></p>
     * <ul>
     *   <li>2 &lt;= nums.length &lt;= 10,000</li>
     *   <li>The array must not be null</li>
     * </ul>
     *
     * <p><strong>Algorithm Complexity:</strong></p>
     * <ul>
     *   <li>Time Complexity: O(n) where n is the length of the array</li>
     *   <li>Space Complexity: O(n) for the hash table storage</li>
     * </ul>
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code
     * Target target = new Target(10);
     * int[] nums = {3, 7, 2, 8, 5};
     * Set<Pair<Integer, Integer>> pairs = target.findPairs(nums);
     * // Returns pairs: {Pair(0, 3), Pair(1, 2)}
     * // because nums[0] + nums[3] = 3 + 7 = 10 and nums[1] + nums[2] = 7 + 3 = 10
     * }</pre>
     *
     * @param nums The array of numbers to find pairs in; must not be null
     * @return A set of unique pairs containing indices (i, j) where i &lt; j and nums[i] + nums[j] = target
     * @throws NullPointerException if nums is null
     * @throws IllegalArgumentException if array length is out of bounds [2, 10000]
     * @see HashTargetFinder#findPairs(int[], int)
     * @see ArrayValidator#validate(int[])
     */
    public Set<Pair<Integer, Integer>> findPairs(int[] nums) {
        DEFAULT_VALIDATOR.validate(nums);
        return DEFAULT_FINDER.findPairs(nums, target);
    }
}
