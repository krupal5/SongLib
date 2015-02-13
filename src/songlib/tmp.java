package songlib;
//import java.security.KeyStore.Entry;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.*;

import javax.swing.*;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Collections;
import java.util.ListIterator;

public class tmp<E> extends LinkedList {
	//LinkedList<Song> slist = new LinkedList<Song>();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7067443933659971415L;
	//@Override
	public String[] toArray(tmp t1){
		//Song s  = (Song) getFirst();
		tmp t2= t1;
		//Collections.sort(t2, Collections.reverseOrder());
		Song s1;
		ListIterator<Song> listIter = t2.listIterator();
		String[] str1 = new String[24];
		//s1[0] = s.name;
		//String[] str2 = new String[5];
		//String[] str3 = new String[5];
		//String[] str4 = new String[5];
		
		for(int count = -3; listIter.hasNext() ; count+=4){
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
		
		//System.out.println(s1[0]);
	return str1;
	}
	 public static final String file_name = "retrieve.txt";
	 public void saveToFile(){
	    	
	    	try (//FileWriter fstream = new FileWriter(file_name);
	    			FileOutputStream ostream = new FileOutputStream(file_name);
	    			ObjectOutputStream out = new ObjectOutputStream(ostream);
		    		//BufferedWriter out = new BufferedWriter(fstream);
	    			){
	    		out.writeObject(this);
	    		//ListIterator<Song> itr = sl.listIterator();
	    		//for(Song s : sl){
	    			//out.write(s + "\n");
	    		//}
	    		/*while(itr.hasNext()){
	    			Song song = (Song) itr.next();
	    			out.write(song +"\0");
	    			out.newLine();
	    			System.out.println("file created success");
	    		}*/
	    	}catch(Exception e){
	    		
	    	}
	    }
	 
	 @SuppressWarnings("unchecked")
	public void loadFromFile() {
		 try(FileInputStream istream = new FileInputStream(file_name);
			 ObjectInputStream in =  new ObjectInputStream(istream)){
			 addAll((LinkedList<Song>) in.readObject());
		 } catch (FileNotFoundException e){
			 //expected first time run
		 } catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
	 
}
