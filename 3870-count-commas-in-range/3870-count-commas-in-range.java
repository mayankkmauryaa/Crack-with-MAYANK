class Solution {
    public int countCommas(int n) {
        if (n < 1000)
            return 0;
        return n - 999;
    }
}

// class Solution {
//     public long countCommas(long n) {
//         long ans = 0;

//         // Numbers with 1 comma: 1000 to 999999
//         if (n >= 1000) {
//             long count = Math.min(n, 999999) - 1000 + 1;
//             ans += count;
//         }

//         // Numbers with 2 commas: 1000000 to 999999999
//         if (n >= 1000000) {
//             long count = Math.min(n, 999999999) - 1000000 + 1;
//             ans += count * 2;
//         }

//         return ans;
//     }
// }