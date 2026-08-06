class Solution(object):
    def convertTime(self, current, correct):
        """
        :type current: str
        :type correct: str
        :rtype: int
        """
        h1 = int(current[:2])
        m1 = int(current[3:])
        h2 = int(correct[:2])
        m2 = int(correct[3:])
        t1 = h1 * 60 + m1
        t2 = h2 * 60 + m2
        d = t2 - t1
        ans = 0
        ans += d // 60
        d %= 60
        ans += d // 15
        d %= 15
        ans += d // 5
        d %= 5
        ans += d
        return ans

        