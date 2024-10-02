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
	Node tail;
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
			tail = cur;
			return;
		}

		tail.next = new Node();
		tail.next.item = s;
		tail = tail.next;

//		while (cur.next != null) {
//			cur = cur.next;
//		}
//		cur.next = new Node();
//		cur.next.item = s;
	}

	public void reverse() {
		Node first, second, third;
		first = head;
		tail = first;

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

		if (head == null) return;

		if (head.item.title.equalsIgnoreCase(title)) {
			head = head.next;

			if (tail.item.title.equalsIgnoreCase(title)){
				tail = null;
			}
			return;
		}
		Node cur = head;
		Node prev = cur;
		while (cur.next != null) {
			cur = cur.next;
			if (cur != null && cur.item.title.equalsIgnoreCase(title)) {
				prev.next = cur.next;
				if (cur == tail) {
					tail = prev;
				}
			}
			prev = cur;
		}
	}

	public PlayList clone() {
		PlayList p2 = new PlayList();
		if (head != null) {
			p2.head = new Node();
			p2.head.item = head.item;
		}

		Node cur = head.next;
		Node p2cur = p2.head;
		while (cur != null) {
			p2cur.next = new Node();
			p2cur.next.item = cur.item;

			if (cur.next == null) {
				p2.tail = p2cur;
			}
			cur = cur.next;
			p2cur = p2cur.next;
		}
		return p2;
	}

	public PlayList getCircularClone() {
		PlayList p2 = new PlayList();
		if (head != null) {
			p2.head = new Node();
			p2.head.item = head.item;
		}

		Node cur = head.next;
		Node p2cur = p2.head;
		while (cur != null) {
			p2cur.next = new Node();
			p2cur.next.item = cur.item;

			if (cur.next == null) {
				p2.tail = p2cur;
				p2.tail.next = p2.head;
				break;
			}
			cur = cur.next;
			p2cur = p2cur.next;
		}
		return p2;
	}
}
