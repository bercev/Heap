import java.util.*;

public interface Heap {

    // abstract methods
    void bfsHeap();
    void insert(int value);
    int extract();
    int peek();
    int size();
    boolean is_empty();

}

