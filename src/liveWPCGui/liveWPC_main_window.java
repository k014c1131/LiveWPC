package liveWPCGui;

import java.awt.*;

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
		border.setPreferredSize(new Dimension(225,400));
		border.setOpaque(false);
		LineBorder bordercolor = new LineBorder(Color.BLACK, 2, true);
		border.setBorder(bordercolor);

		tool_window= new liveWPC_tool_window();
		proprety_window = new liveWPC_proprety_window();
		proprety_window.call_proprety_window(1);//数字を変更することで表示する内容を変える。
		//proprety_window.call_proprety_window(0);

		panel.setPreferredSize(new Dimension(750,480));
		//panel.setPreferredSize(new Dimension(225,400));
		//panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setLayout(new FlowLayout());
		panel.setLocation(FlowLayout.CENTER,200);
		panel.setBackground(Color.WHITE);
		panel.setVisible(true);
		panel.add(tc,BorderLayout.CENTER);
		panel.add(border,BorderLayout.CENTER);

		//getContentPane().countComponents();
		getContentPane().add(panel);



		setSize(750,480);
		setLocationRelativeTo(null);
		//proprety_window.change_text_size_box(false);
		//proprety_window.change_font_type_box(false);

	}
	public static void insert_image(String imagepath){
		liveWPC_create_object tc = new liveWPC_create_image_object(imagepath);
	    panel.add(tc);
	    tc.setLocation(50, 50);
	}
}
