import java.util.ArrayList;
import java.util.Iterator;

// ArrayQueue class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void enqueue( x )      --> Insert x
// AnyType getFront( )    --> Return least recently inserted item
// AnyType dequeue( )     --> Return and remove least recent item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// getFront or dequeue on empty queue

/**
 * Array-based implementation of the queue.
 
*/
public class ArrayQueue <AnyType> implements Iterable<AnyType>
{
    private AnyType [ ] theArray;
    private int         currentSize;
    private int         front;
    private int         back;

    private static final int DEFAULT_CAPACITY = 10;

	 
	 
	 /**
     * Construct the queue.
     */
    public ArrayQueue( )
    {
        theArray = (AnyType []) new Object[ DEFAULT_CAPACITY ];
        makeEmpty( );
    }

    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }

    /**
     * Make the queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
        front = 0;
        back = -1;
    }


    /**
     * Insert a new item into the queue.
     * @param x the item to insert.
     */
    public void enqueue( AnyType x )
    {
        if( currentSize == theArray.length )
            doubleQueue( );
        back = increment( back );
        theArray[ back ] = x;
        currentSize++;
    }


  
    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @throws UnderflowException if the queue is empty.
     */
    public AnyType dequeue( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( "No elements to dequeue." );
        currentSize--;

        AnyType returnValue = theArray[ front ];
        front = increment( front );
        return returnValue;
    }
    
    /**
     * Get the least recently inserted item in the queue.
     * Does not alter the queue.
     * @return the least recently inserted item in the queue.
     * @throws UnderflowException if the queue is empty.
     */
    public AnyType getFront( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( "ArrayQueue getFront" );
        return theArray[ front ];
    }

        /**
     * Internal method to increment with wraparound.
     * @param x any index in theArray's range.
     * @return x+1, or 0 if x is at the end of theArray.
     */
    public ArrayList findEmergency(){
    	ArrayList temp= new ArrayList();
    	for(int i = 0; i<theArray.length; i++){
    		if(((Car)theArray[i]).isEmergency()){
    			temp.add(i);
    		}
    	}
    	return temp;
    }
    private int increment( int x )
    {
        if( ++x == theArray.length )
            x = 0;
        return x;
    }
    
    /**
     * Internal method to expand theArray.
     */
    private void doubleQueue( )
    {
        AnyType [ ] newArray;

        newArray = (AnyType []) new Object[ theArray.length * 2 ];

            // Copy elements that are logically in the queue
        for( int i = 0; i < currentSize; i++, front = increment( front ) )
            newArray[ i ] = theArray[ front ];

        theArray = newArray;
        front = 0;
        back = currentSize - 1;
    }
    
    public void printQueue(){
    	if(!this.isEmpty()){
    		//Den söker till arrayen's slut och sedan börjar om på 0, då queuen
    		//kan börja om på 0.
    			for(int i = front; i<front+currentSize; i++){
    				System.out.println(theArray[i%theArray.length]);
    			}
    	}
    }
    
    public void reverseQueue(){
    	if(!this.isEmpty()){
    		//Samma som printQueue, med undantaget att den börjar på back + arrayen's längd, vilket spelar ingen
    		//Roll då vi även tar modulus av arrayen's längd.
    		//Detta då back kan vara 2 medans front kan vara 7 t.ex.
    		int coll = back+theArray.length;
    		for(int i = coll ; coll-currentSize < i; i--){
    			System.out.print(theArray[i%theArray.length]+" ");
    		}
    	}
    }

    

public static void main (String [] arg)
	{
	   ArrayQueue <String> q =new ArrayQueue<String>();
		
		try{
		
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		q.enqueue("1");
		q.dequeue();
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");
		q.enqueue("5");
		q.enqueue("6");
		q.enqueue("7");
		q.enqueue("8");
		q.enqueue("9");
		q.enqueue("10");
		q.enqueue("11");
		q.printQueue();
		q.reverseQueue();
			Iterator get = q.iterator();
			while(get.hasNext()){
				System.out.println(get.next());
			}
		}
		catch( UnderflowException e)
		{
		  System.out.println(e);
		  System.out.println("Kö empty");
		  
		}
	
	}

public Iterator<AnyType> iterator() {
	// TODO Auto-generated method stub
	AnyType[] temp = (AnyType[]) new Object[currentSize];
	for(int i=0; i<currentSize; i++){
		temp[i] = theArray[(front+i)%theArray.length];
	}
	return new MyIterator(temp);
}

  }  	 