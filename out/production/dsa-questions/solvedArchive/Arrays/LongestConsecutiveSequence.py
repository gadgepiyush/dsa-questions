# leetcode 128

def longestConsecutive(nums) -> int:
    hset = set(nums)
    count = 0

    for i in nums:
        if i-1 not in hset:
            temp = 0
            j = i
            while j in hset:
                temp += 1
                j+=1

            count = max(temp, count)

    return count


print(longestConsecutive([100,4,200,1,3,2]))