package Array.String;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution for LeetCode 75 - Kids With the Greatest Number of Candies
 * Determines which kids can have the greatest number of candies.
 */
public class KidsWithTheGreatestNumberOfCandies {

    /**
     * Determines which kids can have the greatest number of candies after adding extra candies.
     * 
     * @param candies array representing the number of candies each kid has
     * @param extraCandies the number of extra candies to add
     * @return list of boolean values indicating if each kid can have the greatest number of candies
     */
    private List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        return Arrays.stream(candies)
            .mapToObj(candy -> candy + extraCandies >= Arrays.stream(candies).max().getAsInt())
            .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies kidsWithTheGreatestNumberOfCandies = new KidsWithTheGreatestNumberOfCandies();
        System.out.println(kidsWithTheGreatestNumberOfCandies.kidsWithCandies(new int[] {2,3,5,1,3}, 3));
    }
    
}
