package collectionPrograms;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleHashSetProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("Apple");
		hashset.add("Orrange");
		
		Iterator itr = hashset.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		HashSet<String> set1 = new HashSet<String>();
		set1.add("Avacado");
		set1.add("Pineapple");
		set1.add("Mango");
		
		hashset.addAll(set1);
		System.out.println("After adding few more");
		for(String hs: hashset)
		{
			System.out.println(hs);
		}
		System.out.println("After removing few");
		
		/*
		 * hashset.remove("Apple"); for(String hs: hashset) { System.out.println(hs); }
		 */
		
		hashset.removeAll(set1);
		for(String hs: hashset)
		{
			System.out.println(hs);
		}
		

	}

}
