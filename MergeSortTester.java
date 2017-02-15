//Team HealthyLiving
//Tina Chen, Bryan Chan
//APCS pd5
//HW07-- What Does the Data Say?  
//2017-2-14
/*======================================
  class MergeSortTester

  ALGORITHM:
  <For our merge algorithm, we made a new array with the added length of both arrays and used a for loop to add the smallest number from both arrays each time to the larger array.
  For our sort algorithm, we created two new lists each the size of half of the original array and containing the corresponding elements of the original array. We used merge on the two arrays but used sort on them again.

  if there's an array with length one, return that array. Otherwise, keep dividing the array into halves until you cannot divide anymore.  Merge the elements with each other until you are left with the an array of the same length as the original. Ex. (array of length 4 becomes two arrays with lengths 2.  The two arrays become 4 arrays of length one.  Keep merging the 1 length arrays until you end up with an array of length 4 that is sorted.>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <O(n)>

  Mean execution times for dataset of size n:
  Batch size: 1000 <# of times each dataset size was run>
  n=1       time: 945ns
  n=10      time: 9384ns
  n=100     time: 43626ns
  n=200     time: 66671ns
  n=300     time: 88844ns
  n=400     time: 108958ns
  
  ...
  n=50      time: 21927ns;
  n=500     time: 147616ns
  n=1000    time: 278215ns
  n=1500    time: 395073ns
  n=3000    time: 754101ns

  ANALYSIS:
  <The runtime is linear. We classified the runtime by the number of diversions and merges the data set did. The sum of the two equaled to roughly the same as the number of elements in the list. Also, we thought that since merge is linear, the code couldn't have a runtime of less that linear.>
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * <We sorted an array of random elements and found the elasped time it took for the code to run. >
     ******************************/
    public static void main( String[] args ) 
    {
	int n = 3000; //number of elements
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
