class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 exists before the array starts
        map.put(0, -1);

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            // 0 = -1
            // 1 = +1
            if (nums[i] == 0) {
                prefixSum--;
            } else {
                prefixSum++;
            }

            // Have we seen this prefix sum before?
            if (map.containsKey(prefixSum)) {

                int previousIndex = map.get(prefixSum);

                int length = i - previousIndex;

                maxLength = Math.max(maxLength, length);

            } else {

                // Store FIRST occurrence only
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}