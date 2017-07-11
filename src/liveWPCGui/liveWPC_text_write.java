package liveWPCGui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class liveWPC_text_write {//テキストファイルを書き出すためのクラス

	private String writestr="";//書き出す内容を記録する変数
	private liveWPC_create_object co;
	private BufferedWriter filewriter;



	public void saveFile(File filepath){//今は仮置き、このクラスが持っている座標やサイズの情報を全て書き出す。
		try{
			File file =filepath;
			//ファイル名の変更処理はツール画面に移動
			filewriter = new BufferedWriter(new FileWriter(file));
			filewriter.write(writestr);//ここにクラスが持っている座標などを入力する。
			filewriter.close();
		}catch(IOException e){
			System.out.println(e);
		}
	 }
	public void setList(ArrayList<liveWPC_create_object> list){//動作確認用のメソッド、後で消去する予定
		for(int i=0;i<list.size();i++){
			co=(liveWPC_create_object) list.get(i);
			writestr = writestr+"\r\n"+(i+1)+co.returnValue()+"\r\n";
		}
		//System.out.println(writestr);
	}

}
