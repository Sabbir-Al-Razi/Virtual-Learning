package dev.tilegame.gfx;


import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int width=32,height=32;
	
	public static Font font28;
	
	public static BufferedImage dirt,grass,stone,tree,odd , e ,i ,b , c, d,f, n3 , n5 ;
	public static BufferedImage vowel;
	public static BufferedImage od,vo,co;
	public static BufferedImage[] player_down, player_up, player_left, player_right ;
	public static BufferedImage[] zombie_down, zombie_up, zombie_left, zombie_right;
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;
	
	public static void init()  
	{
		font28 = FontLoader.loadFont("Resource/fonts/slkscr.ttf", 28);
		
		SpriteSheet sheet=new SpriteSheet(ImageLoader.loadimage("/textures/sheet.png"));
	  
		inventoryScreen = ImageLoader.loadimage("/textures/inventoryScreen.png");
		
		vowel=sheet.crop(width * 2, height, width, height);
		//odd r soto version
		
		od=sheet.crop(width, height, width, height);
		
		//consonent
		co=sheet.crop(width, height, width, height);
		
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
		btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
		
		player_down =new BufferedImage[2];
		player_up =new BufferedImage[2];
		player_left =new BufferedImage[2];
		player_right =new BufferedImage[2];
		
		player_down[0] = sheet.crop(width * 4 , 0, width ,height);
		player_down[1] = sheet.crop(width * 5 , 0, width ,height);
		player_up[0] = sheet.crop(width * 6 , 0, width ,height);
		player_up[1] = sheet.crop(width * 7 , 0, width ,height);
		player_right[0] = sheet.crop(width * 4 , height, width ,height);
		player_right[1] = sheet.crop(width * 5 , height, width ,height);
		player_left[0] = sheet.crop(width * 6 , height, width ,height);
		player_left[1] = sheet.crop(width * 7 , height, width ,height);
		
		
		zombie_down = new BufferedImage[2];
		zombie_up = new BufferedImage[2];
		zombie_left = new BufferedImage[2];
		zombie_right = new BufferedImage[2];
		
		zombie_down[0] = sheet.crop(width * 4, height * 2, width, height);
		zombie_down[1] = sheet.crop(width * 5, height * 2, width, height);
		zombie_up[0] = sheet.crop(width * 6, height * 2, width, height);
		zombie_up[1] = sheet.crop(width * 7, height * 2, width, height);
		zombie_right[0] = sheet.crop(width * 4, height * 3, width, height);
		zombie_right[1] = sheet.crop(width * 5, height * 3, width, height);
		zombie_left[0] = sheet.crop(width * 6, height * 3, width, height);
		zombie_left[1] = sheet.crop(width * 7, height * 3, width, height);

		dirt=sheet.crop(width,0,width,height);
		grass=sheet.crop(width *2,0,width,height);
		stone=sheet.crop(width * 3,0,width,height);
		tree=sheet.crop(0, 0, width, height * 2);
	    //avabe jekono letter dite parbo  
	    e=sheet.crop(0, height*5, width, height );
	    i=sheet.crop(0, height*6, width, height );
		odd = sheet.crop(0, height * 2, width, height);
		n3 = sheet.crop(0, height * 3, width, height);
		n5 = sheet.crop(0, height * 4, width, height);
		od = sheet.crop(width * 1, height * 2, width , height);
		vo = sheet.crop(width * 1, height * 1, width *2 , height);
		co = sheet.crop(width * 1, height * 4, width *4 , height);
		b= sheet.crop(0, height * 7, width  , height);
		c= sheet.crop(width *1, height * 3, width  , height);
		d= sheet.crop(width *2, height * 3, width  , height);
		f= sheet.crop(width *3, height * 3, width  , height);
		
	}

}
