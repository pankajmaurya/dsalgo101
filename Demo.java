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

		System.out.println("\t[Adding first song to end of playlist 5 times]");
		p.add(song1);
		p.add(song1);
		p.add(song1);
		p.add(song1);
		p.add(song1);
		p.play();
		
		System.out.println("\t[Deleting song - Soul Sacrifice]");
		p.delete("Soul Sacrifice");
		p.play();

		System.out.println("\t[Cloning the playlist]");
		PlayList p2 = p.clone();
		p2.play();

		System.out.println("\t[Adding song - Soul Sacrifice]");
		p.add(getSong("Soul Sacrifice"));
		p.play();

		System.out.println("\t[Playing the clone]");
		p2.play();
		
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
