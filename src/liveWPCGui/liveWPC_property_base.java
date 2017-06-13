package liveWPCGui;

public interface liveWPC_property_base{
	//初期値
	public static final int DEFAULT_NUMBER = 0;

	//カラーパレットを表示する
	//図形、文字列共通
	public default void color_settings(){}


	//透過度のパレットを表示する
	//図形、文字列共通

	public default void ganma_settings(){}


	//スライダーを表示する
	//図形、文字列共通
	//引数:スライダーのタイプ(透過度、アニメーションの速度、図形やフォントのサイズ…など)

	public default void size_settings(int type,int geometry_number){}


	//フォントを設定する
	//テキスト限定
	//引数:フォント名
	public default void font_settings(String font_name){}


	//フォントサイズ指定を表示するメソッド。
	//テキスト限定
	//引数:指定するフォントが入ったテキストのオブジェクト
	//public default void fontsize_settings(object obj){}

	//アクショントリガー、アニメーショントリガー利用の有無チェックボックス
	//図形、文字列共通
	//引数:どちらのトリガーかを判別するための数

	public default void trigger_check(int checker){}


	//アニメーションの選択プルダウンを表示
	//引数:アニメーションの番号

	public default void animation_settings(){}


}

