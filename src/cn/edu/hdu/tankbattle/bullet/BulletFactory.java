package cn.edu.hdu.tankbattle.bullet;

import cn.edu.hdu.tankbattle.constant.Direction;
import cn.edu.hdu.tankbattle.model.Tank;

public class BulletFactory {
	public Bullet makeBullet(Tank tank) {
		Bullet bullet;
		
		switch(tank.getDirect()) {
		case Direction.NORTH:
			bullet = new Bullet(tank.getX(), tank.getY() - 20, new BulletFlyNorth());
			break;
		case Direction.SOUTH:
			bullet = new Bullet(tank.getX(), tank.getY() + 20, new BulletFlySouth());
			break;
		case Direction.EAST:
			bullet = new Bullet(tank.getX() + 20, tank.getY(), new BulletFlyEast());
			break;
		case Direction.WEST:
			bullet = new Bullet(tank.getX() - 20, tank.getY(), new BulletFlyWest());
			break;
		default:
			bullet = null;
		}
		return bullet;
	}
}
