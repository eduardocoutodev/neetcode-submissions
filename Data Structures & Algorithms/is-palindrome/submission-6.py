class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = "".join([c for c in s if c.isalnum()]).lower().strip()
        return s == s[::-1]
        