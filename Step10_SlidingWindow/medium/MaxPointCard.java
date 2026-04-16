package Step10_SlidingWindow.medium;
/*
Problem Statement: Given N cards arranged in a row, each card has an
 associated score denoted by the cardScore array. Choose exactly k cards.
  In each step, a card can be chosen either from the beginning or the end
  of the row. The score is the sum of the scores of the chosen cards.

Examples

Input :cardScore = [1, 2, 3, 4, 5, 6] , k = 3
Output : 15
Explanation :Choosing the rightmost cards will maximize your total score.
So optimal cards chosen are the rightmost three cards 4 , 5 , 6.
Th score is 4 + 5 + 6 => 15.


Input :cardScore = [5, 4, 1, 8, 7, 1, 3 ] , k = 3
Output :12
Explanation : In first step we will choose card from beginning with score of 5.
In second step we will choose the card from beginning again with score of 4.
In third step we will choose the card from end with score of 3.
The total score is 5 + 4 + 3 => 12
 */
public class MaxPointCard {
    static void main() {
        int[] cardScore={5, 4, 1, 8, 7, 1, 3};
        int k=3;
        System.out.println(optimal(cardScore,k));
    }
    public static int brute(int[] cardPoints, int k) {
        // Total number of cards
        int n = cardPoints.length;

        // Variable to store the max score found
        int maxSum = 0;

        // Try all combinations: i from front, k-i from back
        for (int i = 0; i <= k; i++) {
            // Store current sum for this combo
            int tempSum = 0;

            // Add first i cards from front
            for (int j = 0; j < i; j++) {
                tempSum += cardPoints[j];
            }

            // Add remaining cards from back
            for (int j = 0; j < k - i; j++) {
                tempSum += cardPoints[n - 1 - j];
            }

            // Update max score
            maxSum = Math.max(maxSum, tempSum);
        }

        // Return the highest score possible
        return maxSum;
    }
    public static int optimal(int[] cardPoints, int k) {
        // Get the total number of cards
        int n = cardPoints.length;

        // Calculate the sum of first k cards from the front
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        // Store the maximum score
        int maxPoints = total;

        // Slide the window: remove from front and add from back
        for (int i = 0; i < k; i++) {
            // Subtract card from front
            total -= cardPoints[k - 1 - i];

            // Add card from back
            total += cardPoints[n - 1 - i];

            // Update the max score
            maxPoints = Math.max(maxPoints, total);
        }

        // Return the best possible score
        return maxPoints;
    }
}
