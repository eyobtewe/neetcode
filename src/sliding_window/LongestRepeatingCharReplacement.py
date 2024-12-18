# class LongestRepeatingCharReplacement:
#
#   def characterReplacement(s: str, k: int) -> int:
#     # Frequency array for 26 uppercase English letters
#     count = [0] * 26
#     max_freq = 0
#     res = 0
#     left = 0
#
#     for right in range(len(s)):
#         # Increment the count for the current character
#         count[ord(s[right]) - ord('A')] += 1
#         max_freq = max(max_freq, count[ord(s[right]) - ord('A')])
#
#         # Shrink the window if it exceeds the allowable replacements
#         while (right - left + 1) - max_freq > k:
#             count[ord(s[left]) - ord('A')] -= 1
#             left += 1
#
#         # Update the result with the current window size
#         res = max(res, right - left + 1)
#     print(res)
#     return res
#
#   characterReplacement("ABABABBB",3)
#
#
#
