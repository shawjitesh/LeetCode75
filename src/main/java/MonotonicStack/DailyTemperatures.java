package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Solution for Daily Temperatures problem.
 * Finds the number of days until a warmer temperature for each day.
 */
public class DailyTemperatures {

    /**
     * Returns an array where each element is the number of days until a warmer temperature.
     * Uses monotonic stack to efficiently track indices of temperatures.
     *
     * @param temperatures array of daily temperatures
     * @return array where result[i] is the number of days until a warmer temperature after day i
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int temperaturesLength = temperatures.length;
        int[] result = new int[temperaturesLength];

        Stack<Integer> stack = new Stack<>();
        for (int currentDay = 0; currentDay < temperaturesLength; currentDay++) {
            int currentTemperatire = temperatures[currentDay];
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemperatire) {
                int previousDay = stack.pop();
                result[previousDay] = currentDay - previousDay;
            }
            stack.push(currentDay);
        }

        // TLE
        // int left = 0, right = 1, index = 0;
        // while (left < temperaturesLength) {
        //     while (right < temperaturesLength && temperatures[right] <= temperatures[left]) {
        //         right++;
        //     }
        //     result[index++] = right < temperaturesLength ? right - left : 0;
        //     left++;
        //     right = left + 1;
        // }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
    }
    
}
