def checkSubset(arr1, arr2):

    hset = set(arr1)

    for i in arr2:
        if i not in hset:
            hset.remove(i)
        else:
            return "No"

    return "Yes"


print(checkSubset([1, 2, 3, 4, 5, 6, 7, 8], [1,2,3,1]))

