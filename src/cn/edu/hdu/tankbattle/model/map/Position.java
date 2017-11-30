package cn.edu.hdu.tankbattle.model.map;

public class Position {
	private int x;
	private int y;
	public Position(int x, int y) {
		this.setPosition(x, y);
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
}
