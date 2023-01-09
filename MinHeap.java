package priorityqueue;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	/* The actual heap of data */
	public ArrayList<T> heap;
	public int heap_size;
	
	public MinHeap() {
		/* TODO: IMPLEMENT THIS METHOD */
		this.heap = new ArrayList<T>();
		T dummy = (T)(Object)(-1);
		this.heap.add(dummy);
		this.heap_size=0;
	}
	
	public MinHeap(ArrayList<T> data) {
		/* TODO: IMPLEMENT THIS METHOD */
		this.heap_size = data.size();
		data.add(0, (T)(Object)(-1));
		this.heap = data;
		
		heapify();
	}
	
	private void heapify() {
		/* TODO: IMPLEMENT THIS METHOD */
		for (int i = this.heap_size; i>0; i--) {
			percolateDown(i);
		}	
	}
	
	private void percolateUp(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(index <= 1) return;
	    int pIndex = Math.floorDiv(index, 2);

	    if(heap.get(index).compareTo(heap.get(pIndex))<0) {
	      swap(index, pIndex);
	      percolateUp(pIndex);
	    }
	}
	
	private void percolateDown(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
		if (index >= heap_size - Math.floorDiv(heap_size, 2)) return;
		int cIndex1 = index*2;
		int cIndex2 = cIndex1+1;
		if (heap.get(cIndex1)==null) {
			if (heap.get(index).compareTo(heap.get(cIndex2)) > 0) {
				swap(index, cIndex2);
				percolateDown(cIndex2);
			}
		}
		
		if (heap.get(cIndex2)==null) {
			if (heap.get(index).compareTo(heap.get(cIndex1)) > 0) {
				swap(index, cIndex1);
				percolateDown(cIndex1);
			}	
		}

		if ((heap.get(index).compareTo(heap.get(cIndex1)) > 0)||(heap.get(index).compareTo(heap.get(cIndex2)) > 0)){
			if ((heap.get(cIndex2).compareTo(heap.get(cIndex1)) < 0)) { 
				swap(index, cIndex2);
				percolateDown(cIndex2);
			}
			else {
				swap(index, cIndex1);
				percolateDown(cIndex1);
			}
		}
	}
	
	@Override
	public void push(T data) {
		/* TODO: IMPLEMENT THIS METHOD */
		heap.add(data);
		heap_size++;
		percolateUp(heap_size);
		
	}

	@Override
	public T poll() {
		/* TODO: IMPLEMENT THIS METHOD */
		 if ( heap_size == 0 )
		        return null;
	    swap(1, heap_size);
	    T temp = heap.get(heap_size);
	    heap.remove(heap_size);
	    heap_size--;
	    percolateDown(1);
	    return temp;
	}

	@Override
	public T peek() {
		/* TODO: IMPLEMENT THIS METHOD */
		if ( heap_size == 0 )
	        return null;
		return heap.get(1);
	}
	
	@Override
	public int size() {
		/* TODO: IMPLEMENT THIS METHOD */
		return heap_size;
	}
	
	private void swap(int i, int j) {
		/*OPTIONAL TODO: IMPLEMENT THIS METHOD*/
		T temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	
}
