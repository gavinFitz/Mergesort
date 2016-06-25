
import java.util.*;

public class mergresort
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

		int num = Integer.parseInt(sc.nextLine());

		String [] array = new String[num];

		for(int i = 0; i<num; i++)
		{
			String temp = sc.nextLine();
			StringBuffer reverse = new StringBuffer(temp);
			reverse.reverse();
			array[i] = reverse.toString();
		}

		sort(array);

		for(int i=0; i<num; i++)
		{

			StringBuffer forward = new StringBuffer(array[i]);
			forward.reverse();
			System.out.println(forward.toString());
		}
	}

	static void sort(String[] arr)
	{
	    String[] helper = new String[arr.length];
		mergesort(arr, helper, 0, arr.length-1);
	}

	static void mergesort(String[] arr, String[] helper, int low, int high)
	{
		if(low < high)
		{
	      int middle = (high+low)/2;
	      mergesort(arr, helper, low, middle);
	      mergesort(arr, helper, middle+1, high);
	      merge(arr, helper, low, middle, high);
	    }
	}

	static void merge(String[] arr, String[] helper, int low, int middle, int high)
	{
	    for (int x=low; x <= high; x++)
	    {
	      helper[x] = arr[x];
	    }

	    int left = low;
	    int curr = low;
	    int right = middle+1;

	    while(left <= middle && right <= high)
	    {
	      if(helper[right].compareTo(helper[left])>0)
	        arr[curr++] = helper[left++];
	      else
	        arr[curr++] = helper[right++];
	    }

	    while(left <= middle)
	      arr[curr++] = helper[left++];
	}
}