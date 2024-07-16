import java.util.*;

// using interface to make building a certain type of heap more efficient
public interface Heap {

    // abstract methods
    void bfsHeap();
    void insert(int value);
    int extract();
    int peek();
    int size();
    boolean is_empty();

}

