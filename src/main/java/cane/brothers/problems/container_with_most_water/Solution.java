package cane.brothers.problems.container_with_most_water;

/**
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * <p>
 * Topics:
 * - Array
 * - Two Pointers
 * - Greedy
 */
public class Solution {

    public int maxArea(int[] height) {
        validateInput(height);
//        return classic(height);
//        return withPointers(height);
        return withArea(height);
    }

    private void validateInput(int[] height) {
        if (height == null) {
            throw new NullPointerException("height array should not be empty");
        }

        var n = height.length;

        if (n < 2 || n >= 100_000) {
            throw new IllegalArgumentException("2 <= n <= 10^5");
        }

        // TODO: non optimal
        for (int h : height) {
            if (h < 1 || h >= 10_000) {
                throw new IllegalArgumentException("0 <= height[i] <= 10^5");
            }
        }
    }

    private int classic(int[] height) {
        // brute force: O(n^2)
        // two pointers: O(n)
        var leftPointer = 0;
        var rightPointer = height.length - 1;
        var maxArea = 0;
        while (leftPointer < rightPointer) {
            var currHeight = Math.min(height[leftPointer], height[rightPointer]);
            var currArea = currHeight * (rightPointer - leftPointer);
            maxArea = Math.max(currArea, maxArea);

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxArea;
    }

    private int withArea(int[] height) {
        Area area = new Area(height);
        while (area.isCalculated()) {
            area.calcArea();
            area.moveSide();
        }
        return area.getMaxArea();
    }

    private int withPointers(int[] height) {
        Pointer left = new Pointer(0);
        Pointer right = new Pointer(height.length - 1);
        int maxArea = 0;
        while (left.get() < right.get()) {
            int currHeight = Math.min(height[left.get()], height[right.get()]);
            int currArea = currHeight * (right.get() - left.get());
            maxArea = Math.max(currArea, maxArea);
            if (height[left.get()] < height[right.get()]) {
                left.increment();
            } else {
                right.decrement();
            }
        }
        return maxArea;
    }

    private static class Area {
        private final int[] height;
        private int left; // leftSide
        private int right;
        private int maxArea = 0;// rightSide

        public Area(final int[] height) {
            this.left = 0;
            this.right = height.length - 1;
            this.height = height;
        }

        public boolean isCalculated() {
            //  move one of sides until they not meet each other
            return (left < right);
        }

        public void calcArea() {
            int currHeight = Math.min(height[left], height[right]);
            int currArea = currHeight * (right - left);
            maxArea = Math.max(currArea, maxArea);
        }

        public void moveSide() {
            if (height[left] < height[right]) {
                // move left side
                left++;
            } else {
                // move right side
                right--;
            }
        }

        public int getMaxArea() {
            return maxArea;
        }
    }

    private static class Pointer {
        private int position;

        public Pointer(int position) {
            this.position = position;
        }

        public int get() {
            return position;
        }

        public void increment() {
            position++;
        }

        public void decrement() {
            position--;
        }
    }
}
