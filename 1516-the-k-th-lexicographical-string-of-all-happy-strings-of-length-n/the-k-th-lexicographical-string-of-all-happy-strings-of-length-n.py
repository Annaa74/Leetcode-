class Solution(object):
    def getHappyString(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        # Helper function to generate happy strings
        def generate_happy_strings(current, n, result):
            if len(current) == n:
                result.append(current)
                return
            for char in 'abc':
                if not current or current[-1] != char:
                    generate_happy_strings(current + char, n, result)
        
        happy_strings = []
        generate_happy_strings('', n, happy_strings)
        
        happy_strings.sort()
        
        if k <= len(happy_strings):
            return happy_strings[k-1]
        else:
            return ""

# Example usage:
solution = Solution()
print(solution.getHappyString(1, 3)) # Output: "c"
print(solution.getHappyString(1, 4)) # Output: ""
print(solution.getHappyString(3, 9)) # Output: "cab"
