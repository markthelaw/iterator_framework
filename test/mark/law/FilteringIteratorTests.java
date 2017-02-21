package mark.law;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.PrimitiveIterator;

import org.junit.Test;
import mark.law.iterators.FilteringIterator;
import mark.law.interfaces.IObjectTest;
public class FilteringIteratorTests {
	
	@Test
	public void test() {
		
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		PrimitiveIterator.OfInt i1 = Arrays.stream(arr).iterator();
		IObjectTest iot = new IObjectTestCheckIfEven();

		FilteringIterator<Integer> fi = new FilteringIterator<Integer>(i1, iot);

		while (fi.hasNext()) {
			Integer v = fi.next();
			
			assertEquals(v%2, 0);
			
		}
	}

}
