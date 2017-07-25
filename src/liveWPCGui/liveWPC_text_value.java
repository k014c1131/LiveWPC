package liveWPCGui;

import java.awt.Color;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class liveWPC_text_value {
	int x;
	int y;
	int width;
	int height;
	Color color;
	String imagepath;
	String type;
	String textstring;

	@JsonCreator
	public liveWPC_text_value(@JsonProperty("x") int x,@JsonProperty("y") int y,@JsonProperty("width") int width,@JsonProperty("height")int height,@JsonProperty("ImagePath") String imagepath,@JsonProperty("type") String type,@JsonProperty("String") String textstring){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setImagepath(imagepath);
		setType(type);
		setTextString(textstring);
	}
	/*@JsonCreator
	public liveWPC_text_value(@JsonProperty("x") int x,@JsonProperty("y") int y,@JsonProperty("width") int width,@JsonProperty("height")int height,@JsonProperty("String") String textstring,@JsonProperty("type") String type){
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setString(textstring);
		setType(type);
	}*/

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
	public void setImagepath(String imagepath){
		this.imagepath=imagepath;
	}
	public void setType(String type){
		this.type =type;
	}
	public void setTextString(String textstring){
		this.textstring=textstring;
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
	public String getImagepath(){
		return imagepath;
	}
	public String getType(){
		return type;
	}
	public String getTextString(){
		return textstring;
	}
	public String toString(){
		return x+" "+y+" "+width+" "+height+" "+imagepath+" "+type+" "+height+" "+textstring;
	}


}
