



### 排序算法

|      | 时        | 空      | 稳   |
| ---- | --------- | ------- | ---- |
| 选择 | O(N^2)    | O(1)    | N    |
| 冒泡 | O(N^2)    | O(1)    | Y    |
| 插入 | O(N^2)    | O(1)    | Y    |
| 归并 | O(N*logN) | O(N)    | Y    |
| 快排 | O(N*logN) | O(logN) | N    |
| 堆   | O(N*logN) | O(1)    | N    |



#### 选择

```java
//选择
public void selectSort(int[] arr) {

    //每次选出一个最小的元素和前面的元素交换

    for (int i = 0; i < arr.length; i++) {

        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr, i, minIndex);
    }
}
```



#### 冒泡

```java
//冒泡
public void bubbleSort(int[] arr) {

    //每两个相邻的元素比较 每次比较找出最大的元素

    if (arr == null || arr.length == 0 || arr.length == 1) return;

    for (int i = 0; i < arr.length; i++) {

        for (int j = 0; j < arr.length - i - 1; j++) {

            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }
    }
}
```



#### 插入

```java
//插入
public void insertSort(int[] arr) {

    //将前的 n 个元素看成是有序的 将后面的元素插入其中

    if (arr == null) return;
    int len = arr.length;
    if (len == 0 || len == 1) return;

    for (int i = 1; i < len; i++) {

        int index = i;
        while (--index >= 0 && arr[index + 1] < arr[index]) {

            swap(arr, index, index + 1);
        }
    }
}
```



#### 归并

```java
//归并
public void mergeSort(int[] arr, int left, int right) {

    if (left < right) {

        int mid = left + ((right - left) >> 1);

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        process(arr, left, mid, right);
    }
}

private void process(int[] arr, int left, int mid, int right) {

    int[] help = new int[right - left + 1];
    int p0 = 0, p1 = left, p2 = mid + 1;

    while (p1 <= mid && p2 <= right) {

        help[p0++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];

    }

    while (p1 <= mid) {
        help[p0++] = arr[p1++];
    }
    while (p2 <= right) {
        help[p0++] = arr[p2++];
    }


    for (p0 = 0; p0 < help.length; p0++) {
        arr[left + p0] = help[p0];
    }
}
```



#### 快排

```java
public void quick(int[] arr, int left, int right) {

    if (left < right) {

        int random = left + (int) (Math.random() * (right - left + 1));

        swap(arr, random, right);

        int[] p = partition(arr, left, right);

        quickSort(arr, left, p[0] - 1);
        quickSort(arr, p[1] + 1, right);
    }
}

private int[] partition(int[] arr, int left, int right) {

    int L = left - 1;
    int R = right;

    while (left < R) {

        if (arr[left] < arr[right]) {
            swap(arr, ++L, left++);
        } else if (arr[left] > arr[right]) {
            swap(arr, left, --R);
        } else {
            left++;
        }
    }

    swap(arr, right, R);
    return new int[]{L + 1, R};
}
```



#### 堆

```java
public void heap(int[] arr) {

    for (int i = 0; i < arr.length; i++) {
        heapInsert(arr, i);
    }

    int heapSize = arr.length;

    swap(arr, 0, --heapSize);

    while (heapSize > 0) {

        heapify(arr, 0, heapSize);
        swap(arr, 0, --heapSize);

    }
}

private void heapify(int[] arr, int index, int heapSize) {

    int left = index * 2 + 1;

    while (left < heapSize) {

        int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

        largest = arr[largest] > arr[index] ? largest : index;

        if (largest == index) break;

        swap(arr, index, largest);

        left = index * 2 + 1;

    }
}

private void heapInsert(int[] arr, int index) {

    while (arr[index] > arr[(index - 1) / 2]) {
        swap(arr, index, (index - 1) / 2);
        index = (index - 1) / 2;
    }
}

```



















### 链表

```

哈希表缓存
快慢指针

```



#### 回文单链表



































































































































