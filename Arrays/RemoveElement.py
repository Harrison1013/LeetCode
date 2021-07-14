class Solution(object):
    def remove_element(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        j = 0
        for num in nums:
            if num != val:
                nums[j] = num
                j += 1
        return j