/*********************************************************************************************************************
     **
     **  HeapSort using Array 
     **  Both Ascending and descending sorting is implemented
     **  Input in the form of array
     **  Output is printed in listed manner
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/


class HeapSort 
{

	static int []heap;
	static 	int pos;
	static int arr[]={50,45,35,33,16,25,34,12,10};

	//HeapSort class constructor
	public HeapSort()
	{

		heap=new int[arr.length];
		pos=-1;

	}

	//main method
	public static void main(String[] args) 
	{

		// MAX HEAP 
		HeapSort max = new HeapSort();

		for(int i=0;i<arr.length;i++)
			max.maxHeapInsert(arr[i]);
		
		System.out.print("Max Heap : ");
		max.print(heap);

		int[] sortArray=new int[heap.length];

		for(int i=0;i<heap.length;i++)
			sortArray[i]=max.maxDelete();
			
		

		System.out.print("Ascending Sorted Heap : ");
		max.print(sortArray);

		// MIN HEAP 
		HeapSort min = new HeapSort();

		for(int i=0;i<arr.length;i++)
			min.minHeapInsert(arr[i]);

		System.out.print("\nMin Heap : ");
		min.print(heap);
		for(int i=0;i<heap.length;i++)
			sortArray[i]=min.minDelete();

		System.out.print("Descending Sorted Heap : ");
		max.print(sortArray);
		
	}

	//function to delete maximum element form MAX HEAP
	private int maxDelete()
	{
		int data=heap[0];
		heap[0]=heap[pos];

		pos--;
		int parent=0;
		int left=1;
		int right=2;
		int last=pos;

		int larger= heap[left]>heap[right]?heap[left]:heap[right];
		
		while( left<pos && (larger>heap[parent]) )
		{
	
			if(heap[left]==larger)
			{
				swap(left,parent);
				parent=left;
				left=parent*2+1;
				right=parent*2+2;
			}
			else
			{
				swap(right,parent);
				parent=right;
				left=parent*2+1;
				right=parent*2+2;
			}
	
			if(left<pos)
			larger= heap[left]>heap[right]?heap[left]:heap[right];
			if(left==pos)
				larger=heap[left];
	
		}

		return data;
	}

	//function to delete minimum element form MIN HEAP
	private int minDelete()
	{
		int data=heap[0];
		heap[0]=heap[pos];

		pos--;
		int parent=0;
		int left=1;
		int right=2;
		int last=pos;

		int smaller= heap[left]<heap[right]?heap[left]:heap[right];
		
		while( left<pos && (smaller<heap[parent]) )
		{
	
			if(heap[left]==smaller)
			{
				swap(left,parent);
				parent=left;
				left=parent*2+1;
				right=parent*2+2;
			}
			else
			{
				swap(right,parent);
				parent=right;
				left=parent*2+1;
				right=parent*2+2;
			}
	
			if(left<pos)
				smaller= heap[left]<heap[right]?heap[left]:heap[right];
			if(left==pos)
				smaller=heap[left];
	
		}
		return data;
	}

	//function to insert element in MAX HEAP
	private void  maxHeapInsert(int data)
	{

			heap[++pos]=data;
			int child=pos;
			int parent=(child-1)/2;

			while( heap[parent]<heap[child] && parent>=0)
			{

				swap(child,parent);		
				child=parent;
				parent=(child-1)/2;
			}


	}

	//function to insert element in MIN HEAP
	private void  minHeapInsert(int data)
	{

			heap[++pos]=data;
			int child=pos;
			int parent=(child-1)/2;

			while( heap[parent]>heap[child] && parent>=0)
			{

				swap(child,parent);		
				child=parent;
				parent=(child-1)/2;
			}


	}

	//function to print element of heap
	private void  print(int []heap)
	{

		for(int i=0;i<heap.length;i++)
		{
			System.out.print(heap[i]+" ");
		}
		System.out.println();

	}

	//function to swap element
	private void swap(int child,int parent)
	{

		int tmp=heap[child];
		heap[child]=heap[parent];
		heap[parent]=tmp;

	}

}
