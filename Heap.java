import java.util.*;

public class Heap {

    public int capacity = 10;
    private int size = 0;

    int[] arr = new int[capacity];

    public int getLeft(int parent) {
        return 2 * parent + 1;
    }
    public int getRight(int parent) {
        return 2 * parent + 2;
    }
    public int getParent(int child) {
        return (child- 1) / 2;
    }
    public boolean hasLeft(int index) {
        return getLeft(index) < size;
    }
    public boolean hasRight(int index) {
        return getRight(index) < size;
    }
    public boolean hasParent(int index) {
        return getParent(index) >= 0;
    }
    public int left(int index) {
        return arr[getLeft(index)];
    }
    public int right(int index) {
        return arr[getRight(index)];
    }
    public int parent(int index) {
        return arr[getParent(index)];
    }


    public void bfsHeap()
    {

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

    public int size() {
        return size;
    }

    public boolean is_empty() {
        if (size == 0)
            return true;
        return false;
    }

    public void buildMaxHeap()
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            int parent = i;
            while (true)
            {
                int leftChild = 2 * parent + 1;
                int rightChild = 2 * parent + 2;
                int largest = parent;

                if (leftChild < n && arr[leftChild] > arr[largest])
                    largest = leftChild;
                if (rightChild < n && arr[rightChild] > arr[largest])
                    largest = rightChild;

                if (largest != parent)
                {
                    swap(parent, largest);
                    //bfsHeap(arr);
                    parent = largest;
                }
                else
                {
                    break;
                }
            }
        }
    }

    public void buildMinHeap()
    {
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

    public void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void addSpace() {
        if (size == capacity) {
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0)  {
            System.out.println("error, heap has 0 values");
            return -1; // indicating error occured
        }
        return arr[0];
    }

    public int extract() {
        if (size == 0) {
            System.out.println("error, heap has 0 values");
            return -1; // indicating error occured
        }
        int element = arr[0];
        arr[0] =arr[size - 1];
        size--;
        heapifyDown();
        return element;

    }


    public void insert(int ins) {
        addSpace();
        arr[size] = ins;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > arr[index]) {
            swap(getParent(index), index);
            index = getParent(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (hasLeft(index)) {
            int smaller = getLeft(index);
            if (hasRight(index) && right(index) < left(index)) {
                smaller = getRight(index);
            }
            if (arr[index] < arr[smaller]) {
                break;
            } else {
                swap(index, smaller);
            }
            index = smaller;
        }
    }



    public static void main(String[] args) {
        System.out.println("Pre-Heap array:");
        Heap heapOne = new Heap();
        heapOne.insert(42);
        heapOne.insert(68);
        heapOne.insert(35);
        heapOne.insert(1);
        heapOne.insert(70);
        heapOne.insert(25);
        heapOne.insert(79);
        heapOne.insert(59);
        heapOne.insert(63);
        heapOne.insert(65);

        heapOne.bfsHeap();
        System.out.println("Max Heap");
        heapOne.buildMaxHeap();
        heapOne.bfsHeap();
        System.out.println("\n\n");

        System.out.println("Pre-Heap array");
        Heap heapTwo = new Heap();
        heapTwo.bfsHeap();
        System.out.println("Min Heap");
        heapTwo.buildMinHeap();
        heapTwo.bfsHeap();


    }


}
