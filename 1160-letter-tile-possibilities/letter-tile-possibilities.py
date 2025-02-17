class Solution(object):
    def numTilePossibilities(self, tiles):
        """
        :type tiles: str
        :rtype: int
        """
        def backtrack(path, counter):
            if path:
                result.add("".join(path))
            for char in counter:
                if counter[char] > 0:
                    counter[char] -= 1
                    path.append(char)
                    backtrack(path, counter)
                    path.pop()
                    counter[char] += 1

        from collections import Counter
        result = set()
        counter = Counter(tiles)
        backtrack([], counter)
        return len(result)

# Example usage:
solution = Solution()
tiles1 = "AAB"
print(solution.numTilePossibilities(tiles1))  # Output: 8

tiles2 = "AAABBC"
print(solution.numTilePossibilities(tiles2))  # Output: 188

tiles3 = "v"
print(solution.numTilePossibilities(tiles3))  # Output: 1