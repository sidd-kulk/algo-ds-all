package basics.geekforgeeks.heaps;

public class Heaps {
    public static void main(String[] args) {
        new MinHeap(19);
    }
}

class MinHeap {
    private final int[] arr;
    private int size = 0;
    private int capacity;

    MinHeap(int capacity) {
        capacity = 0;
        arr = new int[capacity];
    }

    public void insert(int value) {
        if (size == capacity) return;
        size++;

        int i = size - 1;
        arr[i] = value;
        while (i >= 0) {
            int parent = parent(i);
            if (!(arr[parent] > arr[i])) break;
            var temp = arr[parent];
            arr[parent] = value;
            arr[i] = temp;
            i = parent;
        }
    }

    private int parent(int i) {
        return (int) Math.floor((i - 1) >> 1);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
