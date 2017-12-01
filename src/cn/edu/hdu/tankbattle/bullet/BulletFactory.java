package cn.edu.hdu.tankbattle.bullet;

import cn.edu.hdu.tankbattle.constant.Direction;
import cn.edu.hdu.tankbattle.model.Tank;

public class BulletFactory {
	public Bullet makeBullet(Tank tank) {
		Bullet bullet;
		
		switch(tank.getDirect()) {
		case Direction.NORTH:
			bullet = new NorthBullet(tank.getX(), tank.getY());
			break;
		case Direction.SOUTH:
			bullet = new SouthBullet(tank.getX(), tank.getY());
			break;
		case Direction.EAST:
			bullet = new EastBullet(tank.getX(), tank.getY());
			break;
		case Direction.WEST:
			bullet = new WestBullet(tank.getX(), tank.getY());
			break;
		default:
			bullet = null;
		}
		return bullet;
	}
}
