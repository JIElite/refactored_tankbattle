package cn.edu.hdu.tankbattle.model;

import cn.edu.hdu.tankbattle.constant.StuffType;

/**
 * 砖块类，由东西类继承而来
 * 
 * @author 1052067939
 * @version 1.0
 * @since Java-1.6
 *
 */
public class Brick extends Stuff {
	public Brick(Position p) {
		super(p);
		setType(StuffType.BRICK);
		setWidth(20);
		setHeight(20);
	}
}
