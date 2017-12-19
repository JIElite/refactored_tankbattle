package cn.edu.hdu.tankbattle.model.bullet;

import cn.edu.hdu.tankbattle.constant.Direction;


public class BulletFlyBehaviorFactory {
	public IBulletFly makeFlyBehavior(int direction) {
		IBulletFly flyBehavior;

		switch(direction) {
		case Direction.NORTH:
			flyBehavior = new BulletFlyNorth();
			break;
		case Direction.SOUTH:
			flyBehavior = new BulletFlySouth();
			break;
		case Direction.EAST:
			flyBehavior = new BulletFlyEast();
			break;
		case Direction.WEST:
		    flyBehavior = new BulletFlyWest();
			break;
		default:
			flyBehavior = null;
		}
		return flyBehavior;
	}

}
