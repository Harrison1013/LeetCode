class Solution(object):
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
