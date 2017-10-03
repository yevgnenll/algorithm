class Solution(object):
    def findClosestElements(self, arr, k, x):
        if len(arr) == 1:
            return arr
        computed = []
        for num in arr:
            computed.append(abs(num-x))
        min_num = 100000000
        result = []
        for i in range(0, len(arr)-k+1):
            abs_list = computed[i:i+k]
            list_sum = sum(abs_list)
            if min_num > list_sum:
                min_num = list_sum
                result = arr[i:i+k]
            elif min_num == list_sum:
                continue
            else:
                break
        return result

