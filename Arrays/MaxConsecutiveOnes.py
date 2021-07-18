class Solution(object):
    """
        Given a binary array nums, return the maximum number of consecutive 1's in the array.

        Example 1:

        Input: nums = [1,1,0,1,1,1]
        Output: 3
        Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
        Example 2:

        Input: nums = [1,0,1,1,0,1]
        Output: 2


        Constraints:

        1 <= nums.length <= 105
        nums[i] is either 0 or 1.
    """

    def find_max_consecutive_ones(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        temp = 0
        result = 0
        for i, num in enumerate(nums):
            if num == 1:
                if i == 0:
                    temp += 1
                    continue
                if nums[i] == nums[i - 1]:
                    temp += 1
                else:
                    if temp > result:
                        result = temp
                    temp = 1
        if temp > result:
            result = temp
        return result
