package Array.String;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        return Arrays.stream(candies)
            .mapToObj(candy -> candy + extraCandies >= Arrays.stream(candies).max().getAsInt())
            .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies kidsWithTheGreatestNumberOfCandies = new KidsWithTheGreatestNumberOfCandies();
        System.out.println(kidsWithTheGreatestNumberOfCandies.kidsWithCandies(new int[] {2,3,5,1,3}, 3));
    }
    
}
