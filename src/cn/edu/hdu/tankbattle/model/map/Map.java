package cn.edu.hdu.tankbattle.model.map;

import java.util.Vector;

import cn.edu.hdu.tankbattle.model.Brick;
import cn.edu.hdu.tankbattle.model.Iron;
import cn.edu.hdu.tankbattle.model.Water;

/**
 * 游戏地图
 * 
 * @author 1052067939
 *
 */
public abstract class Map {
	protected Vector<Brick> bricks;
	protected Vector<Iron> irons;
	protected Vector<Water> waters;

	public Map() {
		bricks = new Vector<Brick>();
		irons = new Vector<Iron>();
		waters = new Vector<Water>();
		this.initMaps();
	}
	
	public abstract void initBricks();
	public abstract void initIron();
	public abstract void initWater();
	
	public void initMaps() {
		this.initBricks();
		this.initIron();
		this.initWater();
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
}
