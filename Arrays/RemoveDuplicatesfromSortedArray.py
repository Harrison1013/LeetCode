class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        j = 0
        for i, num in enumerate(nums):
            # 第一位不會重複
            if i == 0:
                j += 1
                continue
            if num != nums[i - 1]:
                nums[j] = num
                j += 1
        return j
