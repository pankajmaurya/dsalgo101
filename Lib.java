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

		// Traverse the list of songs
		Node cur = head;
		while (cur != null) {
			System.out.println("Playing " + cur.item.title);
			cur = cur.next;
		}
	}
}
