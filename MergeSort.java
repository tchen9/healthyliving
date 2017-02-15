/*======================================
  Team Healthy Living
  Bryan Chan, Tina Chen
  APCS2 p5
  HW06 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
  2017-02-13

  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  
  if there's an array with length one, return that array. Otherwise, keep dividing the array into halves until you cannot divide anymore.  Merge the elements with each other until you are left with the an array of the same length as the original. Ex. (array of length 4 becomes two arrays with lengths 2.  The two arrays become 4 arrays of length one.  Keep merging the 1 length arrays until you end up with an array of length 4 that is sorted.

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int posA = 0;
	int posB = 0;
	int[] retArr = new int[a.length + b.length];
	for(int i = 0; i < retArr.length; i++){
	    if (posA == a.length){
		retArr[i] = b[posB];
		posB++;
	    }
	    else if(posB == b.length){
		retArr[i] = a[posA];
		posA++;
	    }
	    else if( a[posA] > b[posB] ){
		retArr[i] = b[posB];
		posB++;
	    }
	    else{
		retArr[i] = a[posA];
		posA++;
	    }
	}
	return retArr;

    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	int[] retArr = new int[arr.length];
	if (arr.length == 1){
	    return arr;
	}
	else{
	    int a = arr.length / 2;
	    int b = arr.length - a;

	    int[] arr1 = new int[a];
	    int[] arr2 = new int[b];

	    for( int i = 0; i < arr1.length; i++ ){
		arr1[i] = arr[i];
	    }
	    for( int i = 0; i < arr2.length; i++ ){
		arr2[i] = arr[a];
		a++;
	    }
	    // printArray(arr1);
	    //printArray(arr2);
	    arr1 = sort(arr1);
	    arr2 = sort(arr2);
	    retArr = merge(arr1,arr2);
	    return retArr;
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {
 

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};
	
	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );


	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
		/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	printArray( sort( arr7 ) );
		
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort

