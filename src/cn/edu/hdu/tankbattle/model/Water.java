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
	/**
	 * 构造方法
	 * 
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 */
	public Water(int x, int y) {
		super(x, y);
		this.setType(StuffType.WATER);
		this.setWidth(20);
		this.setHeight(20);
	}

}
