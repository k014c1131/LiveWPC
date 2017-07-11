package liveWPCGui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class liveWPC_create_image_object extends liveWPC_create_object{
	String imagepath;
	liveWPC_create_image_object(String imagepath){
		super();
		this.imagepath=imagepath;
		icon = imageResize(imagepath);
		label.setBackground(null);
		label.setIcon(icon);
		label.setVisible(true);
		// 座標指定

		objectReSize();


	}
	public ImageIcon imageResize(String str){
		icon = new ImageIcon(str);
		Image img = icon.getImage() ;//画像を読み込み

		Image newimg = img.getScaledInstance(//サイズを変更
				icon.getIconWidth(),
				icon.getIconHeight(),
				java.awt.Image.SCALE_SMOOTH ) ;

		icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
		return icon;
	}
	@Override
	public void objectReSize(){
		this.setSize(icon.getIconWidth(), icon.getIconHeight());
		label.setBounds(0,0,icon.getIconWidth(), icon.getIconHeight());
	}
	@Override
	public String returnValue() {//設定値の情報を返すメソッド
		String str;
		str =	"{\r\n"+
				"type:Image\r\n"+
				"x:"+this.getX()+"\r\n"+
				"y:"+this.getY()+"\r\n"+
				"width:"+this.getWidth()+"\r\n"+
				"heigth:"+this.getHeight()+"\r\n"+
				"ImagePath:"+this.getImagePath()+"\r\n"+
				"}\r\n";

		return str;
	}
	private String getImagePath(){
		return imagepath;
	}


}