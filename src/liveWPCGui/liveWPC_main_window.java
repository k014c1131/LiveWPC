package liveWPCGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class liveWPC_main_window extends liveWPC_window_base{
	private JPanel panel = new JPanel();
liveWPC_main_window(){
	panel.setPreferredSize(new Dimension(225,400));
	//panel.setLayout(new FlowLayout(FlowLayout.CENTER));
	panel.setLocation(FlowLayout.CENTER,200);
	panel.setBackground(Color.WHITE);
	panel.setVisible(true);
	getContentPane().add(panel);

	setSize(750,480);
	setLocationRelativeTo(null);


	}
}


