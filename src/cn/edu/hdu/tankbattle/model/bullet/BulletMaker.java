package cn.edu.hdu.tankbattle.model.bullet;

import cn.edu.hdu.tankbattle.model.Tank;

public class BulletMaker {
	private BulletFlyBehaviorFactory flyFactory;
	
	public BulletMaker() {
		flyFactory = new BulletFlyBehaviorFactory();
	}
	
	public Bullet makeBullet(Tank tank) {
		IBulletFly flybehavior = this.flyFactory.makeFlyBehavior(tank.getDirect());
		Bullet bullet = new Bullet(tank.getMuzzleX(), tank.getMuzzleY(), flybehavior);
		return bullet;
	}
}
