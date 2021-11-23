import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<String> list1 = new ArrayList<String>();
		list1.add("karthicsankar_s");
		list1.add("nageswari_r");
		System.out.println(list1);
		int count=0;
		for(String name : list1) 
		{
			if(name.startsWith("k")) 
			{
				count++;
				
			}
			
			
		}
		System.out.println(count);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("karthicsankar_s");
		list2.add("nageswari_r");
		list2.add("karnan");
		list2.add("vidhya");
		list2.add("sandya");
		
		long c = list2.stream().filter(s->s.startsWith("k")).count();
		//list2.stream().forEach(s->System.out.println(s));
		list2.stream().filter(s->s.startsWith("k")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//list2.stream().filter(s->s.length()>=8).forEach(s->System.out.println(s));
		System.out.println(c);
		
		//Stream.of("","");
		Stream<String> value= Stream.concat(list1.stream(), list2.stream());
		System.out.println(value.anyMatch(s->s.equals("vidhya")));

	}

}
