class Solution(object):
    def nextGreatestLetter(self, letters, target):
        """
        :type letters: List[str]
        :type target: str
        :rtype: str
        """
        left, right = 0, len(letters) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            if letters[mid] <= target:
                left = mid + 1
            else:
                right = mid - 1

        return letters[left % len(letters)]

# Example usage:
solution = Solution()
letters1 = ["c","f","j"]
target1 = "a"
letters2 = ["c","f","j"]
target2 = "c"
letters3 = ["x","x","y","y"]
target3 = "z"

print(solution.nextGreatestLetter(letters1, target1))  # Output: "c"
print(solution.nextGreatestLetter(letters2, target2))  # Output: "f"
print(solution.nextGreatestLetter(letters3, target3))  # Output: "x"
