
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

public class SongGUI extends tmp {
		/* flow : need to declare outside and initialize inside constructor
		 * JFrame frame;
		 * JButton button1, button2;
		 * 
		 */
	JFrame frame;
	JButton add, delete, edit;
	tmp<Song> slist = new tmp<Song>();
	ListIterator<Song> literator = slist.listIterator();
	
	int count = 0;
	
	JPanel bPanel, tNamePanel, tArtistPanel, tAlbumPanel, tYearPanel,  dPanel, labelP, listP, headP, bothP;

	JLabel name, artist, album, year,display;
		
	JList list;
	
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
		 display = new JLabel("display");
				
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
		
		// action to button
		add.addActionListener(new AddBTNListener());
		edit.addActionListener(new EditBTNListener());
		delete.addActionListener(new DeleteBTNListener());
		
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
		
		frame.setVisible(true);
		
		frame.setResizable(true);
		frame.setTitle("Song list");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack();
		
	
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
			String selection = (String) list.getSelectedValue();
			nameTF.setText(selection);
		}
	}
	
	private class AddBTNListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Song tmp = new Song(nameTF.getText(),artistTF.getText());
			String[] str1 = new String[100];
			String[] sName = new String[100];
			String[] sAlbum = new String[100];
			String[] sArtist = new String[100];
			String[] sYear = new String[100];
		
			
			tmp.setAlbum(albumTF.getText());
			tmp.setYear(yearTF.getText());
//			String[] str2 = new String[10];
			slist.add(tmp);
			
			
			//Song tmp2 = new Song(nameTF.getText(), artistTF.getText());
			//slist.add(tmp2);
			//System.out.println("YAY !!! it works" + tmp.name);
						
			/*for (int i = 0; str2.length != i;i++){
			str2[i] = str1[i];
				}*/
			
			//str1 = slist.toArray(slist);
			//for(int i =0; slist.toArray(slist).length != i ; i++){
				//str1[i] = slist.toArray(slist)[i];
			//}
			
			str1 = Arrays.copyOf(slist.toArray(slist), slist.toArray(slist).length);
	//		int j = str1.length;
			//System.out.println(j);
			
			for(int count =0; str1.length != count;count+=4){
				sName[count] = str1[count];
				sArtist[count] = str1[count+1];
				sAlbum[count] = str1[count+2];
				sYear[count] = str1[count+3];
			}
			//str2[count] = str1[count];
			//str2[1] = str1[1];
			//for(int i =0,count = 0; 10 < count; count = count +4 , i++){
				//sName[i] = str1[count];
			//}
			//System.out.println(sName[0]);
			list.setListData(sName);
			System.out.println(sName[1]);
			
			
			//System.out.println(str2[count]);
			//count++;

		}
	}
	private class EditBTNListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(list.getSelectedIndex() != -1){
				//String s1 = new String();
				//s1 = list.getSelectedValue().toString();
				//if(list.getSelectedValue().equals(slist.contains(s1))){
					
			//	}
				Song tmp = new Song(nameTF.getText(),artistTF.getText());
				String[] str1 = new String[10];
				
				tmp.setAlbum(albumTF.getText());
				tmp.setYear(yearTF.getText());
				String[] str2 = new String[10];
				slist.add(tmp);
				
				
				str1 = slist.toArray(slist);
				str2[count] = str1[count];
				//str2[1] = str1[1];
				
				
				//list.setListData(slist.toArray(slist));
				String s1 = new String();
				s1 = list.getSelectedValue().toString();
				//if(list.getSelectedValue().equals(slist.contains(s1))){
					slist.remove(list.getSelectedIndex());
				//System.out.println(str2[count]);
				count++;
				
				
				list.setListData(slist.toArray(slist));
			}
			
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
				slist.iterator().next();
				}
				
			}*/
			if(list.getSelectedIndex() != -1){
				String s1 = new String();
				s1 = list.getSelectedValue().toString();
				//if(list.getSelectedValue().equals(slist.contains(s1))){
					slist.remove(list.getSelectedIndex());
			//	}
				list.setListData(slist.toArray(slist));
			}
		}
	}
	public static void main(String[] args){

		new SongGUI();
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

