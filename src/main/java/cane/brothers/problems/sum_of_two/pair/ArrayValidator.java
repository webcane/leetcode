package cane.brothers.problems.sum_of_two.pair;

/**
 * Validator for array inputs.
 * Follows Single Responsibility Principle (SRP) - only handles validation.
 */
public class ArrayValidator {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 10_000;

    /**
     * Validates the input array.
     *
     * @param nums The array to validate.
     * @throws NullPointerException if nums is null.
     * @throws IllegalArgumentException if array length is out of bounds.
     */
    public void validate(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("nums should be given");
        }
        if (nums.length < MIN_LENGTH || nums.length > MAX_LENGTH) {
            throw new IllegalArgumentException(
                String.format("%d <= nums.length <= %d", MIN_LENGTH, MAX_LENGTH)
            );
        }
    }
}

