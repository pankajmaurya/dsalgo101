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
		int limit = 20;

		// Traverse the list of songs
		Node cur = head;
		while (cur != null && limit > 0) {
			System.out.println("Playing " + cur.item.title);
			cur = cur.next;
			limit--;

			if (limit == 0) {
				System.out.println("Terminating due to limit, likely a circular linked list");
			}
		}
	}

	public void add(Song s) {
		// Traverse the list of songs
		Node cur = head;

		if (cur == null) {
			cur = new Node();
			cur.item = s;
			head = cur;
			return;
		}
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new Node();
		cur.next.item = s;
	}

	public void reverse() {
		Node first, second, third;
		first = head;

		if (first == null) return;
		second = first.next;
		if (second == null) return;

		third = second.next;
		first.next = null;
		while (true) {
			second.next = first;
			first = second;

			if (third == null) {
				break;
			}
			second = third;
			third = third.next;

		}
		head = second;
	}

	public void delete(String title) {
		// Traverse the list of songs
		Node cur = head;
		Node prev = cur;
		while (cur.next != null) {
			cur = cur.next;
			if (cur != null && cur.item.title.equalsIgnoreCase(title)) prev.next = cur.next;

			prev = cur;
		}
	}

	public PlayList clone() {
		PlayList p2 = new PlayList();

		// Traverse the list of songs
		Node cur = head;
		while (cur != null) {
			p2.add(cur.item);
			cur = cur.next;
		}
		return p2;
	}

	public PlayList getCircularClone() {
		PlayList cloned = clone();
		Node cur = head;
		while (cur != null) {
			cloned.add(cur.item);
			cur = cur.next;
		}

		Node t = cloned.head;
		while (t.next != null) t = t.next;
		t.next = cloned.head;
		return cloned;
	}
}
