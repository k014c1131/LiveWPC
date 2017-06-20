package liveWPCGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class liveWPC_main_window extends liveWPC_window_base{
	private static JPanel panel = new JPanel();
	private JPanel border = new JPanel();
	private liveWPC_tool_window tool_window;
	private liveWPC_proprety_window proprety_window;
	private liveWPC_create_object tc;
	//private static Graphics g;

	liveWPC_main_window(){
		//g = this.getGraphics();

		tc = new liveWPC_create_object();
		tc.setBounds(0,0,100,100);
		tc.setPreferredSize(new Dimension(100,120));

		border.setPreferredSize(new Dimension(225,400));
		border.setOpaque(false);
		LineBorder bordercolor = new LineBorder(Color.BLACK, 2, true);
		border.setBorder(bordercolor);

		tool_window= new liveWPC_tool_window();
		proprety_window = new liveWPC_proprety_window();
		proprety_window.call_proprety_window(1);
		//proprety_window.call_proprety_window(0);

		panel.setPreferredSize(new Dimension(750,480));
		//panel.setPreferredSize(new Dimension(225,400));
		//panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setLayout(new FlowLayout());
		panel.setLocation(FlowLayout.CENTER,200);
		panel.setBackground(Color.WHITE);
		panel.setVisible(true);
		//panel.add(tc,BorderLayout.CENTER);
		panel.add(border,BorderLayout.CENTER);

		//getContentPane().countComponents();
		//getContentPane().add(tc);
		getContentPane().add(panel);



		setSize(750,480);
		setLocationRelativeTo(null);
		//proprety_window.change_text_size_box(false);
		//proprety_window.change_font_type_box(false);

	}
	public static void insert_circle(){
		liveWPC_create_object tc = new liveWPC_create_object();
	    //tc.setBounds(0,0,100,100);
	    tc.setPreferredSize(new Dimension(100,120));
	    panel.add(tc);
	    tc.setLocation(50, 50);

	    /*g.setColor(Color.RED);
        g.fillOval(50, 50, 100, 100);
        g.dispose();*/

	}
	public static void insert_image(String imagepath){
		liveWPC_create_object tc = new liveWPC_create_object(imagepath);
	    tc.setPreferredSize(new Dimension(100,120));
	    panel.add(tc);
	    tc.setLocation(50, 50);
	}
}
