/** 
 * Implementation of a Song Library
 * 
 * 
 * @author Krupal Suthar && Kalyan Gondhi
 *
 * @param <T>
 */
package songlib;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.awt.Container;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.util.ListIterator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.*;

public class SongGUI extends tmp {
		/* flow : need to declare outside and initialize inside constructor
		 * JFrame frame;
		 * JButton button1, button2;
		 * 
		 */
	JFrame frame;
	JButton add, delete, edit, confirm, cancel;
	tmp<Song> slist = new tmp<Song>();
	//ListIterator<Song> literator = slist.listIterator();
	String[] str1 = new String[100];
	String[] sName = new String[1000];
	String[] sAlbum = new String[1000];
	String[] sArtist = new String[1000];
	String[] sYear = new String[1000];

	int count = 0;
	
	JPanel bPanel, tNamePanel, tArtistPanel, tAlbumPanel, tYearPanel,  dPanel, labelP, listP, headP, bothP;

	JLabel name, artist, album, year,display;
		
	JList<String> list;
	
	JTextField nameTF;
	JTextField artistTF;
	JTextField albumTF;
	JTextField yearTF;
	DefaultListModel listModel;
	
	public SongGUI(){
		/* Then intialize here
		 * button1 = new button1();
		 * 
		 */
		
		frame = new JFrame("SongLibrary");
		
		frame.setLayout(new BorderLayout());
		// Buttons
		 add = new JButton("Add");
		 delete = new JButton("Delete");
		 edit = new JButton("Edit");
		 confirm = new JButton("Confirm");
		 cancel = new JButton("Cancel");
		
		//Panels
		 bPanel = new JPanel();// buttons
		 bPanel.setLayout(new GridLayout(3,3));
		 tNamePanel = new JPanel(); // text 
		 tNamePanel.setLayout(new GridLayout());
		 tArtistPanel = new JPanel(); // text 
		 tArtistPanel.setLayout(new GridLayout());
		 tAlbumPanel = new JPanel(); // text 
		 tAlbumPanel.setLayout(new GridLayout());
		 tYearPanel = new JPanel(); // text 
		 tYearPanel.setLayout(new GridLayout());
		 dPanel = new JPanel(); // display
		 //labelP = new JPanel(); // names, etc
		 //labelP.setLayout(new GridLayout());
		 listP = new JPanel(); // 
		 headP = new JPanel(); 
		 bothP = new JPanel();
		 display = new JLabel("Details");
				
		//Create List
		list = new JList();
		
		// Set the list to single selection mode, so no more than one field can be selected at the same time
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
		// textfields
		nameTF = new JTextField();
		artistTF = new JTextField();
		albumTF = new JTextField();
		yearTF = new JTextField();
		
		//setting up textfields size
		nameTF.setPreferredSize(new Dimension(200,15));
		artistTF.setPreferredSize(new Dimension(200,15));
		albumTF.setPreferredSize(new Dimension(200,15));
		yearTF.setPreferredSize(new Dimension(200,15));
		
		list.setPreferredSize(new Dimension(200,400));
		
		// labels
		name = new JLabel("                                                 *Name");
		artist = new JLabel("                                                 *Artist");
		album = new JLabel("                                                  Album");
		year = new JLabel("                                                   Year");
		
		dPanel.setMaximumSize(new Dimension(200,100));
		tNamePanel.setMaximumSize(new Dimension(220,85));
		tArtistPanel.setMaximumSize(new Dimension(220,85));
		tAlbumPanel.setMaximumSize(new Dimension(220,85));
		tYearPanel.setMaximumSize(new Dimension(220,85));
		bothP.setMaximumSize(new Dimension(/*labelP.getWidth() */+ tNamePanel.getWidth() + tArtistPanel.getWidth() + tAlbumPanel.getWidth() + tYearPanel.getWidth(), /*labelP.getHeight()*/+tNamePanel.getHeight()+tArtistPanel.getHeight()+tAlbumPanel.getHeight()+tYearPanel.getHeight()));
		
		
		//add buttons to panel
		bPanel.add(add);
		bPanel.add(delete);
		bPanel.add(edit);
		
		
		// add label to panel
		//labelP.add(name);
		//labelP.add(artist);
		//labelP.add(album);
		//labelP.add(year);
		tNamePanel.add(name);
		tArtistPanel.add(artist);
		tAlbumPanel.add(album);
		tYearPanel.add(year);
		//dPanel.add(display);
		dPanel.add(confirm);
		dPanel.add(cancel);
		dPanel.add(display);
		//add textfields to panel
		tNamePanel.add(nameTF);
		tArtistPanel.add(artistTF);
		tAlbumPanel.add(albumTF);
		tYearPanel.add(yearTF);
		// adding list to 
		listP.add(list);
		//bothP.add(labelP);
		bothP.add(tNamePanel);
		bothP.add(tArtistPanel);
		bothP.add(tAlbumPanel);
		bothP.add(tYearPanel);
		
		//set confirm button to false
		confirm.setVisible(false);
		cancel.setVisible(false);
		
		// action to button
		add.addActionListener(new AddBTNListener());
		edit.addActionListener(new EditBTNListener());
		delete.addActionListener(new DeleteBTNListener());
		confirm.addActionListener(new ConfirmBTNListener());
		cancel.addActionListener(new CancelBTNListener());
		
		// putting stuff in list
		//Object[] oarray = slist.toArray(new Object[10]);
		//System.out.println(oarray.toString());		
		//pArray(oarray);
		
		list.addListSelectionListener(new ListListener());
		/*listModel = new DefaultListModel();
		listModel.addElement("krupal");
		JList list2 = new JList(listModel);
		*/
		
		//panel.setBackground(Color.blue);
		//frame.getContentPane().add(bPanel);
		//frame.getContentPane().add(tPanel);
//		frame.getContentPane().add(headP);
//		frame.getContentPane().add(labelP);
//		frame.getContentPane().add(listP);
//		frame.getContentPane().add(dPanel);
//		frame.getContentPane().add(bothP);
		frame.add(bPanel, BorderLayout.WEST);
		frame.add(bothP, BorderLayout.CENTER);
		frame.add(listP, BorderLayout.EAST);
		frame.add(dPanel, BorderLayout.SOUTH);
		
		// setting up JFrame
		frame.setSize(new Dimension(900,500));
		//frame.pack();
		frame.setVisible(true);
		
		frame.setResizable(true);
		frame.setTitle("Song list");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		slist.loadFromFile();
		copying();
		list.setListData(sName);
		list.setSelectedIndex(0);
		
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				slist.saveToFile();
				super.windowClosing(e);
			}
		});
		
		
	
	}
	
	
	/*@override 
	public String[] printArray() {
		Song s = slist.getFirst();
		String [] listdata = new String[15];
		int count = 0;
		while (s != null){
			listdata[count] = (s.getName().toString());
			s = slist.iterator().next();
			count++;
		}
		return listdata;
	}
	*/
	private class ListListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if(list.getSelectedIndex() != -1){
			
			loaddetails();
			
			//}else {
				//list.setSelectedIndex(0);
				
			}
			//String selection = (String) list.getSelectedValue();
			//nameTF.setText(selection);
		}
	}
	public void getSelected(){
		int count = list.getSelectedIndex();
		nameTF.setText(sName[count]);
	}

	private class AddBTNListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			confirm.setVisible(false);
			cancel.setVisible(false);
			
			Song tmp = new Song(nameTF.getText(),artistTF.getText());
			tmp.setAlbum(albumTF.getText());
			tmp.setYear(yearTF.getText());
		/*	boolean check = duplicate(tmp);
			if(check == true){
				System.out.println("its duplicate");
			}
			if(check == false){
			slist.add(tmp);
			}*/
			
			//String artistHolder = artistTF.;
			if(alreadyThere(nameTF.getText(), artistTF.getText()) != false && !artistTF.getText().equals(""))
			{
			//System.out.println(artistHolder);
			slist.add(tmp);
			Collections.sort(slist, Collections.reverseOrder());
			
		    copying();
			list.setListData(sName);
			list.setSelectedIndex(0);
			//artistNameHolder = null;
			}
			//System.out.println(sName[1]);
			
			
			//System.out.println(str2[count]);
			//count++;

		}
	}
	private class EditBTNListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(list.getSelectedIndex() != -1){
			loaddetails();
			confirm.setVisible(true);
			cancel.setVisible(true);
			}
		}
			
			// TODO Auto-generated method stub
			
		}
	
	private class CancelBTNListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			confirm.setVisible(false);
			cancel.setVisible(false);
			
			nameTF.setText(null);
			artistTF.setText(null);
			albumTF.setText(null);
			yearTF.setText(null);
			
			display.setText("Details");
			list.setSelectedIndex(0);
		}
		}
	
	private class ConfirmBTNListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			confirm.setVisible(false);
			cancel.setVisible(false);
			if(list.getSelectedIndex() != -1){
				//loaddetails();
				slist.remove(list.getSelectedIndex());
				copying();
				
				//slist.remove(list.getSelectedIndex());
				//copying();
				
				// TODO Auto-generated method stub
				Song tmp = new Song(nameTF.getText(),artistTF.getText());
				tmp.setAlbum(albumTF.getText());
				tmp.setYear(yearTF.getText());
			/*	boolean check = duplicate(tmp);
				if(check == true){
					System.out.println("its duplicate");
				}
				if(check == false){
				slist.add(tmp);
				}*/
				if(alreadyThere(nameTF.getText(), artistTF.getText()) != false && !artistTF.getText().equals(""))
				{
				//System.out.println(artistHolder);
				slist.add(tmp);
				Collections.sort(slist, Collections.reverseOrder());
				
			    copying();
				list.setListData(sName);
				//artistNameHolder = null;
				}
				
				nameTF.setText(null);
				artistTF.setText(null);
				albumTF.setText(null);
				yearTF.setText(null);
				
				display.setText("Details");
				list.setSelectedIndex(0);
				
			}
			//list.setListData(sName);
			// TODO Auto-generated method stub
			
		}
	}
	
	
	private class DeleteBTNListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		/*	if(list.getSelectedIndex() != -1) {
				while(!slist.isEmpty()){
				if((list.getSelectedValue().equals(slist.))){
					slist.remove();
				}
				slist.iterator().next();d
				}
				
			}*/
			confirm.setVisible(false);
			cancel.setVisible(false);
			if(list.getSelectedIndex() != -1){
				/*String s1 = new String();
				s1 = list.getSelectedValue().toString();
				if(list.getSelectedValue().equals(slist.contains(s1))){
					slist.remove(list.getSelectedIndex());
					
					toFalse();
					
				
				}*/
				//int x = list.getSelectedIndex();
				//System.out.println(x);
			//}
				slist.remove(list.getSelectedIndex());
				copying();
				
				nameTF.setText(null);
				artistTF.setText(null);
				albumTF.setText(null);
				yearTF.setText(null);
				
				display.setText("Details");
				list.setSelectedIndex(0);
				
			}
			list.setListData(sName);
		}
	}

	//public static void main(String[] args){

		//new SongGUI();
	//}
	public void copying(){
		str1 = Arrays.copyOf(slist.toArray(slist), slist.toArray(slist).length);
		
		
		for(int count = 0,e1 = 0; str1.length != count;count+=4, e1++){
			sName[e1] = str1[count];
			sArtist[e1] = str1[count+1];
			sAlbum[e1] = str1[count+2];
			sYear[e1] = str1[count+3];
			//System.out.println(sArtist[e1]);
		}
	}
	
	public boolean alreadyThere(String x,String y)
	{
		
		if(x!= null && y!=null)
		{
			for(int i=0; sName.length != i; i++)
			{
				if(x.equals(sName[i]) && y.equals(sArtist[i])){
				    return false;
				}
			}
			return true;
		}else{return true;}	
		
		
	}
	/*
	public boolean duplicate(Song tmp){
		while(literator.hasNext()){
			if(tmp.name == literator.next().name){
				if(tmp.name == literator.next().artists){
					return true;
				}
			}
		}
		return false;
	}*/
	public void toFalse(){
		nameTF.setText(null);
		artistTF.setText(null);
		albumTF.setText(null);
		yearTF.setText(null);
	}

	/*
	@Override
	public String[] toArray(){
		Song s = slist.getFirst();
		String[] listdata = new String[15];
		int count = 0;
		while (literator.hasNext()){
			//listdata[count] = (s.getName().toString());
			listdata[count] = literator.next().name;
			count++;
		}
		return listdata;
	}
	*/
	public void loaddetails(){
		
		int counting = list.getSelectedIndex(); 
		nameTF.setText(sName[counting]);
		artistTF.setText(sArtist[counting]); 
		albumTF.setText(sAlbum[counting]);
		yearTF.setText(sYear[counting]);
		
		display.setText("Name of the song is " + nameTF.getText() + "                Name of the artist is " + artistTF.getText() + "           Album: " + albumTF.getText() + "           Year: " + yearTF.getText());
	}
	
   public void loadDefaultDetails(){
			 
		nameTF.setText(sName[0]);
		artistTF.setText(sArtist[0]); 
		albumTF.setText(sAlbum[0]);
		yearTF.setText(sYear[0]);
	}
	
	
	/*{ 
		BufferedReader reader;

      try {
    	  reader = openFile(fileName);

        } catch (IOException e) {

            System.out.println(e.getMessage());

            return;

        }

 

        String fileContents;

        try {

            fileContents = readFile(reader);

        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());

            return;

        }

 

        tmp = readObjects(fileContents);

        System.out.println(tmp);

    }

 
    private static BufferedReader openFile(String fileName) throws IOException {

        try {

            return new BufferedReader(new FileReader(fileName));

        } catch (FileNotFoundException e) {

            throw new IOException("File [name=" + fileName + "] not found.", e);

        }

    }

 

    private static String readFile(BufferedReader reader) throws IOException {

        StringBuffer sb = new StringBuffer();

        String line;

        while ((line = reader.readLine()) != null) {

            sb.append(line);

        }

 

        return sb.toString();

    }

 

    private static tmp<Song> readObjects(String fileContents) {

        String[] parts = fileContents.split(Character.toString('\0'));

 

        LinkedList<Song> tmp = new LinkedList<Song>();

        for (int i = 0,e1 = 0; length = parts.length; i < length; i+=4,e1++) {

            sName[e1] = str1[count];
			sArtist[e1] = str1[count+1];
			sAlbum[e1] = str1[count+2];
			sYear[e1] = str1[count+3];

            Song tmp = new Song(name, artists);

            tmp.add(Song);

        }

 

        return tmp;

    }
    */

 
	public String[] parray(Object[] Array) {
		Object[] oarray = Array;
		String[] stringArray = Arrays.copyOf(oarray,oarray.length, String[].class);
		/*for (int i = 0; i < slist.size(); i++) {
	         oarray[i] = slist.toArray();
	}*/
		System.out.println(stringArray[1]);
		return stringArray;
}
}