package collectionPrograms;

import java.util.HashMap;
import java.util.Map;


public class SimpleHashMapProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer,String> hashmap =  new HashMap<Integer,String>();
		hashmap.put(1,"Mango");
		hashmap.put(2,"Apple");
		hashmap.put(3,"Pineapple");
		hashmap.put(4,"Orange");
		hashmap.put(1, "Avacado");
		
		for(Map.Entry m:hashmap.entrySet())
{
			System.out.println(m.getValue());
}
		
	}

}
