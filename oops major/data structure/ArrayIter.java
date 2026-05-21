import java.util.Iterator;
import java.util.NoSuchElementException;
class Array implements Iterable<Integer>
{
    int [] arr;
    public Array(int [] a)
    {
	this.arr = a;
    }
    @Override public Iterator<Integer> iterator()
    {
	return new ArrayIterator(this.arr);
    }

}

class ArrayIterator implements Iterator<Integer>
{
    private int currind;
    private int [] arr;
    public ArrayIterator(int [] a)
    {
	this.currind = 0;
	this.arr = a;
    }
@Override public boolean hasNext() {
        if(this.currind < arr.length)
	    return true;
	return false;
    }

    @Override public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int data = this.arr[currind];
        currind++;
        return data;
    }
    
}

public class ArrayIter
{
    public static void main(String arg[])
    {
	int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	Array arrObj = new Array(a);
	Iterator<Integer> it = arrObj.iterator();
        while (it.hasNext())
        {
                Integer s = it.next();
                System.out.println(s);
        }
    }
}
