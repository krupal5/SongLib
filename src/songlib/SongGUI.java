
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

import javax.swing.*;

public class SongGUI {
		/* flow : need to declare outside and initialize inside constructor
		 * JFrame frame;
		 * JButton button1, button2;
		 * 
		 */
	
	public SongGUI(){
		/* Then intialize here
		 * button1 = new button1();
		 * 
		 */
		JFrame frame = new JFrame("SongLibrary");
		
		frame.setLayout(new BorderLayout());
		// Buttons
		JButton add = new JButton("Add");
		JButton delete = new JButton("Delete");
		JButton edit = new JButton("Edit");
		
		//Panels
		JPanel bPanel = new JPanel();
		JPanel tPanel = new JPanel();
		JPanel dPanel = new JPanel(); // display
		JPanel labelP = new JPanel();
		JPanel listP = new JPanel();
		JPanel headP = new JPanel();
		JPanel bothP = new JPanel();
				
		//Create List
		JList list = new JList();
				
		// textfields
		JTextField nameTF = new JTextField();
		JTextField artistTF = new JTextField();
		JTextField albumTF = new JTextField();
		JTextField yearTF = new JTextField();
		
		//setting up textfields size
		nameTF.setPreferredSize(new Dimension(200,15));
		artistTF.setPreferredSize(new Dimension(200,15));
		albumTF.setPreferredSize(new Dimension(200,15));
		yearTF.setPreferredSize(new Dimension(200,15));
		
		list.setPreferredSize(new Dimension(200,400));
		
		// labels
		JLabel name = new JLabel("*Name");
		JLabel artist = new JLabel("*Artist");
		JLabel album = new JLabel("Album");
		JLabel year = new JLabel("Year");
		
		labelP.setMaximumSize(new Dimension(125,85));
		tPanel.setMaximumSize(new Dimension(220,85));
		bothP.setMaximumSize(new Dimension(labelP.getWidth() + tPanel.getWidth(), labelP.getHeight()+tPanel.getHeight()));
		
		
		//add buttons to panel
		bPanel.add(add);
		bPanel.add(delete);
		bPanel.add(edit);
		
		// add label to panel
		labelP.add(name);
		labelP.add(artist);
		labelP.add(album);
		labelP.add(year);
		//add textfields to panel
		tPanel.add(nameTF);
		tPanel.add(artistTF);
		tPanel.add(albumTF);
		tPanel.add(yearTF);
		// adding list to 
		listP.add(list);
		bothP.add(labelP);
		bothP.add(tPanel);
		
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
		
		
		// setting up JFrame
		frame.setSize(new Dimension(900,500));
		
		frame.setVisible(true);
		
		frame.setResizable(false);
		frame.setTitle("Song list");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack();
	
	
	}
	
	public static void main(String[] args){

		new SongGUI();
			
	}
}
