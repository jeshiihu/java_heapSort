public class HeapSort {
//	static int[] data = {6,7,2,1,5,3,4};
	static int[] data = {11,5,4,13,17,21,30};
	
	public static void heapify(int[] a, int len) {
		int start = (len-2)/2; //starting the binary heap
		while (start >= 0) {
			siftDown(a, start, len-1);
			start-=1;
		}
	}
	
	public static void siftDown(int[] a, int start, int end) {
		int root = start;
		while ((root*2+1) <= end) {
			int child = root*2+1;
			if (child+1 <= end && a[child] < a[child+1]) {
				child = child+1;
			}
			if (a[root] < a[child]) { // if child is larger than its parent
				int rootTemp = a[root];
				a[root] = a[child];
				a[child] = rootTemp;
				root = child;
			}else
				return;
		}
	}
	
	public static void heapSort(int[] a, int len) {

		heapify(a,len);
		int end = len - 1;
		while (end>0) { 
			// swap end with start
			int temp = a[end];
			a[end] = a[0];
			a[0] = temp;
			end-=1;
			siftDown(a,0,end);
		}
	}
	
	public static void main(String[] args) {
		System.out.print("Before heapSort: ");
		
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");	
		}
		System.out.println("");
		heapSort(data, data.length);
		
		System.out.print("After heapSort: ");
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");	
		}
	}
}
