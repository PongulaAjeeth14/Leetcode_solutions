from collections import deque

class Solution:
    def maxSlidingWindow(self, nums, k):
        dq = deque()
        result = []

        for i in range(len(nums)):

            # Remove expired index
            if dq and dq[0] <= i - k:
                dq.popleft()

            # Remove smaller elements from the rear
            while dq and nums[dq[-1]] < nums[i]:
                dq.pop()

            # Add current index
            dq.append(i)

            # Start recording maximum when window size becomes k
            if i >= k - 1:
                result.append(nums[dq[0]])

        return result