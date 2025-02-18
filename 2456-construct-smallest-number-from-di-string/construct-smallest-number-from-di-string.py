class Solution(object):
    def smallestNumber(self, pattern):
        """
        :type pattern: str
        :rtype: str
        """
        stack = []
        result = []
        num = 1
        
        for char in pattern:
            stack.append(num)
            num += 1
            if char == 'I':
                while stack:
                    result.append(str(stack.pop()))
        
        stack.append(num)
        while stack:
            result.append(str(stack.pop()))
        
        return ''.join(result)

# Example usage:
solution = Solution()
pattern1 = "IIIDIDDD"
pattern2 = "DDD"
print(solution.smallestNumber(pattern1))  # Output: "123549876"
print(solution.smallestNumber(pattern2))  # Output: "4321"
