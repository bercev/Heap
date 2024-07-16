public class Main {
    // testing for normal heaps
    public static void testHeap(String type) {
        Heap heapOne;
        if (type.equals("Max-Heap")) {
            heapOne = new MaxHeap(10);
        } else if (type.equals("Min-Heap")) {
            heapOne = new MinHeap(10);
        } else if (type.equals("Empty Max-Heap") || type.equals("Empty Min-Heap")) {
            testEmptyHeap(type);
            return;
        } else {
            System.out.println("Error, invalid heap type");
            return;
        }

        System.out.println("\n\n\t\t=======================================================");
        System.out.println("\t\t\t\t\t\t" + type + " testing");
        System.out.println("\t\t=======================================================");
        System.out.println("Pre-Heap array:");
        heapOne.bfsHeap();
        System.out.println("-------------");


        System.out.println(type + " after insertion of 10 elements");
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


        System.out.println(type + ", Insert Test - inserting 100");
        heapOne.insert(100);
        heapOne.bfsHeap();
        System.out.println("-------------");

        System.out.println(type + ", Insert Test - inserting 0");
        heapOne.insert(0);
        heapOne.bfsHeap();
        System.out.println("-------------");

        System.out.println(type + ", Insert Test - inserting 43");
        heapOne.insert(43);
        heapOne.bfsHeap();
        System.out.println("-------------");

        System.out.println(type + ", Extract test");
        System.out.println("Extracted value: " + heapOne.extract());
        heapOne.bfsHeap();
        System.out.println("-------------");

        System.out.println(type + ", Peek test");
        System.out.println("Peeked value: " + heapOne.peek());
        System.out.println("-------------");

        System.out.println(type + ", Size Test");
        System.out.println("Size: " + heapOne.size());
        System.out.println("-------------");

        System.out.println(type + ", is_empty Test");
        System.out.println("Is it empty?: " + heapOne.is_empty());
        System.out.println("-------------");
    }

    // testing for empty heap
    public static void testEmptyHeap(String type) {
        Heap heapTwo;
        if (type.equals("Empty Max-Heap")) {
            heapTwo = new MaxHeap(10);
        } else if (type.equals("Empty Min-Heap")) {
            heapTwo = new MinHeap(10);
        } else {
            System.out.println("Error, invalid heap type");
            return;
        }

        System.out.println("\n\n\t\t=======================================================");
        System.out.println("\t\t\t\t\t\t" + type + " Testing");
        System.out.println("\t\t=======================================================");
        System.out.println("Pre-Heap array:");
        heapTwo.bfsHeap();
        System.out.println("-------------");

        System.out.println(type + ", Insert and then Extract test");
        heapTwo.insert(13);
        System.out.println("Inserted 13, now extracting 13");
        heapTwo.bfsHeap();
        heapTwo.extract();
        System.out.println("13 Extracted");
        heapTwo.bfsHeap();
        System.out.println("-------------");


        System.out.println(type + ", Extract Test");
        System.out.println("Extracted value: " + heapTwo.extract());
        heapTwo.bfsHeap();
        System.out.println("-------------");

        System.out.println(type + ", Peek Test");
        System.out.println("Peeked value: " + heapTwo.peek());
        System.out.println("-------------");

        System.out.println(type + ", Size Test");
        System.out.println("Size: " + heapTwo.size());
        System.out.println("-------------");

        System.out.println(type + ", is_empty Test");
        System.out.println("Is it empty?: " + heapTwo.is_empty());
        System.out.println("-------------");
    }

    // main
    public static void main(String[] args) {
        testHeap("Max-Heap");
        testEmptyHeap("Empty Max-Heap");
        testHeap("Min-Heap");
        testEmptyHeap("Empty Min-Heap");
    }

}