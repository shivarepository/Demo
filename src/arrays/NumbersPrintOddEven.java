package arrays;

public class NumbersPrintOddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,2,3,4,5,6,7};
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]%2!=0) {
				System.out.println("Odd numbers - " +arr[i]);
			}else {
				System.out.println("Even numbers - " +arr[i]);
			}
		}

	}

}
