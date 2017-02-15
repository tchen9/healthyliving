/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: 1000 <# of times each dataset size was run>
  n=1       time: 549ns
  n=10      time: 2,619ns
  n=100     time: 18,454ns
  
  ...
  n=50      time: 8,336ns;
  n=500     time: 84,077ns
  n=1000    time: 156,362ns
  n= 100,000<huge>  time: 802,704ns

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) 
    {
	int n = 500; //number of elements
	int batchsize = 1000; //number of times method is ran
	int sumofTime = 0;

	for (int i = 0; i < batchsize; i++){
	    
	    int[] arr = new int[n];
	    for(int j = 0; j < n; j++){
		arr[j] = (int)(Math.random() * n);
	    }//populates array arr with n elements
       
	    long start = System.nanoTime();
	    MergeSort.sort(arr);
	    long elasped = System.nanoTime() - start;
	
	    System.out.println("Elaspsed time: " + elasped);	    
	    sumofTime += elasped;

	}
	
	long average = sumofTime / batchsize;
	System.out.println("Average time: " + average);
       			  
    }//end main

}//end class
