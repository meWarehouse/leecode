

public class Main {


    public void head(int[] arr) {

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

        //子节点大于父节点
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    public void swap(int[] arr, int s, int e) {
        if (s != e) {
            arr[s] = arr[s] ^ arr[e];
            arr[e] = arr[s] ^ arr[e];
            arr[s] = arr[s] ^ arr[e];
        }


    }
}