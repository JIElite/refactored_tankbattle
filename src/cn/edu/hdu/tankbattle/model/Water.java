package cn.edu.hdu.tankbattle.model;

import cn.edu.hdu.tankbattle.constant.StuffType;

/**
 * 水对象，继承自东西类
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public class Water extends Stuff {
	
	public Water(Position p) {
		super(p);
		this.setType(StuffType.WATER);
		this.setWidth(20);
		this.setHeight(20);
	}

}
