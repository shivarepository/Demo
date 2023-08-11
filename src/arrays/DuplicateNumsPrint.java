package arrays;

public class DuplicateNumsPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr1[] = {10,20,30,20,10,40,50,10};
		int temp[] = new int[arr1.length];
		for(int i=0;i<arr1.length;i++)
		{
			int count=1;
			for(int j=i+1;j<arr1.length;j++)
			{
				if(arr1[i]==arr1[j])
				{
					temp[i]=arr1[j];
				}
				
			}
	}
		for(int i=0;i<temp.length;i++)
		{
			System.out.println(temp[i]);
		}

	}
}
