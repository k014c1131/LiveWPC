package liveWPCGui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class liveWPC_tool_window extends liveWPC_window_base{
	private JToolBar toolbar=new JToolBar();
	private JButton bt1;
	private JButton bt2;
	liveWPC_tool_window(){
		setBounds(1100,100,200,500);

		toolbar.setFloatable(true);
		toolbar.setSize(100,10);
		toolbar.setVisible(true);

		bt1 = new JButton(new ImageIcon("img/testicon1.png"));
		toolbar.add(bt1);

		bt2 = new JButton(new ImageIcon("img/testicon1.png"));
		toolbar.add(bt2);
		getContentPane().add(toolbar);

	}
}
