package songlib;
//import java.security.KeyStore.Entry;
import java.util.LinkedList;
import java.util.ListIterator;

public class tmp<E> extends LinkedList {
	//LinkedList<Song> slist = new LinkedList<Song>();
	
	
	//@Override
	public String[] toArray(tmp t1){
		//Song s  = (Song) getFirst();
		tmp t2= t1;
		Song s1;
		ListIterator<Song> listIter = t2.listIterator();
		String[] str1 = new String[10];
		//s1[0] = s.name;
		//String[] str2 = new String[5];
		//String[] str3 = new String[5];
		//String[] str4 = new String[5];
		for(int count = -3; listIter.hasNext() ; count++){
			s1 = listIter.next();
			str1[count+3] = s1.name;
			str1[count+4] = s1.artists;
			
			if(s1.album.equals(null)){
				str1[count+5] = "";
			}
			str1[count+5] = s1.album;
			if(s1.Year.equals(null)){
				str1[count+6] = "";
			}
			str1[count+6] = s1.Year;
		}
	
		//s1[0] = listIterator.next().name;
		//s1[1] = listIterator.next().name;
		
		//System.out.println(s1[0]);
	return str1;
	}
	
}
