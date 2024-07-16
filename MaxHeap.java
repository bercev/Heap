import java.util.*;

public class MaxHeap implements Heap {

    public int[] arr; // the heap
    public int numberFilled; // helps determines how many spaces left in the heap
    public int size; // helps fill the heap in when first created
    boolean created = true; // determines if the heap has been newly created or not
    public int sizeCheck = 0 ; // used to help out with making a new heap for the first time

    // Constructor
    public MaxHeap(int length) {
        size = length;
        numberFilled = 0;
    }
    // prints out the heap
    @Override
    public void bfsHeap()
    {
        if (created && is_empty()) {
            System.out.println("\t\t\t~~~~Heap is empty. Nothing to print!~~~~");
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

    // inserts value into heap
    @Override
    public void insert(int value) {
        if (created && is_empty()) { // checking to see if heap is empty/newly created
            arr = new int[sizeCheck];
            sizeCheck++;
            created = false;
            System.out.println("\t\t\t~~~~CREATING HEAP FOR THE FIRST TIME~~~~");
        } else if (!created && !is_empty() && sizeCheck <= size) { // if the heap is newly created, slowly fill it in
            sizeCheck++;
        }

        addHeapSpace(); // adding space to the array.
        arr[arr.length-1] = value; // inserting element at the end of the tree
        numberFilled++;
        heapify(); // fixing up the heap
    }

    // extracts the root of the heap
    @Override
    public int extract() {
        if (created || is_empty()) { // checks if the heap is empty or newly created
            System.out.println("\t\t\t~~~~ERROR: Nothing to extract. Heap is " +
                    "empty/not created yet. Returning: Integer.MIN_VALUE~~~~");
            return Integer.MIN_VALUE; // returning this in order to stop the function
        } else if (!created && !is_empty() && sizeCheck <= size) { // matches current size to heap size
            sizeCheck--;
        }

        // storing and removing extracted value
        int extracted = arr[0];
        arr[0] = arr[arr.length-1];
        numberFilled--;
        removeHeapSpace();
        heapify();
        return extracted;
    }

    // gets the value of the root
    @Override
    public int peek() {
        if (created || is_empty()) {
            System.out.println("\t\t\t~~~~ERROR: Nothing to peek. Heap is empty/not created yet. " +
                    "Returning: Integer.MIN_VALUE~~~~");
            return Integer.MIN_VALUE;
        }
        return arr[0];
    }

    @Override
    public int size() {
        // size of heap should be the amount that is currently filled, which is numberFilled
        return numberFilled;
    }

    // determines if heap is empty
    @Override
    public boolean is_empty() {
        return numberFilled == 0;
    }

    // adds extra space to the heap array
    public void addHeapSpace() {
        if (arr.length == numberFilled) {
            arr = Arrays.copyOf(arr, arr.length + 1); // adding extra space to the array
        }
    }

    // removes space if there is extraction to keep the heap array consistent
    public void removeHeapSpace() {
        if (arr.length > numberFilled) {
            arr = Arrays.copyOf(arr, arr.length-1);
        }
    }

    // swaps values
    public void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // builds the heap into a Max-Heap after every change
    public void heapify()
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
}

