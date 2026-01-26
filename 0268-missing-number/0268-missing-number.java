class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int x = 1;
        for (int num : nums) {
            xor ^= num;
            xor ^= x;
            x++;
        }
        return xor;
    }
}

class Solution_maths {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int total = (n * (n - 1)) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return total - sum;
    }
}

class Solution_runningSum {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++)
            ans += i - nums[i];
        return ans;
    }
}

class Solution_reposition {
    public int missingNumber(int[] nums) { // resposition in another array a/c to idx
        int n = nums.length;
        int arr[] = new int[n + 1];
        Arrays.fill(arr, -1);
        for (int i = 0; i < n; i++) {
            arr[nums[i]] = nums[i];
        }
        for (int i = 0; i < n + 1; i++) {
            if (arr[i] == -1)
                return i;
        }
        return 0;
    }
}

class Solution_sort {
    public int missingNumber(int[] nums) { // sort -> edge case -> traverse
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] != 0)
            return 0;
        if (nums[n - 1] != n)
            return n;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return 0;
    }
}