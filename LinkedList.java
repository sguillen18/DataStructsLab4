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

	public T remove(int givenPosition) {
		if(givenPosition < 0 || (givenPosition > (numberOfEntries - 1))) {
			throw new NullPointerException();
		}
		Node pos = firstNode;
		for(int i = 0; givenPosition > i; i++) {
			pos = pos.getNext();
		}
		Node toRemove = pos.getNext();
		pos.setNext(toRemove.getNext());
		numberOfEntries --;
		
		return toRemove.getData();
		
	}

	public boolean remove(T anEntry) {
		if(isEmpty()) {
			return false;
		}
		else if (!contains(anEntry)) {
			return false;
		}
		else {
			Node newNode = new Node(anEntry);
			Node curr = firstNode.getNext();
			Node beforeCurr = firstNode;
			
			while(curr != newNode) {
				beforeCurr = curr;
				curr = curr.getNext();
			}
			
			beforeCurr.setNext(curr.getNext());
			numberOfEntries --;
			
			return true;
		}
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
		for(int i = 0; givenPosition > i; i++) {
			pos = pos.getNext();
		}
		return pos.getData();
		}
	
	public boolean contains(T anEntry) {
		Node pos = firstNode;

		while(pos != null) {
			if(pos.getData().equals(anEntry)) {
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