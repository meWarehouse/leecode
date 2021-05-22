package com.at.jz;

/**
 * @author zero
 * @create 2021-05-16 20:09
 */
public class JZ6 {

    /*
    https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba
        二分查找
        这种二分查找难就难在，arr[mid]跟谁比.
        我们的目的是：当进行一次比较时，一定能够确定答案在mid的某一侧。一次比较为 arr[mid]跟谁比的问题。
        一般的比较原则有：

        如果有目标值target，那么直接让arr[mid] 和 target 比较即可。
        如果没有目标值，一般可以考虑 端点
        这里我们把target 看作是右端点，来进行分析，那就要分析以下三种情况，看是否可以达到上述的目标。

        情况1，arr[mid] > target：4 5 6 1 2 3
        arr[mid] 为 6， target为右端点 3， arr[mid] > target, 说明[first ... mid] 都是 >= target 的，因为原始数组是非递减，所以可以确定答案为 [mid+1...last]区间,所以 first = mid + 1
        情况2，arr[mid] < target:5 6 1 2 3 4
        arr[mid] 为 1， target为右端点 4， arr[mid] < target, 说明答案肯定不在[mid+1...last]，但是arr[mid] 有可能是答案,所以答案在[first, mid]区间，所以last = mid;
        情况3，arr[mid] == target:
        如果是 1 0 1 1 1， arr[mid] = target = 1, 显然答案在左边
        如果是 1 1 1 0 1, arr[mid] = target = 1, 显然答案在右边
        所以这种情况，不能确定答案在左边还是右边，那么就让last = last - 1;慢慢缩少区间，同时也不会错过答案。


     */

    public int minNumberInRotateArray(int [] array) {

        if(array.length == 0) return 0;

        int left = 0;
        int right = array.length-1;

        while (left < right){

            if(array[left] < array[right]) return array[left];

            int mid = (left + right)/2;

            if(array[mid] > array[right]){
                left = mid + 1;
            }else if(array[mid] < array[right]){
                right = mid;
            }else {
                right--;
            }
        }

        return array[left];



    }


}
