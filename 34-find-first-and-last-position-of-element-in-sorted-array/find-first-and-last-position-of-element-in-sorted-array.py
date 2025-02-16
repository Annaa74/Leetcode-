class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def findFirst(nums, target):
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] >= target:
                    right = mid - 1
                else:
                    left = mid + 1
            return left if left < len(nums) and nums[left] == target else -1

        def findLast(nums, target):
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] <= target:
                    left = mid + 1
                else:
                    right = mid - 1
            return right if right >= 0 and nums[right] == target else -1
        
        first = findFirst(nums, target)
        last = findLast(nums, target)
        return [first, last] if first != -1 else [-1, -1]

# Example usage:
solution = Solution()
print(solution.searchRange([5,7,7,8,8,10], 8))  # Output: [3, 4]
print(solution.searchRange([5,7,7,8,8,10], 6))  # Output: [-1, -1]
print(solution.searchRange([], 0))  # Output: [-1, -1]
