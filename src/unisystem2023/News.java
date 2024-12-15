package unisystem2023;

import java.io.Serializable;
import java.util.Objects;

import main.Database;


public class News implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private String theme;

	{
		Database.getInstance().addNews(this);
	}
	
	public News(){
		super();
	}

	public News(String theme, String text){
		setTheme(theme);
		setText(text);
	}

	public void setText(String text) {
		this.text = text;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getText() {
		return text;
	}
	public String getTheme() {
		return theme;
	}
	public int hashCode() {
		return Objects.hash(text, theme);
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		News other = (News) obj;
		return Objects.equals(text, other.text) && Objects.equals(theme, other.theme);
	}
	public String toString() {
		return theme + "\n" + text;
	}
}

