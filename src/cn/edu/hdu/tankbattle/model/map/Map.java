package cn.edu.hdu.tankbattle.model.map;

import java.util.Vector;

import cn.edu.hdu.tankbattle.model.Brick;
import cn.edu.hdu.tankbattle.model.Iron;
import cn.edu.hdu.tankbattle.model.Position;
import cn.edu.hdu.tankbattle.model.Stuff;
import cn.edu.hdu.tankbattle.model.Water;

/**
 * 游戏地图
 * 
 * @author 1052067939
 *
 */
public class Map {
	protected Vector<Brick> bricks = new Vector<Brick>();
	protected Vector<Iron> irons = new Vector<Iron>();
	protected Vector<Water> waters = new Vector<Water>();

	public Map() {
		initMaps();
	}
	
	public void initMaps() {
		initBricks();
		initIron();
		initWater();
	}
	
	public void initBricks() {}
	public void initIron() {}
	public void initWater() {}
	
	
	public void initStuff(int stuffType, Vector<Position> positions) {
		for(int i = 0; i < positions.size(); i++) {
			
			if (stuffType == 0) {
				this.bricks.add(new Brick(positions.get(i)));
			} else if (stuffType == 1) {
				this.irons.add(new Iron(positions.get(i)));
			} else if (stuffType ==  2) {
				this.waters.add(new Water(positions.get(i)));
			}
			
		}
	}
	public Vector<Brick> getBricks() {
		return bricks;
	}
	
	public void setBricks(Vector<Brick> bricks) {
		this.bricks = bricks;
	}
	
	public Vector<Iron> getIrons() {
		return irons;
	}
	public void setIrons(Vector<Iron> irons) {
		this.irons = irons;
	}
	
	public Vector<Water> getWaters() {
		return waters;
	}
	public void setWaters(Vector<Water> waters) {
		this.waters = waters;
	}
	
	public Vector<Stuff> getMapStuffs() {
		Vector<Stuff> stuffs = new Vector<Stuff>();
		
		for (int i = 0; i < bricks.size(); i++) {
			stuffs.add(bricks.get(i));
		}
		for (int j = 0; j < waters.size(); j++) {
			stuffs.add(waters.get(j));
		}
		for (int k = 0; k < irons.size(); k++) {
			stuffs.add(irons.get(k));
		}
		return stuffs;
	}
}
