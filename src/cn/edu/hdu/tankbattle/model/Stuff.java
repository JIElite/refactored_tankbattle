package cn.edu.hdu.tankbattle.model;


/**
 * 东西类，简单的一个对象
 * <p>
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public class Stuff {
	private Position position;
	private int width;
	private int height;
	private int type;
	private boolean isLive;

	public Stuff(Position p) {
		this.position = p;
		this.isLive = true;
	}

	public int getX() {
		return this.position.getX();
	}

	public void setX(int x) {
		this.position.setX(x);
	}

	public int getY() {
		return this.position.getY();
	}

	public void setY(int y) {
		this.position.setY(y);
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
