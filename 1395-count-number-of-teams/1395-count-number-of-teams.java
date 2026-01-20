// Infinity - BootCamp
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams = 0;

        // fixing j as middle
        for (int j = 0; j < n; j++) {
            int rightMin = 0;
            int rightMax = 0;
            int leftMin = 0;
            int leftMax = 0;

            // Count how many soldiers on the left
            for (int i = 0; i < j; i++) {
                if (rating[i] > rating[j]) leftMax++;
                else leftMin++;
            }

            // Count how many soldiers on the right
            for (int k = j + 1; k < n; k++) {
                if (rating[k] > rating[j]) rightMax++;
                else rightMin++;
            }

            // rating[i] < rating[j] < rating[k]
            teams += leftMin * rightMax;

            // rating[i] > rating[j] > rating[k]
            teams += leftMax * rightMin;
        }
        return teams;
    }
}

/*
Key Insight
For every soldier j as the middle of the team:

Count how many soldiers on the left are:
smaller than rating[j] → leftSmaller
greater than rating[j] → leftGreater

Count how many soldiers on the right are:
greater than rating[j] → rightGreater
smaller than rating[j] → rightSmaller

Valid teams using j as middle:
Increasing: leftSmaller * rightGreater
Decreasing: leftGreater * rightSmaller
Sum this for all j.

*/