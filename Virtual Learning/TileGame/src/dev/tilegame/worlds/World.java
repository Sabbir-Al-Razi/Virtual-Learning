package dev.tilegame.worlds;

import java.awt.Graphics;

import dev.tilegame.Handler;
import dev.tilegame.entities.EntityManager;
import dev.tilegame.entities.creatures.Player;
import dev.tilegame.entities.statics.B;
import dev.tilegame.entities.statics.C;
import dev.tilegame.entities.statics.D;
import dev.tilegame.entities.statics.E;
import dev.tilegame.entities.statics.F;
import dev.tilegame.entities.statics.I;
import dev.tilegame.entities.statics.N3;
import dev.tilegame.entities.statics.N5;
import dev.tilegame.entities.statics.N1;
import dev.tilegame.entities.statics.A;
import dev.tilegame.items.ItemManager;
import dev.tilegame.tiles.Tile;
import dev.tilegame.utils.Utils;

public class World {
	private Handler handler;
	private int width , height;
	private int spawnX, spawnY; 
	private int [][] tiles ;
    
	//Entities
	private EntityManager entityManager;
	
	//Items
	private ItemManager itemManager;
	
	public World(Handler handler ,String path) {
		this.handler = handler;
		entityManager =new EntityManager(handler,new Player(handler,100,100));
		itemManager= new ItemManager(handler);
		//Temporary entity code
		entityManager.addEntity(new A(handler,960,750));
		entityManager.addEntity(new N1(handler,450,1090));
		entityManager.addEntity(new E(handler,600,550));
		entityManager.addEntity(new I(handler,800,200));
		entityManager.addEntity(new N3(handler,250,200));
		entityManager.addEntity(new N5(handler,450,500));
		entityManager.addEntity(new B(handler,500,100));
		entityManager.addEntity(new C(handler,250,900));
		entityManager.addEntity(new D(handler, 570,1020));
		entityManager.addEntity(new F(handler, 840,900));
		
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick() {
		 itemManager.tick();
		 entityManager.tick();
		
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}