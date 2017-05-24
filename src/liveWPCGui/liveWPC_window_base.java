package liveWPCGui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class liveWPC_window_base extends JFrame{
	liveWPC_window_base(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setVisible(true);
	}

}

