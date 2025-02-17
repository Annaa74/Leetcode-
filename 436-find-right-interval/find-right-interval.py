class Solution(object):
    def findRightInterval(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[int]
        """
        import bisect
        
        # Extract the start points and their original indices
        starts = sorted((interval[0], i) for i, interval in enumerate(intervals))
        result = []
        
        for interval in intervals:
            end = interval[1]
            # Use binary search to find the insertion point
            index = bisect.bisect_left(starts, (end,))
            if index < len(starts):
                result.append(starts[index][1])
            else:
                result.append(-1)
        
        return result

# Example usage:
solution = Solution()
intervals1 = [[1,2]]
print(solution.findRightInterval(intervals1))  # Output: [-1]

intervals2 = [[3,4],[2,3],[1,2]]
print(solution.findRightInterval(intervals2))  # Output: [-1,0,1]

intervals3 = [[1,4],[2,3],[3,4]]
print(solution.findRightInterval(intervals3))  # Output: [-1,2,-1]

