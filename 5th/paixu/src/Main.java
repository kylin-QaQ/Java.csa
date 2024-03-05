import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户选择排序算法
        System.out.println("请选择排序算法：");
        System.out.println("1. 冒泡排序");
        System.out.println("2. 插入排序");
        System.out.println("3. 快速排序");
        System.out.println("4. 合并排序");
        System.out.println("5. 堆排序");

        // 获取用户输入
        int choice = scanner.nextInt();
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // 测试数组

        switch (choice) {
            case 1:
                System.out.println("您选择了冒泡排序");
                bubbleSort(arr);
                break;
            case 2:
                System.out.println("您选择了插入排序");
                insertSort(arr);
                break;
            case 3:
                System.out.println("您选择了快速排序");
                quickSort(arr, 0, arr.length - 1);
                printArray(arr);
                break;
            case 4:
                System.out.println("您选择了合并排序");
                mergeSort(arr, 0, arr.length - 1);
                printArray(arr);
                break;
            case 5:
                System.out.println("您选择了堆排序");
                heapSort(arr);
                printArray(arr);
                break;
            default:
                System.out.println("无效的选择");
        }
    }

    // 冒泡排序算法
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换 array[j] 和 array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        // 打印排序后的数组
        System.out.print("排序结果：");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 插入排序算法
    public static void insertSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of array[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        // 打印排序后的数组
        System.out.print("排序结果：");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 快速排序算法
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // 合并排序算法
    public static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            merge(array, l, m, r);
        }
    }

    private static void merge(int[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = array[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // 堆排序算法
    public static void heapSort(int[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && array[left] > array[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    // 打印数组
    public static void printArray(int[] array) {
        System.out.print("排序结果：");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}