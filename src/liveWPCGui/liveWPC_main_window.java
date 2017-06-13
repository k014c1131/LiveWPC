package liveWPCGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class liveWPC_main_window extends liveWPC_window_base{
	private static JPanel panel = new JPanel();
liveWPC_main_window(){
	panel.setPreferredSize(new Dimension(225,400));
	//panel.setLayout(new FlowLayout(FlowLayout.CENTER));
	panel.setLocation(FlowLayout.CENTER,200);
	panel.setBackground(Color.WHITE);
	panel.setVisible(true);
	getContentPane().add(panel);
	insert_circle();
	setSize(750,480);
	setLocationRelativeTo(null);
	}
public static void insert_circle(){
	liveWPC_create_object tc = new liveWPC_create_object();
    tc.setBounds(0,0,100,100);
    tc.setPreferredSize(new Dimension(100,120));
    panel.add(tc);
}
}
