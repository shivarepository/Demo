package arrays;

public class LargeNumInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {10,20,15,12,25,75,60,17};
		
		int max = arr[0];
		int min = arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				max=arr[i];
			}
		}
			System.out.println(max);
			
		for(int i=0;i<arr.length;i++)
		{
			if(min>arr[i])
			{
				min=arr[i];
			}
		}
		System.out.println(min);
		
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum=sum+arr[i];
		}
		System.out.println("Sum: " +sum);
		}
	}
