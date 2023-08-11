package collectionPrograms;

import java.util.Map;
import java.util.TreeMap;

public class SimpleTreeMapProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeMap<Integer,String> tMap = new TreeMap<Integer,String>();
		tMap.put(1, "Rahul");
		tMap.put(2, "Abhishek");
		tMap.put(3, "Sagar");
		tMap.put(4, "Shiva");
		
		for(Map.Entry m:tMap.entrySet())
		{
			System.out.println(m.getKey() +" "+  m.getValue());
		}
		
		tMap.remove(3);
		
		for(Map.Entry m:tMap.entrySet())
		{
			System.out.println(m.getKey() +" "+  m.getValue());
		}		
	}
}
