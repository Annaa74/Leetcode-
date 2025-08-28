class Solution(object):
    def maxProductDifference(self, nums):
        max1 = max2 = float('-inf')
        min1 = min2 = float('inf')

        for num in nums:
            # Update max1 and max2
            if num > max1:
                max2 = max1
                max1 = num
            elif num > max2:
                max2 = num

            # Update min1 and min2
            if num < min1:
                min2 = min1
                min1 = num
            elif num < min2:
                min2 = num

        return (max1 * max2) - (min1 * min2)