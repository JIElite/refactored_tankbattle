package cn.edu.hdu.tankbattle.bullet;

public class SouthBullet extends Bullet{
	public SouthBullet(int x, int y) {
		super(x, y+20);
	}

	public void bulletFly() {
		this.setY(this.getY() + this.getSpeed());
	}
}
