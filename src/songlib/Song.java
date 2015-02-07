package songlib;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Song implements Comparable<Song> {
	String name;
	String artists;
	String album;
	int Year;
	@Override
	public int compareTo(Song s){
		String str = s.name;
		String str2 = s.artists;
		
		if((str.compareTo(this.name)) > 0){
			return 1;
		}else if ((str.compareTo(this.name))<0){
			return -1;
		}else if((str.compareTo(this.name)) == 0){
			if((str2.compareTo(this.artists)) > 0) {
				return 1;
			}
			else if ((str.compareTo(this.name))<0){
				return -1;
			}
		}
		return 0;
	}
	public Song(String name,String artists){
		this.name = name;
		this.artists = artists;
	}
	public String getName(){
		return this.name;
	}
	public String getArtist(){
		return this.artists;
	}
	public String getAlbum(){
		return this.album;
	}
	public int getYear(){
		return this.Year;
	}
	public void setAlbum(Song s){
		this.album = s.album;
	}
	public void setYear(Song s){
		this.Year = s.Year;
	}

}
