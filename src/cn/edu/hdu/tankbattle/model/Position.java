package cn.edu.hdu.tankbattle.model;

public class Position {
	private int _x = 0;
	private int _y = 0;
	
	public Position(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void setX(int x) {
		this._x = x;
	}
	public int getX() {
		return this._x;
	}
	
	public void setY(int y) {
		this._y = y;
	}
	public int getY() {
		return this._y;
	}
}
