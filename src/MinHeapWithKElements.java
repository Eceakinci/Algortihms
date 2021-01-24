/**Date: 04/01/2021
 * @author:EceAkinci
 * Algorithms: Hw Two Questions
 *              Question2
 * */

//Build min-heap with k number of elements
//then heapify it and remove root, put it in the result array
//after that, add k+1'th number from array to minheap and heapify it
//Do this process until there is no element left in the heap
import java.util.Arrays;

 class MinHeapWithKElements {
    private static int[] kSort(int[] arr, int n, int k){
        Minheap minHeap = new Minheap(k);

        int resultArr [] = new int[n];

        //add first k+1 elements from arr to heap
        for(int i = 0;i< k+1;i++){
            minHeap.insert(arr[i]);
        }

        //the index variable is for control the resultArr's indexes
        int index = 0;
        int j = k;
        while(index != n ){
            //remove element(root element which is current min value) from heap
            //and put that element to resultArr array
            resultArr[index] = minHeap.remove();
            index++;

            //insert remaining elements from arr to heap until all of them are inserted into the heap
            if(j+1 <= n) {
                minHeap.insert(arr[j]);
                j++;
            }

        }
        return resultArr;

    }
    public static void main(String[] args){

        int arr[] = {10, 9, 8, 7, 4, 70, 60, 50};
        int k = 4;
        int n = arr.length;
        System.out.println("Following is sorted array");
        System.out.println(Arrays.toString(kSort(arr, n, k+1)));
    }
}

 class Minheap{
    private int[] Heap;
    private int size;
    private int maxsize;

    public Minheap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];

    }
    private int parent(int position){ return (int) Math.floor((position-1) / 2);}
    private int leftChild(int position){ return (2*position) + 1;}
    private int rightChild(int position){ return (2*position) + 2;}


    private boolean isLeaf(int position){
        if(position >= (size / 2) && size >= position){return true;}
        return false;
    }
    private void swap(int firstElement, int secondElemenet){
        int temp;
        temp = Heap[firstElement];
        Heap[firstElement] = Heap[secondElemenet];
        Heap[secondElemenet] = temp;
    }

    private void minHeapify(int position){
        //if an element is not a leaf element, then
        if(!isLeaf(position)){
            //if an element is greater than it's child
            if(Heap[position] > Heap[leftChild(position)]
            || Heap[position] > Heap[rightChild(position)]) {
                //then compare it's child and swap parent with minimum
                if (Heap[rightChild(position)] > Heap[leftChild(position)]) {
                    swap(position, leftChild(position));
                    //if leftChild is smaller, we swap left child with parent
                    //and then we should check the left side of the tree and heapify that side too
                    minHeapify(leftChild(position));
                } else {
                    //if rightChild is smaller, we swap right child with parent
                    //and then we should check the right side of the tree and heapify that side too
                    swap(position, rightChild(position));
                    minHeapify(rightChild(position));
                }
            }
        }
    }

    public void insert(int element){
        if(size >= maxsize){
            return;
        }
        else{
            //insert element to last position
            Heap[size] = element;
            int current = size;
            //if the parent of the inserted element greater, then swap them
            while(Heap[parent(current)] > Heap[current]){
                swap(current, parent(current));
                current = parent(current);
            }
            size++;
        }
    }

    public int remove(){
        //remove element fom root
        int popped = Heap[0];
        //put the rightmost element of the tree to the root and decrease the size of the heap
        Heap[0] = Heap[--size];
        //heapify the heap with remaining elements
        minHeapify(0);
        return popped;
    }
}

