package Lab4;

public class LinkedList <T> implements ListInterface <T>{
	
	private Node firstNode;
    private int numberOfEntries;
    private boolean initialized = false;
    
    public LinkedList () {
    	firstNode = null;
        numberOfEntries = 0;
        initialized = true;
    }
	
	private class Node{
		T data;
		Node next;
		
		public Node(T data, Node nextNode) {
			this.data = data;
			next = nextNode;
		}
		
		public Node(T newData) {
			this(newData, null);
		}
		
		public T getData() {
			return data;
		}
		
		public void setData(T newData) {
			data = newData;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node newNext) {
			next = newNext;
		}
		
	}

	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		if(isEmpty()) {
			firstNode = newNode;
		}
		else {
			Node last = firstNode;
			for(int i = 0; (numberOfEntries - 1) > i; i++) {
				last = last.getNext();
			}
			last.setNext(newNode);
		}
		numberOfEntries ++;
	}

	@Override
	public void add(int newPosition, T newEntry) {
		Node newNode = new Node(newEntry);
		Node pos = firstNode;
		for(int i = 0; newPosition > i; i++) {
			pos = pos.getNext();
		}
		Node next = pos.getNext();
		newNode.setNext(next);
		pos.setNext(newNode);
		numberOfEntries++;
	}

	public T remove (int givenPosition){
		   if (isEmpty())
		      throw new NullPointerException();
		   if (givenPosition < 0 || givenPosition >= getLength())
		      throw new IndexOutOfBoundsException();
		   T dataItem = firstNode.getData();
		            
		   if (givenPosition == 0)
		      firstNode = firstNode.getNext();
		   else {
		      Node currNode = getNodeAt(givenPosition -1);
		      dataItem = currNode.getNext().getData();
		      currNode.setNext(currNode.getNext().getNext());
		    }
		   return dataItem;
		}


	private Node getNodeAt(int givenPosition) {
		   assert (givenPosition >= 0 && givenPosition < getLength());
		 
		   Node currentNode = firstNode;
		   for (int idx = 0; idx < givenPosition; idx ++)
		       currentNode = currentNode.getNext();
		    return currentNode;
		 }

	public boolean remove(T anEntry) {
		int i=0;
		
	    Node nextNode = firstNode;
	    for (Node currNode = firstNode; nextNode != null; 
	                                     currNode = nextNode) {
	          if((currNode.getData()).equals(anEntry)) {
	        	  remove(i);
	        	  numberOfEntries--;
	        	  return true;
	          }
	          
	          nextNode = currNode.getNext();
	          i++; 
	     }
	     
		return false;

	}

	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
		
	}

	public T replace(int givenPosition, T newEntry) {
		T result = remove(givenPosition);
		add(givenPosition, newEntry);
		
		return result;
	}

	public T getEntry(int givenPosition) {
		Node pos = firstNode;
		if(givenPosition < 0)
		for(int i = 0; givenPosition <= i; i++) {
			pos = pos.getNext();
		}
		return pos.getData();
		}
	
	public boolean contains(T anEntry) {
		Node pos = firstNode;

		while(pos != null) {
			if((pos.getData()).equals(anEntry)) {
				return true;
			}
			pos = pos.getNext();
		}
		return false;
	}

	public int getLength() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		if(numberOfEntries == 0) {
			return true;
		}
		
		return false;
	}

}