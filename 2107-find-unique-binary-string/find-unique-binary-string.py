class Solution(object):
    def findDifferentBinaryString(self, nums):
        """
        :type nums: List[str]
        :rtype: str
        """
        n = len(nums)
        unique_string = ""
        
        for i in range(n):
            # Flip the i-th character of the i-th string
            unique_string += '1' if nums[i][i] == '0' else '0'
        
        return unique_string

# Example usage:
solution = Solution()
print(solution.findDifferentBinaryString(["01", "10"]))  # Output: "11"
print(solution.findDifferentBinaryString(["00", "01"]))  # Output: "11"
print(solution.findDifferentBinaryString(["111", "011", "001"]))  # Output: "101"
