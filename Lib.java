/*
   Examples of daily life usage of lists (are there ideally lists / linked lists?)
   - todo lists
   - list of attendees in a meeting
   - music playlist => Great example.
   - a word dictionary
   - ecart
  
   Linked list
 - linearly organized data structure which can alter in size dynamically. 
 - Node
*/

import java.util.List;

class Node {
	// pointer to the next item.
	Node next;
	Song item;
}

class Song {
	String title;
}

class PlayList {
	Node head;
	public void play() {
		System.out.println("Staring to play songs.");

		// Traverse the list of songs
		Node cur = head;
		while (cur != null) {
			System.out.println("Playing " + cur.item.title);
			cur = cur.next;
		}
	}
}

/*
A stack is a data structure which allows access of elements in the LIFO (last in first out) order.
We can implement it easily via a doubly linked list.
 */

// A minimal representation of a physical newspaper
class Newspaper {
	String headline;
	String date;
	String company;

	@Override
	public String toString() {
		return "Newspaper{" +
				"headline='" + headline + '\'' +
				", date='" + date + '\'' +
				", company='" + company + '\'' +
				'}';
	}

	public static Newspaper printTimes(String headline, String date) {
		Newspaper newspaper = new Newspaper();
		newspaper.company = "The Times";
		newspaper.date = date;
		newspaper.headline = headline;
		return newspaper;
	}
}

// Lets create a stackpile of these.

class NewsNode {
	// pointer to the next item.
	NewsNode next;
	NewsNode prev;
	Newspaper item;

	@Override
	public String toString() {
		return "NewsNode{" +
				"next=" + next +
				", prev=" + prev +
				", item=" + item +
				'}';
	}
}

class NewsStack {
	NewsNode top;

	public Newspaper peek() {
		if (top != null) return top.item;
		return null;
	}

	public void push(Newspaper newspaper) {
		// case of empty stack
		if (top == null) {
			top = new NewsNode();
			top.item = newspaper;
			return;
		}

		NewsNode node = new NewsNode();
		node.item = newspaper;
		top.next = node;
		node.prev = top;
		top = node;
	}

	public Newspaper pop() {
		if (top == null) {
			// can also throw a StackIsEmpty like exception
			return null;
		}

		Newspaper newspaper = top.item;
		top = top.prev;
		return newspaper;
	}
}

/*
A queue is a data structure which allows access of elements in a FIFO (first in first out) order.
We can easily implement it again as a linked list.
It is also common to implement it on top of an array with bounded capacity.
 */

interface Queue<T> {
	// Return true if able to enqueue (capacity remaining) else returns false.
	public boolean enqueue(T item);
	// item returned can be null if queue is empty.
	public T dequeue();
}