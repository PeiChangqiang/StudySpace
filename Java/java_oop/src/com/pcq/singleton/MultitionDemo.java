package com.pcq.singleton;

/**
 * ¶àÀýÄ£Ê½
 * @author Administrator
 *
 */
public class MultitionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  Color c = Color.getInstance("blue");
	  System.out.println(c);

	}

}


class Color {
	private static final Color RED = new Color("ºì");
	private static final Color GREEN = new Color("ÂÌ");
	private static final Color BLUE = new Color("À¶");
	private String title;
	
	private Color(String title) {
		this.title = title;
	}
	
	public static Color getInstance(String color) {
		switch(color) {
		case "red" : return RED;
		case "green" : return GREEN;
		case "blue" : return BLUE;
		default : return null;
		}
	}
	
	public String toString() {
		return this.title;
	}
}