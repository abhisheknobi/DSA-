package Step10_SlidingWindow;

import java.util.HashMap;
import java.util.Map;
/*
Problem Statement: There is only one row of fruit trees on the farm, oriented left to
right. An integer array called fruits represents the trees, where fruits[i] denotes the
kind of fruit produced by the ith tree.
The goal is to gather as much fruit as possible, adhering to the owner's stringent rules :

There are two baskets available, and each basket can only contain one kind of fruit. The
quantity of fruit each basket can contain is unlimited.
Start at any tree, but as you proceed to the right, select exactly one fruit from each tree,
 including the starting tree. One of the baskets must hold the harvested fruits.
Once reaching a tree with fruit that cannot fit into any basket, stop.
Return the maximum number of fruits that can be picked.

Examples
Input :fruits = [1, 2, 1]
Output :3
Explanation : We will start from first tree.
The first tree produces the fruit of kind '1' and we will put that in the first basket.
The second tree produces the fruit of kind '2' and we will put that in the second basket.
The third tree produces the fruit of kind '1' and we have first basket that is already holding
fruit of kind '1'. So we will put it in first basket.
Hence we were able to collect total of 3 fruits.


Input : fruits = [1, 2, 3, 2, 2]
Output : 4
Explanation : we will start from second tree.
The first basket contains fruits from second , fourth and fifth.
The second basket will contain fruit from third tree.
Hence we collected total of 4 fruits.
 */
public class FruitBasket {
    static void main() {
        int nums[]={1,2,3,2,2};
        System.out.println(optimal(nums ));
    }
    public static int brute(int[] fruits) {
        int maxFruits = 0;

        // Loop over each possible starting point
        for (int start = 0; start < fruits.length; ++start) {
            // Map to store the count of fruit types for THIS specific starting point
            Map<Integer, Integer> basket = new HashMap<>();
            int currentCount = 0;

            // Traverse from current start to the end
            for (int end = start; end < fruits.length; ++end) {
                // Add current fruit to the basket
                basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);

                // If basket has more than 2 types, we can't take this fruit
                if (basket.size() > 2) {
                    break;
                }

                // Increase current fruit count because it's a valid type
                currentCount++;
            }

            // After the inner loop finishes (or breaks), check if this was our best run
            maxFruits = Math.max(maxFruits, currentCount);
        }

        return maxFruits;
    }

    public static int better(int[] fruits) {
        // HashMap to track count of each fruit in current window
        Map<Integer, Integer> basket = new HashMap<>();

        // Initialize pointers and max result
        int left = 0;
        int maxFruits = 0;

        // Traverse the fruits array using right pointer
        for (int right = 0; right < fruits.length; right++) {
            // Include current fruit in the map
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // If more than 2 fruit types, shrink window from left
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);

                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }

                left++;
            }

            // Update maximum valid window length
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        // Return the final result
        return maxFruits;
    }

    public static int optimal(int[] fruits) {

        // Variables to track max window size
        int maxlen = 0;

        // Track last and second last fruit types
        int lastFruit = -1, secondLastFruit = -1;

        // Count of current window and streak of last fruit
        int currCount = 0, lastFruitStreak = 0;

        // Traverse through each fruit
        for (int fruit : fruits) {

            // If fruit matches last two, expand window
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currCount++;
            } else {
                // Reset window size to streak + 1
                currCount = lastFruitStreak + 1;
            }

            // Update lastFruit streak and fruit types
            if (fruit == lastFruit) {
                lastFruitStreak++;
            } else {
                lastFruitStreak = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            // Update max window size
            maxlen = Math.max(maxlen, currCount);
        }

        return maxlen;
    }

}
