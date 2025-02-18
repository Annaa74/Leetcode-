class TimeMap(object):

    def __init__(self):
        self.store = {}

    def set(self, key, value, timestamp):
        """
        :type key: str
        :type value: str
        :type timestamp: int
        :rtype: None
        """
        if key not in self.store:
            self.store[key] = []
        self.store[key].append((timestamp, value))

    def get(self, key, timestamp):
        """
        :type key: str
        :type timestamp: int
        :rtype: str
        """
        if key not in self.store:
            return ""
        
        values = self.store[key]
        left, right = 0, len(values) - 1
        result = ""
        
        while left <= right:
            mid = (left + right) // 2
            if values[mid][0] <= timestamp:
                result = values[mid][1]
                left = mid + 1
            else:
                right = mid - 1
        
        return result

# Example usage:
obj = TimeMap()
obj.set("foo", "bar", 1)
print(obj.get("foo", 1))  # Output: "bar"
print(obj.get("foo", 3))  # Output: "bar"
obj.set("foo", "bar2", 4)
print(obj.get("foo", 4))  # Output: "bar2"
print(obj.get("foo", 5))  # Output: "bar2"
