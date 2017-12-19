package cn.edu.hdu.tankbattle.model.bullet;

public class BulletFlyWest implements IBulletFly{
	public void bulletFly(Bullet bullet) {
		bullet.setX(bullet.getX() - bullet.getSpeed());
	}
}
