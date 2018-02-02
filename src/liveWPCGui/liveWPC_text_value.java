package liveWPCGui;

import java.awt.Color;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class liveWPC_text_value {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private String imagepath;
	private String type;
	private String textstring;
	private int layer; //レイヤーの位置を保持する
	private boolean action;	//アクショントリガーの有無を判別する
	private String animename;	//アニメーションの種類
	private int animetime;	//アニメーションの時間を設定
	private int animespeed;	//アニメーションの速度を設定
	private String figuretype;
	private int animerotate,animewidth,animeheight,animealpha,animex,animey;
	private int itemindex;
	@JsonCreator
	public liveWPC_text_value(@JsonProperty("x") int x,@JsonProperty("y") int y,@JsonProperty("width") int width,@JsonProperty("height")int height,@JsonProperty("ImagePath") String imagepath,@JsonProperty("type") String type,@JsonProperty("String") String textstring,@JsonProperty("layer") int layer
			,@JsonProperty("figuretype") String figuretype,@JsonProperty("animename") String animename
			,@JsonProperty("animealpha")int animealpha,@JsonProperty("animespeed")int animespeed
			,@JsonProperty("animex")int animex,@JsonProperty("animey")int animey
			,@JsonProperty("animerotate")int animerotate,@JsonProperty("animeawidth")int animewidth
			,@JsonProperty("animeheight")int animeheight,@JsonProperty("color")Color color
			,@JsonProperty("itemindex")int itemindex){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setImagepath(imagepath);
		setType(type);
		setTextString(textstring);
		setLayer(layer);
		setFigure(figuretype);
		setAnimeName(animename);
		setAnimeAlpha(animealpha);
		setAnimeSpeed(animespeed);
		setAnimeX(animex);
		setAnimeY(animey);
		setAnimeRotate(animerotate);
		setAnimeWidth(animewidth);
		setAnimeHeight(animeheight);
		setItemIndex(itemindex);
		setColor(color);
	}

	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public void setWidth(int width){
		this.width=width;
	}
	public void setHeight(int height){
		this.height=height;
	}
	public void setColor(Color color){
		this.color=color;
	}
	public void setImagepath(String imagepath){
		this.imagepath=imagepath;
	}
	public void setType(String type){
		this.type =type;
	}
	public void setTextString(String textstring){
		this.textstring=textstring;
	}
	public void setAction(boolean action){
		this.action=action;
	}
	public void setAnimeName(String animename){
		this.animename=animename;
	}
	public void setAnimeTime(int animetime){
		this.animetime=animetime;
	}
	public void setAnimeSpeed(int animespeed){
		this.animespeed=animespeed;
	}
	public void setLayer(int layer){
		this.layer=layer;
	}
	public void setFigure(String figuretype){
		this.figuretype=figuretype;
	}
	public void setAnimeAlpha(int animealpha){
		this.animealpha=animealpha;
	}
	public void setAnimeX(int animex){
		this.animex=animex;
	}
	public void setAnimeY(int animey){
		this.animey=animey;
	}
	public void setAnimeRotate(int animerotate){
		this.animerotate=animerotate;
	}
	public void setAnimeWidth(int animewidth){
		this.animewidth=animewidth;
	}
	public void setAnimeHeight(int animeheight){
		this.animeheight=animeheight;
	}
	public void setItemIndex(int itemindex){
		this.itemindex=itemindex;
	}


	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public Color getColor(){
		return color;
	}
	public String getImagepath(){
		return imagepath;
	}
	public String getType(){
		return type;
	}
	public String getTextString(){
		return textstring;
	}
	public Boolean getAction(){
		return action;
	}
	public String getAnimeName(){
		return animename;
	}
	public int getAnimeTime(){
		return animetime;
	}
	public int getAnimeSpeed(){
		return animespeed;
	}
	public int getLayer(){
		return layer;
	}
	public String getFigure(){
		return figuretype;
	}
	public int getAnimeAlpha(){
		return animealpha;
	}
	public int getAnimeX(){
		return animex;
	}
	public int getAnimeY(){
		return animey;
	}
	public int getAnimeRotate(){
		return animerotate;
	}
	public int getAnimeWidth(){
		return animewidth;
	}
	public int getAnimeHeight(){
		return animeheight;
	}
	public int getItemIndex(){
		return itemindex;
	}



	public String toString(){
		return x+" "+y+" "+width+" "+height+" "+imagepath+" "+type+" "+height+" "+textstring;
	}


}
