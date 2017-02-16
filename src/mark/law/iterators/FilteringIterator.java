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
			next = myIterator.next();
		}
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public T next() {

		Object peek = this.peek();


		while (peek != null && !myTest.test(peek)) {
			//shift next
			next = myIterator.hasNext() ? myIterator.next() : null;

			peek = this.peek();

		}
		T res = next;
		next = myIterator.hasNext() ? myIterator.next() : null;
		return res;

	}

	// use the peek to check if the value passes the myTest.test.
	public Object peek() {
		return next;
	}
}
