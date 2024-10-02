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
// Practice problems: https://leetcode.com/problem-list/linked-list/
/*
A linked list is great for appending items or growing dynamically.
However, searching an element is not performant.
Deleting an element if we have to find it is hence not performant as well.
Also sorting a linked list is tedious.

We explore an advanced data structure called a SkipList
A skiplist is a data structure that takes O(log(n)) time to add, erase and search.
It uses multiple linked lists and a concept of levels.
It keeps the items sorted, making searching, insertion and deletion as O(log(n))
*/

interface Skiplist {
	boolean search(int target);

	void add(int num);

	boolean erase(int num);
};