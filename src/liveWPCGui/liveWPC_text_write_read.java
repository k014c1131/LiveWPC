package liveWPCGui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class liveWPC_text_write_read {//テキストファイルを書き出すためのクラス

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
	public void setList(ArrayList<liveWPC_create_object> list){//保存の下準備をするメソッド
		int i=0;
		writestr = "[\r\n";
		for(liveWPC_create_object co : list){
			i++;
			if((imagepath = co.getImagePath())!=null){
				imagelist.add(imagepath);//ファイルパスをもとに画像をコピー

				//System.out.println("yattaze"+co.getName());
			}
			System.out.println(imagelist);
			System.out.println(list.size());

			if((i)==list.size()){
				writestr = writestr+"\r\n"+co.returnValue()+"\r\n";
			}else {
				writestr = writestr+"\r\n"+co.returnValue()+",\r\n";
			}

		}
		writestr = writestr+"\r\n]";

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
	public File unzip( String zipFileFullPath, String unzipPath ) {

			File baseFile = new File(zipFileFullPath);
			File baseDir = new File(baseFile.getParent(), baseFile.getName().substring(0, baseFile.getName().lastIndexOf(".")));
			if ( !baseDir.mkdir() ){
				System.out.println("Couldn't create directory because directory with the same name exists.: " + baseDir);
			}
			ZipFile zipFile = null;
			try {
				// ZIPファイルオブジェクト作成
				zipFile = new ZipFile(zipFileFullPath);

				// ZIPファイル内のファイルを列挙
				Enumeration<? extends ZipEntry>  enumZip = zipFile.entries();

				// ZIPファイル内の全てのファイルを展開
				while ( enumZip.hasMoreElements() ) {

					// ZIP内のエントリを取得
					ZipEntry zipEntry = (java.util.zip.ZipEntry)enumZip.nextElement();

					//出力ファイル取得
					File unzipFile = new File(unzipPath);
					File outFile = new File(unzipFile.getAbsolutePath() + "/" + baseDir.getName(), zipEntry.getName());

					if ( zipEntry.isDirectory() )
						outFile.mkdir();
					else {
						// 圧縮ファイル入力ストリーム作成
						BufferedInputStream in = new BufferedInputStream(zipFile.getInputStream(zipEntry));

						// 親ディレクトリがない場合、ディレクトリ作成
						if ( !outFile.getParentFile().exists() )
							outFile.getParentFile().mkdirs();

						// 出力オブジェクト取得
						BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile));

						// 読み込みバッファ作成
						byte[] buffer = new byte[1024];

						// 解凍ファイル出力
						int readSize = 0;
						while ( (readSize = in.read(buffer)) != -1 ) {
							out.write(buffer, 0, readSize);
						}
						// クローズ
						try { out.close(); } catch (Exception e) {}
						try { in.close(); } catch (Exception e) {}
					}
				}
				// 解凍処理成功
				return baseDir;
			} catch(Exception e) {
				// エラーログ出力
				System.out.println(e.toString());
				// 解凍処理失敗
				return null;
			} finally {
				if ( zipFile != null )
					try { zipFile.close();    } catch (Exception e) {}
			}
		}
	public String readfile( String zipFileFullPath, String unzipPath ){

		try{
			File file = unzip(zipFileFullPath,unzipPath);
			//System.out.println(file);
			//System.out.println(Files.lines(Paths.get(file+"/text.txt"), Charset.forName("UTF-8"))
			//.collect(Collectors.joining(System.getProperty("line.separator"))));
			return Files.lines(Paths.get(file+"/"+file.getName()+"/text.txt"), Charset.forName("UTF-8"))
			.collect(Collectors.joining(System.getProperty("line.separator")));
		}catch(Exception e){
			System.out.println(e);
		}
		return null;


	}



}
