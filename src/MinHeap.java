import java.util.ArrayList;
import java.lang.*;

public class MinHeap {
    Node root = null;
    ArrayList<Node> heap;
    int tree_level;
    int shifted_index;
    int index;

    //Heap will start with root at index = 1 as opposed to 0
    public MinHeap() {
        heap = new ArrayList<Node>();
        index=1;
    }

    //inserts a new node
    //TODO: I might need 2 helper functions(Find rightmost empty node space, a swapping helper function)
    public void insert(Node root,Node n) {
        if(heap.size()==0){
            //sets the first element in the array to null and allows us to start at index 1
            heap.add(null);
            heap.add(index,n);
        }
        else {
            heap.add(n);
            heapify();
        }

    }

    public void heapify(){
        if (heap.get(1).key > heap.get(heap.size()-1).key) {
            Node temp_node = heap.get(1);
            heap.set(1, heap.get(heap.size()-1));
            heap.set(heap.size()-1,temp_node);
            int index_of_old_min = heap.size()-1;
            while(heap.get(index_of_old_min).key<heap.get(index_of_old_min/2).key) {
                temp_node=heap.get(index_of_old_min/2);
                heap.set(index_of_old_min/2,heap.get(index_of_old_min));
                index_of_old_min=index_of_old_min/2;

            }

        }
    }

    private void swap() {

    }

    public int findMin() {
        return heap.get(1).key;
    }
}
