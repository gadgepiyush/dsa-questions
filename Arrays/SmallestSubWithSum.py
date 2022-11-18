# leetcode 209

#using sliding window
def smallestSubWithSum(arr, target):

    length = 1000000
    window_sum, window_length = 0, 0
    
    i, j = 0, 0

    while j<len(arr):
        if window_sum >= target:
            length = min(length, window_length)
            window_sum -= arr[i]
            i += 1
            window_length -= 1
        else:
            window_sum += arr[j]
            j += 1
            window_length += 1

    if j==len(arr) and i==0 and window_sum<target:
        return 0


    while i<len(arr):
        if window_sum-arr[i]>target:
            window_sum -= arr[i]
            i += 1
            window_length -= 1
        elif window_sum-arr[i]==target:
            window_length -= 1
            break
        else:
            break


    length =  min(length, window_length)

    return length



print(smallestSubWithSum([12,28,83,4,25,26,25,2,25,25,25,12], 213))

print(smallestSubWithSum([2,3,1,2,4,3], 7))


