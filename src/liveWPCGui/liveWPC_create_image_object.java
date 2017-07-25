package liveWPCGui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class liveWPC_create_image_object extends liveWPC_create_object{
	private String imagepath;
	private ImageIcon icon;
	liveWPC_create_image_object(String imagepath){//初期生成用
		super();
		this.imagepath=imagepath;
		icon = imageResize(imagepath);
		label.setBackground(null);
		label.setIcon(icon);
		label.setVisible(true);
		// 座標指定

		objectReSize();


	}
	liveWPC_create_image_object(String imagepath,int width,int height){//読みこみ時使用
		super();
		this.imagepath=imagepath;
		icon = imageResize(imagepath,width,height);
		label.setBackground(null);
		label.setIcon(icon);
		label.setVisible(true);
		// 座標指定

		objectReSize(width, height);


	}
	public ImageIcon imageResize(String str){//初期設定
		icon = new ImageIcon(str);
		Image img = icon.getImage() ;//画像を読み込み

		Image newimg = img.getScaledInstance(//サイズを変更
				icon.getIconWidth(),
				icon.getIconHeight(),
				java.awt.Image.SCALE_SMOOTH ) ;

		icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
		return icon;
	}
	public ImageIcon imageResize(String str,int width,int height){//読み込み時
		icon = new ImageIcon(str);
		Image img = icon.getImage() ;//画像を読み込み

		Image newimg = img.getScaledInstance(//サイズを変更
				width,
				height,
				java.awt.Image.SCALE_SMOOTH ) ;

		icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
		return icon;
	}
	@Override
	public void objectReSize(){//初期設定用
		this.setSize(icon.getIconWidth(), icon.getIconHeight());
		label.setBounds(0,0,icon.getIconWidth(), icon.getIconHeight());
	}
	public void objectReSize(int width,int height){//読み込み時使用
		this.setSize(width, height);
		label.setBounds(0,0,width, height);
	}
	@Override
	public String returnValue() {//設定値の情報を返すメソッド
		String str;
		str =	"{\r\n"+
				"\"type\":\"Image\",\r\n"+
				"\"x\":"+this.getX()+",\r\n"+
				"\"y\":"+this.getY()+",\r\n"+
				"\"width\":"+this.getWidth()+",\r\n"+
				"\"height\":"+this.getHeight()+",\r\n"+
				"\"ImagePath\":\""+this.getImagePath()+"\"\r\n"+
				"}";

		return str;
	}
	public String getImagePath(){
		return imagepath;
	}


}