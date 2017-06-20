package liveWPCGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

//ツールバーの各機能を持ったクラス
//コンストラクタに変数を渡すことでどのクラスかを判別する
public class liveWPC_create_object  extends JPanel{

		  private JLabel label;
		  private ImageIcon icon;
		  public boolean enableinfo;
		  liveWPC_create_object(){
			icon = imageResize("./img/en.png");

		    label.setIcon(icon);
		    // 座標指定
		    //this.setLayout(null);
		    this.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		    //this.setLocation(0, 0);

		    // リスナーを登録
		    MyMouseListener listener = new MyMouseListener();
		    this.addMouseListener(listener);
		    this.addMouseMotionListener(listener);
		    add(label);

		  }
		  liveWPC_create_object(String imagepath){
			  icon = imageResize(imagepath);

			    labels.setIcon(icon);
			    // 座標指定
			    //this.setLayout(null);
			    this.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
			    //this.setLocation(0, 0);

			    // リスナーを登録
			    MyMouseListener listener = new MyMouseListener();
			    this.addMouseListener(listener);
			    this.addMouseMotionListener(listener);

			  }
			public ImageIcon imageResize(String str){
				icon = new ImageIcon(str);
				Image img = icon.getImage() ;//画像を読み込み
				Image newimg = img.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;//サイズを変更
				icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
				return icon;
			}


		  public void onClickObject(boolean setEnable){
			  //重くなるようならLineBorderはプライベート変数に
			  if(setEnable ==false){
  				//ボーダーを青くする処理
  		    	LineBorder border = new LineBorder(Color.blue, 1, true);
  		    	label.setBorder(border);
  		    	enableinfo = true;
			  }else{
				//ボーダーを透明化する処理
	    		LineBorder border = new LineBorder(new Color(0,0,0,0), 1, true);
	    		label.setBorder(border);
  		    	enableinfo = false;
			  }
		  }


			public ImageIcon imageResize(ImageIcon icon){
				Image img = icon.getImage() ;//画像を読み込み
				Image newimg = img.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;//サイズを変更
				icon = new ImageIcon( newimg );//サイズ変更した画像に変更する
				return icon;
			}
		  private class MyMouseListener extends MouseAdapter{
		    private int dx;
		    private int dy;

		    public void mouseDragged(MouseEvent e) {
		      // マウスの座標からラベルの左上の座標を取得する
		      int x = e.getXOnScreen() - dx;
		      int y = e.getYOnScreen() - dy;
		      setLocation(x, y);
		    }

		    public void mousePressed(MouseEvent e) {
		    	onClickObject(enableinfo);
		    	int btn = e.getButton();
		    	if (btn == MouseEvent.BUTTON1){
		    		 // 押さえたところからラベルの左上の差を取っておく
				      dx = e.getXOnScreen() - getX();
				      dy = e.getYOnScreen() - getY();
		    	}else if (btn == MouseEvent.BUTTON3){
		    	    System.out.println("右ボタンクリック");
		    	}

		    }
		  }

}
