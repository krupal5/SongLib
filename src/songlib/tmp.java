package songlib;
//import java.security.KeyStore.Entry;
import java.util.LinkedList;
import java.util.ListIterator;

public class tmp<E> extends LinkedList {
	//LinkedList<Song> slist = new LinkedList<Song>();
	
	public String[] printArray(){
		String [] s1 = new String[10];
		
		s1[0] = "hello";
		s1[1] = "world";
		//System.out.println(s1[0]);
		return s1;
	}
	
	@Override
	public String[] toArray(){
		Song s  = (Song) getFirst();
		ListIterator<Song> listIterator = listIterator();
		String[] s1 = new String[3];
		s1[0] = s.name;
		
		s1[1] = listIterator.next().name;
		s1[2] = listIterator.next().name;
	
		
		//System.out.println(s1[0]);
		return s1;
	}
}
