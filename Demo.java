public class Demo {

	public static void main(String[] args) {
		PlayList p = new PlayList();
		p.head = new Node();
		Song song1 = new Song();
		song1.title = "Black Magic Woman";
		p.head.item = song1;


		p.head.next = new Node();
		p.head.next.item = getSong("Soul Sacrifice");

		
		p.head.next.next = new Node();
		p.head.next.next.item = getSong("Oye Como Va");

		p.play();


		NewsStack newsStack = new NewsStack();
		newsStack.push(Newspaper.printTimes("End of the war", "May 8, 1945"));
		newsStack.push(Newspaper.printTimes("India gets freedom", "August 15, 1947"));
		newsStack.push(Newspaper.printTimes("Man lands on the moon", "July 20, 1969"));

		System.out.println(newsStack.peek());
		newsStack.pop();
		System.out.println(newsStack.pop());
		System.out.println(newsStack.pop());
		System.out.println(newsStack.pop());
	}

	private static Song getSong(String title) {
		Song song = new Song();
		song.title = title;
		return song;
	}
}
