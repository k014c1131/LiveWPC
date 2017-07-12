package liveWPCGui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class liveWPC_create_image_object extends liveWPC_create_object{
	private String imagepath;
	private ImageIcon icon;
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
		if(width == -1 && height == -1){
			width = icon.getIconWidth();
			height = icon.getIconHeight();
		}
		this.setSize(width,height);
		label.setBounds(0,0,width, height);
	}

	@Override
	public void onClickObject(boolean setEnable){
		liveWPC_proprety_window.get_select_object(this,0);
		super.onClickObject(setEnable);

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