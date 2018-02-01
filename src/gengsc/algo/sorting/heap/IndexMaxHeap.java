package gengsc.algo.sorting.heap;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-01 22:01
 */
public class IndexMaxHeap<Item extends Comparable> {

    private Item[] data;
    private int[] indexs;
    private int[] reverse;
    private int count;
    private int capacity;

    public IndexMaxHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity];
        this.indexs = new int[capacity];
        this.reverse = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            this.reverse[i] = -1;
        }
        this.count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    // 交换索引堆中的索引i和j
    private void swapIndexes(int i, int j){
        int t = indexs[i];
        indexs[i] = indexs[j];
        indexs[j] = t;
    }

    public void insert(int i, Item item) {
        assert i <= capacity - 1 && i >= 0;
        assert count + 1 <= capacity;
        data[i] = item;
        indexs[count] = i;
        reverse[i] = count;
        count++;
        shiftUp(count);
    }

    private void shiftUp(int k) {
        int index = indexs[k];
        Comparable item = data[index];
        while ((k - 1) / 2 > 0) {
            if (item.compareTo(data[indexs[(k - 1) / 2]]) > 0) {
                indexs[k] = indexs[(k - 1) / 2];
                reverse[indexs[(k - 1) / 2]] = k;
            } else {
                break;
            }

            k = (k - 1) / 2;
        }

        indexs[k] = index;
        reverse[index] = k;
    }

    public Item extractMax() {
        assert count - 1 >= 0;
        Item item = data[indexs[0]];
        swapIndexes(0, count - 1);
        reverse[indexs[0]] = 0;
        reverse[indexs[count - 1]] = -1;
        count--;
        shiftDown(0);

        return item;
    }

    public int extractMaxIndex() {
        assert count - 1 >= 0;
        int index = indexs[0];
        swapIndexes(0, count);
        reverse[indexs[0]] = 0;
        reverse[indexs[count - 1]] = -1;
        count--;
        shiftDown(0);

        return index;
    }

    private void shiftDown(int k) {
        int index = indexs[k];
        Comparable item = data[index];
        while (2 * k + 1 <= count - 1) {
            int j = 2 * k + 1;
            if (j + 1 <= count - 1 && data[indexs[j + 1]].compareTo(data[indexs[j]]) > 0) {
                j += 1;
            }
            if (item.compareTo(data[j]) > 0) {
                break;
            }
            indexs[k] = indexs[j];
            reverse[indexs[j]] = k;
            k = j;
        }
        indexs[k] = index;
        reverse[index] = k;
    }

    public Item getItem(int index) {
        return data[index];
    }

    public void change(int i, Item newItem) {
        data[i] = newItem;
        //找到堆中的索引 shiftDown shiftUp
    }
}
