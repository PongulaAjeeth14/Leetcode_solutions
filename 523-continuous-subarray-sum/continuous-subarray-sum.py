class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        r_map = {0: -1}
        prefix_sum = 0

        for i, num in enumerate(nums):
            prefix_sum += num
            remainder = prefix_sum % k

            if remainder in r_map:
                if i - r_map[remainder] >= 2:
                    return True
            else:
                r_map[remainder] = i

        return False