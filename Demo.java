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

		// TODO: Implement a method called reverse on the playlist
		System.out.println("[Reversing the playlist]");
		p.reverse();

		p.play();

	}

	private static Song getSong(String title) {
		Song song = new Song();
		song.title = title;
		return song;
	}
}
