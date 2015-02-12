package songlib;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.util.ListIterator;


// sortelistmodel in java.. search it in google ( if you can't figure out)

public class Songlib extends tmp{
	//LinkedList<Song> tmplist = new LinkedList<Song>();
	/*
	public String[] printArray() {
		Song s = tmplist.getFirst();
		String [] listdata = new String[15];
		int count = 0;
		while (s != null){
			//listdata[count] = (s.getName().toString());
			listdata[count] = tmplist.iterator().next().name.toString();
			count++;
		}
		return listdata;
	}*/
	public String[] toArray(){
		
		String[] s1 = new String[3];
		s1[0] = "hello";
		s1[1] = "world";
		//System.out.println(s1[0]);
		return s1;
	}
	public static void main(String[] args){
		Songlib sl = new Songlib();
		Song so = new Song ("as","hdhd");
		Song s1 = new Song ("secon","kali1");
		Song s2 = new Song ("third","kali2");
		tmp<Song> t2 = new tmp<Song>();
		//sl.tmplist.add(so);
		//sl.tmplist.add(s1);
		//sl.tmplist.add(s2);
		ListIterator<Song> listIterator = t2.listIterator();
		
		/*while(listIterator.hasNext()){
			System.out.println(listIterator.next().name);
		}*/
	//	sl.slist.
		String [] str1 = new String[3];
		//Song[] wo = new Song[5];
		//tmp t1 = new tmp();
		//tmp<Song> t2 = new tmp<Song>();
		t2.add(so);
		t2.add(s1);
		t2.add(s2);
		str1 = t2.toArray();
		System.out.println(str1[0]);
		System.out.println(str1[1]);
		System.out.println(str1[2]);
		
		
		/*testing file*/
		FileOutputStream fop = null;
		File file;
		String content = "some string that i will get";
		/*try {
			file =
		}catch{
			
		}*/
		
	}
	
}