package Lab4;
import java.util.Arrays;

public class AList<T> implements ListInterface <T>   {
    private T[] list;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;
    private boolean initialized = false;
    
    public AList( int capacity) {
        if (capacity < DEFAULT_CAPACITY)
            capacity = DEFAULT_CAPACITY;
        else
            checkCapacity (capacity);
        T[] temp = (T[]) new Object[capacity];
        list = temp;
        numberOfEntries = 0;
        initialized = true;
    }
    
    private void checkCapacity(int num) {
    	if(num > list.length) {
    	//
    	}
    }
    
    public AList () {
        this(DEFAULT_CAPACITY);
    }
    
    @Override
    public void add (T anEntry) {
      checkInitialization();
      list[numberOfEntries]  = anEntry;
      numberOfEntries ++;
      ensureCapacity();
    }
    
    @Override
    public T[] toArray() {
        checkInitialization();
        T[] result = (T[]) new Object[numberOfEntries];
        for (int idx = 0; idx < numberOfEntries; idx ++)
            result[idx] = list[idx];
        return result;
    }

    private void ensureCapacity(){
        int capacity = list.length - 1; // last index
        if (numberOfEntries >= capacity) {
            capacity *= 2;
            checkCapacity (capacity); // too big ?
            list = Arrays.copyOf(list, capacity + 1);       
        }
    }

    private void makeRoom (int newPosition){
        assert (newPosition >= 0 && newPosition <= numberOfEntries);
        for (int index = numberOfEntries; index > newPosition; index --)
            list[index] = list[index-1];
    }

	
    public void add (T newEntry) {
    	
    }

    public void add (int newPosition, T newEntry) {
    	
    }
    
    public T remove (int givenPosition) {
    	return null;
    }

    /**
     * Removes the specified entry from the list
     * @param anEntry
     * @return true if the entry was in the list; false otrherwise
     */
    public boolean remove ( T anEntry);

    
    /**
    /* Removes all entries from the list
   */
    public void clear();
    






    /**
     * Replaces an entry at given position with a new one
     * @param givenPosition
     * @param newEntry
     * @return the replaced entry
     * @throws IndexOutOfBoundsException if either givenPosition < 0 or
     * givenPosition >= getLength()
     */
    public T replace (int givenPosition, T newEntry);
    
    /**
     * Retrieves an entry at given position
     * @param givenPosition
     * @return the entry at givenPosition
     * @throws IndexOutOfBoundsException if either givenPosition < 0 or
     * givenPosition >= getLength()
     */
    public T getEntry (int givenPosition);
    
   /** Retrieves all entries that are in this list in the order they occur in the list.
   /* @ return a newly allocated array of all the entries in the list
   /* If the list is empty, the returned array is empty
    public T[] toArray();
   
    
   /**
   /* Sees whether the list contains the given entry
   /* @param anEntry the object: desired entry
   /* @return true if the list contains anEntry; false if not.
   */
    public boolean contains (T anEntry);
    
    /**
    /* Gets the length of this list
    /* @return the integer number of entrieas currently in the list
    */
    public int getLength();
    
    /** 
    /* Sees whether this list is empty
    /* return true if the list is empty, false if not
    */
    public boolean isEmpty();
}
