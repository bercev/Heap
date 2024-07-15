import java.util.*;

public class MinHeap implements Heap {

    public int[] arr;
    public int numberFilled;
    public int size;
    boolean created = true;
    public int sizeCheck = 1;

    public MinHeap(int length) {
        size = length;
        numberFilled = 0;
    }

    @Override
    public void bfsHeap()
    {
        if (created && is_empty()) {
            System.out.println("Heap is empty. Nothing to print!");
            return;
        }

        int sum = 0;
        int power = 0;
        for (int i = 0; i < arr.length; ++i)
        {
            System.out.print(arr[i] + "\t");
            if (sum == i)
            {
                System.out.println();
                sum += (int) (Math.pow(2, ++power));
            }
        }
        System.out.println();
    }

    @Override
    public void insert(int value) {
        if (created && is_empty()) { // checking to see if heap is empty
            arr = new int[sizeCheck];
            sizeCheck++;
            created = false;
            System.out.println("~~~~CREATING HEAP FOR THE FIRST TIME~~~~\n");
        } else if (!created && !is_empty() && sizeCheck <= size) {
            addHeapSpace();
            sizeCheck++;
        }

        addHeapSpace();
        arr[arr.length-1] = value; // inserting element at the end of the tree
        numberFilled++;
        heapify();
    }

    @Override
    public int extract() {
        if (created || is_empty()) {
            throw new Error("~~~~ERROR: Nothing to extract. Heap is " +
                    "empty/not created yet!~~~~");
        }

        int extracted = arr[0];
        arr[0] = arr[arr.length-1];
        numberFilled--;
        removeHeapSpace();
        heapify();
        return extracted;
    }

    @Override
    public int peek() {
        if (created || is_empty()) {
            throw new RuntimeException("~~~~ERROR: Nothing to peek. Heap is empty/not created yet!~~~~");
        }
        return arr[0];
    }

    @Override
    public int size() {
        // size of heap should be the amount that is currently filled, which is numberFilled
        return numberFilled;
    }

    @Override
    public boolean is_empty() {
        return numberFilled == 0;
    }

    public void addHeapSpace() {
        if (arr.length == numberFilled) {
            arr = Arrays.copyOf(arr, arr.length + 1); // adding extra space to the array
        }
    }

    public void removeHeapSpace() {
        if (arr.length > numberFilled) {
            arr = Arrays.copyOf(arr, arr.length-1);
        }
    }

    public void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void heapify() {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            int parent = i;
            while (true)
            {
                int leftChild = 2 * parent + 1;
                int rightChild = 2 * parent + 2;
                int smallest = parent;

                if (leftChild < n && arr[leftChild] < arr[smallest])
                    smallest = leftChild;
                if (rightChild < n && arr[rightChild] < arr[smallest])
                    smallest = rightChild;

                if (smallest != parent)
                {
                    swap(smallest, parent);
                    //bfsHeap(arr);
                    parent = smallest;
                }
                else
                {
                    break;
                }
            }
        }
    }
}
