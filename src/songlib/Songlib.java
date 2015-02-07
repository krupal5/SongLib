package songlib;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;

// sortelistmodel in java.. search it in google ( if you can't figure out)

public class Songlib{
	LinkedList<Song> slist = new LinkedList<Song>();
		
	public static void main(String[] args){
		Songlib sl = new Songlib();
		Song so = new Song ("as","hdhd");
		sl.slist.add(so);
		String str = sl.slist.getFirst().name;
		System.out.println(str);
		
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