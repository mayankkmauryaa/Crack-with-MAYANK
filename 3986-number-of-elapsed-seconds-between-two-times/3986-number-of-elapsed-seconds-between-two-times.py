class Solution(object):
    def secondsBetweenTimes(self, startTime, endTime):
        """
        :type startTime: str
        :type endTime: str
        :rtype: int
        """

        def toSeconds(t):
            h = int(t[:2])
            m = int(t[3:5])
            s = int(t[6:])
            return h * 3600 + m * 60 + s

        return toSeconds(endTime) - toSeconds(startTime)