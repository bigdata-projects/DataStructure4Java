package sort;

/**
 * Created by Administrator on 2017/7/26.
 */
public class SimpleSortUtils {

    /**
     * 冒泡排序
     * 核心思想：就是相邻的两个数比较，小的排前面，大的排后面
     */
    public static void bubbleSort(long[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[j - 1] > arr[j]) {
                    long buf = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j] = buf;
                }
            }
        }
    }

    /**
     * 选择排序，从大到小排列
     * 核心思想：把第一个元素当作最大的，依次与其后面的元素比较，如果有比其大的，与最小的元素替换
     */
    public static void selectSortDesc(long[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j - 1] < arr[j]) {
                    maxIndex = j;
                }
            }
            long buf = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = buf;
        }
    }

    /**
     * 3、选择排序，按小到大排列
     * 核心思想：把第一个元素当作最小的，依次与其后面的元素比较，如果有比其小的，就赋值给他
     * 最后在外循环进行数据替换
     */
    public static void selectSortAsc(long[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            long buf = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = buf;
        }

    }

    /**
     * 插入排序
     * <p>
     * 思想:插入排序法的排序思想就是从数组的第二个元素开始,将数组中的每一个元素按照规则插入到已排好序的数组中以达到排序的目的.
     * 一般情况下将数组的第一个元素作为启始元素,从第二个元素开始依次插入.由于要插入到的数组是已经排好序的,
     * 所以只是要从右向左找到比插入点(下面程序中的select)小(对升序而言)的第一个数组元素就插入到其后面.
     * 直到将最后一个数组元素插入到数组中,整个排序过程就算完成.
     */
    public static void insertSort(long[] arr) {
        int size = arr.length;
        boolean flag = false;
        for (int i = 1; i < size; i++) {
            long tmp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
                arr[j] = arr[j - 1];
                flag = true;
            }
            arr[j] = tmp;
/*            if (flag){
                arr[j] = tmp;
            }*/

        }
    }


    public static void quickSort(long[] arr) {

    }

    public static void main(String[] args) {
        long[] array = {3, 2, 1, 43, 22, 14, 12};
        //long[] array = {1,2,3,4,5,6};
        //insertSort(array);
        //bubbleSort(array);
        selectSortDesc(array);
        for (long ele : array) {
            System.out.println(ele);
        }
    }
}
