package gengsc.algo.heap;

import gengsc.algo.util.PrintableMaxHeap;
import gengsc.algo.util.SortTestHelper;

import java.util.Random;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-29 23:14
 */
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    public MaxHeap(int capacity) {
        this.data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void insert(Item item) {
        if (count + 1 > data.length) {
            throw new RuntimeException("超出容量");
        }
        data[++count] = item;
        shiftUp(count);
    }

    private void shiftUp(int k) {
        Item item = data[k];
        while (k > 1 && data[k / 2].compareTo(item) < 0) {
            //SortTestHelper.swapArray(data, k/2, k);
            data[k] = data[k / 2];
            k /= 2;
        }
        data[k] = item;
    }

    public Item extractMax() {
        if (count <= 0) {
            throw new RuntimeException("没有元素了");
        }
        Item item = data[1];
        SortTestHelper.swapArray(data, 1, count--);
        shiftDown(1);
        return item;
    }

    private void shiftDown(int k) {
        Item item = data[k];
        //只要有左孩子就循环
        while (2 * k <= count) {
            int j = 2 * k;//左孩子
            if (j + 1 <= count && data[j].compareTo(data[j + 1]) < 0) {
                j++;
            }
            if (item.compareTo(data[j]) > 0) break;
            data[k] = data[j];
            k = j;
        }
        data[k] = item;

    }

    public static void main(String[] args) {
        PrintableMaxHeap heap = new PrintableMaxHeap(100);
        System.out.println(heap.size());

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            heap.insert(random.nextInt(100));
        }

        heap.treePrint();

        while (!heap.isEmpty()) {
            System.out.print(heap.extractMax()+" ");
        }


    }
}
