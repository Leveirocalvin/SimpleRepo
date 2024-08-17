package StreamsAndLambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class streams {

	@Test()
	public void stream() 
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Honad");
		names.add("Poland");
		names.add("Anuad");
		names.add("Balada");
		 
		long c = names.stream().sorted().filter(s->s.startsWith("A")).count();
		System.out.println(c);
	}
	
	@Test
	public void Map()
	{
		Stream.of("Abhi","Dekho","Maharaj","Anji").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));	
		//Assignment
		//print names which have first letter as A with uppercase and sorted
		Stream.of("Abhi","Dekho","Maharaj","Anji").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));	
		
		
		List<String> name = Arrays.asList("Abi","Bala","Cal","Don","Ema","Cia");
		name.stream().filter(s->s.startsWith("C")).sorted().map(s->s.toUpperCase()).limit(1).forEach(z->System.out.println(z));
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Honad");
		names.add("Poland");
		names.add("Anuad");
		names.add("Balada");
		
		//Merging 2 lists and performing stream functions
		Stream<String> newStream = Stream.concat(name.stream(),names.stream());
		newStream.forEach(p->System.out.println(p));
		
		boolean B = newStream.anyMatch(s->s.equalsIgnoreCase("honad"));
		Assert.assertTrue(B);
	}
	
	@Test
	public void streamCollect()
	{
		//converting a stream to a list so list functions can be performed on it
		List<String> ls = Stream.of("Abhi","Maharaj","Anji").filter(s->s.startsWith("A")).collect(Collectors.toList());	
		System.out.println(ls.get(0));
	}
	
	@Test
	public void assigment()
	{
		
		List<Integer> numbers = Arrays.asList(3,2,5,8,6,1,6,9,2,3);
		numbers.stream().distinct().sorted().forEach(z->System.out.println(z));
		
	}
}
