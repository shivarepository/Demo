package collectionPrograms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Books
{
	String BookId;
	String BookName;
	String Author;
	
	public Books(String BookId,String BookName,String Author)
	{
		this.BookId = BookId;
		this.BookName = BookName;
		this.Author = Author;
	}
}
public class SampleLinkedListProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Books> listemp = new LinkedList<Books>();
		Books b1 = new Books("BId01","Java","McgraHill");
		Books b2 = new Books("BId01","SQL","McgraHill");
		Books b3 = new Books("BId01","RestAPI","McgraHill");
		
		listemp.add(b1);
		listemp.add(b2);
		listemp.add(b3);
		

		for(Books b:listemp)
		{
			System.out.println(b.BookId + " "  +b.BookName +" " +b.Author);
		}
	}

}
