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

		// TODO: Add the song1 after last song 5 times
		System.out.println("\t[Adding first song to end of playlist 5 times]");
		p.play();
		
	
		// TODO: delete the song "Soul Sacrifice"
		System.out.println("\t[Deleting song - Soul Sacrifice]");
		p.delete("Soul Sacrifice");
		p.play();


		// TODO: Clone the Playlist
		System.out.println("\t[Cloning the playlist]");
		PlayList p2 = p.clone();
		p2.play();

		// TODO: Add the song Soul Sacrifice to p
		System.out.println("\t[Adding song - Soul Sacrifice]");
		p.play();
		p2.play();
	
		// TODO: Implement a method called reverse on the playlist
		System.out.println("\t[Reversing the playlist]");
		p.reverse();
		p.play();

		// TODO: Get a clone of the playlist p which is a circular linked list.
		System.out.println("\t[Cloning the playlist as a circular playlist]");
		PlayList p3 = p.getCircularClone();
		// Playing P3 would never terminate.
		p3.play();

	}

	private static Song getSong(String title) {
		Song song = new Song();
		song.title = title;
		return song;
	}
}
