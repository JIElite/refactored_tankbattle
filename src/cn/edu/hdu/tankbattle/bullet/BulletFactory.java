package cn.edu.hdu.tankbattle.bullet;

import cn.edu.hdu.tankbattle.model.Tank;

public class BulletFactory {
	private BulletFlyBehaviorFactory _flyFactory;
	
	public BulletFactory() {
		this._flyFactory = new BulletFlyBehaviorFactory();
	}
	
	public Bullet makeBullet(Tank tank) {
		IBulletFly flybehavior = this._flyFactory.makeFlyBehavior(tank.getDirect());
		Bullet bullet = new Bullet(tank.getMuzzleX(), tank.getMuzzleY(), flybehavior);
		return bullet;
	}
}
