import java.util.*;

IMPLEMENT TRY CATCH STATEMENTSSSSSSSSSSSSSSSSSSSSSSS
public class Main {
    public static void main(String[] args) {
        System.out.println("Pre-Heap array:");
        Heap heapOne = new MaxHeap(10);
        heapOne.bfsHeap();
        System.out.println("-------------");


        System.out.println("Max-Heap after insertion of 10 elements");
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
        System.out.println("-------------");


        System.out.println("Max-Heap, insert test - inserting 100");
        heapOne.insert(100);
        heapOne.bfsHeap();
        System.out.println("-------------");

        System.out.println("Max-Heap, insert test - inserting 0");
        heapOne.insert(0);
        heapOne.bfsHeap();
        System.out.println("-------------");

        System.out.println("Max-Heap, insert test - inserting 43");
        heapOne.insert(43);
        heapOne.bfsHeap();
        System.out.println("-------------");

        System.out.println("Max-Heap, extract test");
        System.out.println("Extracted value: " + heapOne.extract());
        heapOne.bfsHeap();
        System.out.println("-------------");


        System.out.println("=======================================================");
        System.out.println("=======================================================");
        System.out.println("Pre-Heap array:");
        Heap heapTwo = new MinHeap(10);
        heapTwo.bfsHeap();
        System.out.println("Min-Heap: BFS (level order)");
        heapTwo.bfsHeap();
        }
}