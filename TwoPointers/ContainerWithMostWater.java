package TwoPointers;

/**
 * Solution for LeetCode 75 - Container With Most Water
 * Find two lines that together with the x-axis form a container that holds the most water.
 */
public class ContainerWithMostWater {

    /**
     * Finds the maximum area of water that can be contained by two vertical lines.
     * Uses two-pointer technique starting from both ends and moving inward.
     * 
     * @param height array of integers representing the height of each vertical line
     * @return the maximum area of water that can be contained
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;  // Left pointer starting from beginning
        int right = height.length - 1;  // Right pointer starting from end
        
        while (left < right) {
            // Calculate area between current left and right pointers
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            
            // Move pointer with smaller height inward to potentially find larger area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));
    }
    
}
