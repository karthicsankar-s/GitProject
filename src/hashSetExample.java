import java.util.HashSet;
import java.util.Iterator;

public class hashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> a = new HashSet<String>();
		a.add("USA");
		a.add("India");
		a.add("Singapore");
		a.add("Malaysia");
		System.out.println(a);
		Iterator<String> it= a.iterator();
		while(it.hasNext()) 
		{
			System.out.println(it.next());
		}

	}

}
