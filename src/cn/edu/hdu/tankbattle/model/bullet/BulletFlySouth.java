package cn.edu.hdu.tankbattle.model.bullet;

public class BulletFlySouth implements IBulletFly{
	public void bulletFly(Bullet bullet) {
		bullet.setY(bullet.getY() + bullet.getSpeed());
	}
}
