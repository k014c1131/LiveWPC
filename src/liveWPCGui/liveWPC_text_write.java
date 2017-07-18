package liveWPCGui;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class liveWPC_text_write {//テキストファイルを書き出すためのクラス

	private String writestr="";//書き出す内容を記録する変数
	//private liveWPC_create_object co;
	private BufferedWriter filewriter;
	private String imagepath;
	private ArrayList<String> imagelist= new ArrayList<>();


	public void saveFile(File filepath){//今は仮置き、このクラスが持っている座標やサイズの情報を全て書き出す。
		try{
			filepath.mkdir();//フォルダを作成するメソッド
			File imagedir =new File(filepath+"/img");
			imagedir.mkdir();
			for(String imagepath: imagelist){
				//System.out.println(filepath+"/"+ imagepath);
				copyFile(new File(imagepath),new File(filepath+"/"+imagepath));
			}
			File file =new File(filepath+"/text.txt");

			//System.out.println(filepath+" "+filepath.getPath());


			//ファイル名の変更処理はツール画面に移動
			filewriter = new BufferedWriter(new FileWriter(file));
			filewriter.write(writestr);//ここにクラスが持っている座標などを入力する。
			filewriter.close();
			compressDirectory(filepath+".zip",filepath+"");
			writestr="";
		}catch(IOException e){
			System.out.println(e);
		}
	}
	public void setList(ArrayList<liveWPC_create_object> list){//動作確認用のメソッド、後で消去する予定
		int i=0;
		for(liveWPC_create_object co : list){
			i++;
			if((imagepath = co.getImagePath())!=null){
				imagelist.add(imagepath);//ファイルパスをもとに画像をコピー

				//System.out.println("yattaze"+co.getName());
			}
			System.out.println(imagelist);
			writestr = writestr+"\r\n"+i+co.returnValue()+"\r\n";
		}
		//System.out.println(writestr);
	}

	public void copyFile(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(),outChannel);

			if (inChannel != null){
				inChannel.close();
			}
			if (outChannel != null){
				outChannel.close();
			}
		}
		catch (IOException e) {
			throw e;
		}
		finally {
		}
	}

	public boolean compressDirectory( String filePath, String directory ) {
		File baseFile = new File(filePath);
		File file = new File(directory);
		ZipOutputStream outZip = null;
		try {
			// ZIPファイル出力オブジェクト作成
			outZip = new ZipOutputStream(new FileOutputStream(baseFile));
			archive(outZip, baseFile, file);
		} catch ( Exception e ) {
			// ZIP圧縮失敗
			return false;
		} finally {
			// ZIPエントリクローズ
			if ( outZip != null ) {
				try { outZip.closeEntry(); } catch (Exception e) {}
				try { outZip.flush(); } catch (Exception e) {}
				try { outZip.close(); } catch (Exception e) {}
			}
		}
		return true;
	}
	/**
	 * 指定された ArrayList のファイルを ZIP アーカイブし、指定されたパスに作成します。
	 * デフォルト文字コードは Shift_JIS ですので、日本語ファイル名も対応できます。
	 *
	 * @param filePath 圧縮後のファイル名をフルパスで指定 ( 例: C:/sample.zip )
	 * @param fileList 圧縮するファイルリスト  ( 例; {C:/sample1.txt, C:/sample2.txt} )
	 * @return 処理結果 true:圧縮成功 false:圧縮失敗
	 */
	public boolean compressFileList( String filePath, ArrayList<String> fileList ) {
		ZipOutputStream outZip = null;
		File baseFile = new File(filePath);
		try {
			// ZIPファイル出力オブジェクト作成
			outZip = new ZipOutputStream(new FileOutputStream(baseFile));
			// 圧縮ファイルリストのファイルを連続圧縮
			for ( int i = 0 ; i < fileList.size() ; i++ ) {
				// ファイルオブジェクト作成
				File file = new File((String)fileList.get(i));
				archive(outZip, baseFile, file, file.getName(), "Shift_JIS");
			}
		} catch ( Exception e ) {
			// ZIP圧縮失敗
			return false;
		} finally {
			// ZIPエントリクローズ
			if ( outZip != null ) {
				try { outZip.closeEntry(); } catch (Exception e) {}
				try { outZip.flush(); } catch (Exception e) {}
				try { outZip.close(); } catch (Exception e) {}
			}
		}
		return true;
	}

	/**
	 * ディレクトリ圧縮のための再帰処理
	 *
	 * @param outZip ZipOutputStream
	 * @param baseFile File 保存先ファイル
	 * @param file File 圧縮したいファイル
	 */
	private void archive(ZipOutputStream outZip, File baseFile, File targetFile) {
		if ( targetFile.isDirectory() ) {
			File[] files = targetFile.listFiles();
			for (File f : files) {
				if ( f.isDirectory() ) {
					archive(outZip, baseFile, f);
				} else {
					if ( !f.getAbsoluteFile().equals(baseFile)  ) {
						// 圧縮処理
						archive(outZip, baseFile, f, f.getAbsolutePath().replace(baseFile.getParent(), "").substring(1), "Shift_JIS");
					}
				}
			}
		}
	}

	/**
	 * 圧縮処理
	 *
	 * @param outZip ZipOutputStream
	 * @param baseFile File 保存先ファイル
	 * @param targetFile File 圧縮したいファイル
	 * @parma entryName 保存ファイル名
	 * @param enc 文字コード
	 */
	private boolean archive(ZipOutputStream outZip, File baseFile, File targetFile, String entryName, String enc) {
		// 圧縮レベル設定
		outZip.setLevel(5);

		// 文字コードを指定
		//outZip.setEncoding(enc);
		try {

			// ZIPエントリ作成
			outZip.putNextEntry(new ZipEntry(entryName));

			// 圧縮ファイル読み込みストリーム取得
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(targetFile));

			// 圧縮ファイルをZIPファイルに出力
			int readSize = 0;
			byte buffer[] = new byte[1024]; // 読み込みバッファ
			while ((readSize = in.read(buffer, 0, buffer.length)) != -1) {
				outZip.write(buffer, 0, readSize);
			}
			// クローズ処理
			in.close();
			// ZIPエントリクローズ
			outZip.closeEntry();
		} catch ( Exception e ) {
			// ZIP圧縮失敗
			System.out.println(e);
			return false;
		}
		return true;
	}



}
