package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class liveWPC_main_window extends liveWPC_window_base{
	private JPanel panel = new JPanel();
	private liveWPC_tool_window tool_window;
	private liveWPC_proprety_window proprety_window;
	private liveWPC_create_object tc;
	liveWPC_main_window(){

		tc = new liveWPC_create_object();
		tc.setBounds(0,0,100,100);
		tc.setPreferredSize(new Dimension(100,120));

		tool_window= new liveWPC_tool_window();
		proprety_window = new liveWPC_proprety_window();
		panel.setPreferredSize(new Dimension(750,480));
		//panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setLocation(FlowLayout.CENTER,200);
		panel.setBackground(Color.WHITE);
		panel.setVisible(true);
		panel.add(tc,BorderLayout.CENTER);


		getContentPane().add(panel);



		setSize(750,480);
		setLocationRelativeTo(null);


	}
}


