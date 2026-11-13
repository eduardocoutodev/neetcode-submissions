class Solution:
    def isPalindrome(self, s: str) -> bool:
        transformed = s.lower().strip()
        transformed = [c for c in transformed if c.isalnum()]
        return transformed == transformed[::-1]
        