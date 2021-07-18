class Solution(object):
    """
    Given an array of integers arr, return true if and only if it is a valid mountain array.

    Recall that arr is a mountain array if and only if:

    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
    arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    arr[i] > arr[i + 1] > ... > arr[arr.length - 1]



    Example 1:
    Input: arr = [2,1]
    Output: false

    Example 2:
    Input: arr = [3,5,5]
    Output: false

    Example 3:
    Input: arr = [0,3,2,1]
    Output: true

    Constraints:

    1 <= arr.length <= 104
    0 <= arr[i] <= 104
    """

    def validMountainArray(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        l = len(arr)
        if l < 3:
            return False
        max_value = None
        for i, num in enumerate(arr):
            if max_value is None or num > max_value:
                max_value = num
                a = i
        if a == l - 1 or a == 0:
            return False
        right = arr[a]
        left = arr[a]
        for i in range(a + 1, l):
            if arr[i] >= right:
                return False
            right = arr[i]
        for i in range(a - 1, -1, -1):
            if arr[i] >= left:
                return False
            left = arr[i]
        return True
