package mark.law.iterators;

import java.util.Iterator;
import mark.law.interfaces.IObjectTest;

public class FilteringIterator<T> implements Iterator<T> {

	private Iterator<T> myIterator;
	private IObjectTest myTest;
	private T next = null;

	public FilteringIterator(Iterator<T> myIterator, IObjectTest myTest) {
		this.myIterator = myIterator;
		this.myTest = myTest;

		if (myIterator.hasNext()) {
			this.next = myIterator.next();
		}
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public T next() {

		while (this.next != null && !myTest.test(this.next)) {
			//shift next
			this.next = myIterator.hasNext() ? myIterator.next() : null;

		}
		//get ready for next, so that hasNext works optimally
		T res = next;
		this.next = myIterator.hasNext() ? myIterator.next() : null;
		if (this.next != null){
			while (this.next != null && !myTest.test(this.next)) {
				//shift next
				this.next = myIterator.hasNext() ? myIterator.next() : null;				
				
			}			
		}
		
		return res;

	}

}
