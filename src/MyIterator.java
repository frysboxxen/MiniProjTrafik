import java.util.Iterator;

public class MyIterator<AnyType> implements Iterator<AnyType> {
	private int curr;
	private AnyType[] a;
	public MyIterator(AnyType[] b){
		a =  b;
		curr=0;
	}
	public boolean hasNext() {
		if(curr<a.length){
			return true;
		}else{
			return false;
		}
	}

	public AnyType next() {
		if(curr<a.length){
			return a[curr++];
		}
		else
			return null;
	}

}
