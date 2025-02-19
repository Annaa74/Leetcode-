class SnapshotArray(object):

    def __init__(self, length):
        """
        :type length: int
        """
        self.snap_id = 0
        self.history = [[(0, 0)] for _ in range(length)]  # Store (snap_id, value) pairs

    def set(self, index, val):
        """
        :type index: int
        :type val: int
        :rtype: None
        """
        if self.history[index][-1][0] == self.snap_id:
            self.history[index][-1] = (self.snap_id, val)
        else:
            self.history[index].append((self.snap_id, val))

    def snap(self):
        """
        :rtype: int
        """
        self.snap_id += 1
        return self.snap_id - 1

    def get(self, index, snap_id):
        """
        :type index: int
        :type snap_id: int
        :rtype: int
        """
        changes = self.history[index]
        # Binary search to find the value at snap_id
        l, r = 0, len(changes) - 1
        while l < r:
            m = (l + r + 1) // 2
            if changes[m][0] <= snap_id:
                l = m
            else:
                r = m - 1
        return changes[l][1]

# Example usage:
length = 3
snapshotArr = SnapshotArray(length)  # Initialize with length 3
snapshotArr.set(0, 5)  # Set array[0] = 5
print(snapshotArr.snap())  # Take a snapshot, return snap_id = 0
snapshotArr.set(0, 6)  # Set array[0] = 6
print(snapshotArr.get(0, 0))  # Get the value of array[0] with snap_id = 0, return 5

