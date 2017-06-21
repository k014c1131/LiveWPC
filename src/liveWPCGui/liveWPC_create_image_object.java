package liveWPCGui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class liveWPC_create_image_object extends liveWPC_create_object{
	liveWPC_create_image_object(String imagepath){
		super();
		icon = imageResize(imagepath);
		label.setIcon(icon);
		label.setVisible(true);
		// 座標指定

		objectReSize();


	}
	public ImageIcon imageResize(String str){
		icon = new ImageIcon(str);
		Image img = icon.getImage() ;//画像を読み込み
		Image newimg = img.getScaledInstance(icon.getIconWidth(), icon.getIconHeight(),java.awt.Image.SCALE_SMOOTH ) ;//サイズを変更
		icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
		return icon;
	}

}