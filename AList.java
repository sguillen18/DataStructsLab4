package Lab4;
import java.util.Arrays;

public class AList <T> implements ListInterface <T>   {
    private T[] list;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 10000;
    private boolean initialized = false;
    
    //constructors
    public AList () {
        this(DEFAULT_CAPACITY);
    }
    
    public AList(int capacity) {
        if (capacity <= DEFAULT_CAPACITY)
            capacity = DEFAULT_CAPACITY;
        else
            ensureCapacity();
        @SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[capacity];
        list = temp;
        numberOfEntries = 0;
        initialized = true;
    }
    
    //check initialization
    private void checkInitialization() {
    	if(!initialized) {
    		throw new SecurityException();
    	}
    }
    
    //method declarations
    @Override
    public void add (T anEntry) {
      checkInitialization();
      list[numberOfEntries]  = anEntry;
      numberOfEntries ++;
      ensureCapacity();
    }
    
    public T[] toArray() {
        checkInitialization();
        @SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
        for (int idx = 0; idx < numberOfEntries; idx ++)
            result[idx] = list[idx];
        return result;
    }

    private void ensureCapacity(){
        int capacity = list.length - 1; // last index
        if (numberOfEntries >= capacity) {
            capacity *= 2;
            list = Arrays.copyOf(list, capacity + 1);       
        }
        
    }

    private void makeRoom (int newPosition){
        assert (newPosition >= 0 && newPosition <= numberOfEntries);
        for (int index = numberOfEntries; index > newPosition; index --)
            list[index] = list[index-1];
    }	

    public void add (int newPosition, T newEntry) {
    	checkInitialization();
    	makeRoom(newPosition);
    	list[newPosition] = newEntry;
    	numberOfEntries++;
    	ensureCapacity();
    }
    
    private void removeGap(int position) {
    	for(int i=position; i < numberOfEntries-1; i++) {
    		list[i] = list[i+1];
    	}
    	list[numberOfEntries - 1] = null;
    }
    
    //should this be a void?
    public T remove (int givenPosition) {
    	if(givenPosition < 0 || givenPosition >= numberOfEntries) {
    		//the exception in Gia's notes, OutOfBoundariesException doesn't exist.. i think
    		throw new IndexOutOfBoundsException();    		
    	}
    	T result = list[givenPosition];
    	removeGap(givenPosition);
    	numberOfEntries--;
    	return result;
    }

    public boolean remove (T anEntry) {
    	for(int i=0; i<numberOfEntries-1; i++) {
    		if(anEntry.equals(list[i])) {
    			removeGap(i);
    			numberOfEntries--;
    			return true;
    		}
    			
    	}
		return false;
    }

    public void clear() {
    	for(int i = 0; i < numberOfEntries; i++) {
			list[i] = null;
		}
    }

    /**
     * Replaces an entry at given position with a new one
     * @param givenPosition
     * @param newEntry
     * @return the replaced entry
     * @throws IndexOutOfBoundsException if either givenPosition < 0 or
     * givenPosition >= getLength()
     */
    public T replace (int givenPosition, T newEntry) {
    	if(givenPosition < 0 || givenPosition >= numberOfEntries) {
    		throw new IndexOutOfBoundsException();
    	}
    	list[givenPosition] = newEntry;
    	return newEntry;
    };
    
    /**
     * Retrieves an entry at given position
     * @param givenPosition
     * @return the entry at givenPosition
     * @throws IndexOutOfBoundsException if either givenPosition < 0 or
     * givenPosition >= getLength()
     */
    public T getEntry (int givenPosition) {
    	if(givenPosition < 0 || givenPosition >= numberOfEntries) {
    		throw new IndexOutOfBoundsException();
    	}
    	return list[givenPosition];
    }
    
   /** Retrieves all entries that are in this list in the order they occur in the list.
   /* @ return a newly allocated array of all the entries in the list
   /* If the list is empty, the returned array is empty
    public T[] toArray();
   
    
   /**
   /* Sees whether the list contains the given entry
   /* @param anEntry the object: desired entry
   /* @return true if the list contains anEntry; false if not.
   */
    public boolean contains (T anEntry) {
    	for(int i=0; i < numberOfEntries-1; i++) {
    		if(list[i] == anEntry) {
    			return true;
    		}    		
    	}
    	return false;
    }
    
    /**
    /* Gets the length of this list
    /* @return the integer number of entries currently in the list
    */
    public int getLength() {
    	return numberOfEntries;
    }
    
    /** 
    /* Sees whether this list is empty
    /* return true if the list is empty, false if not
    */
    public boolean isEmpty() {
    	if(numberOfEntries == 0) {
    		return true;
    	}
    	return false;
    }
    
    public void printList() {
    	for(int i = 0; i < numberOfEntries; i++) {
    		System.out.println(list[i]);
    	}
    }
}