package ticketbooking;

import java.util.*;

public class Queue {

	private LinkedList<Object> list = new LinkedList<Object>();

	Queue() {}

	public LinkedList<Object> getQueue() {
		return list;
	}

	public void add(Object obj) {
		list.add(obj);
	}

	public Object deleteFirst() {
		if (list != null) {
			Object removedObject = list.remove(0);
			return removedObject;
		} else {
			System.err.println("QUEUE IS EMPTY!");
			return null;
		}
	}

	public int size() {
		return list.size();
	}

	public void print() {
		System.out.println(list);
	}
	
	public Object getFirst() {
		if(list.size()>=1) { return list.get(0); }
		return null ;
	}

}
