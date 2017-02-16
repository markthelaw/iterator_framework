package mark.law;

import mark.law.interfaces.IObjectTest;

public class IObjectTestCheckIfEven implements IObjectTest{

	@Override
	public boolean test(Object o) {
		if ((Integer) o %2 == 0){
			return true;
		}
		return false;
			
	}

}
