package cn.edu.hdu.tankbattle.model;

import cn.edu.hdu.tankbattle.constant.StuffType;

/**
 * 铁块类，继承自东西类
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public class Iron extends Stuff {

	public Iron(int x, int y) {
		super(x, y);
		this.setType(StuffType.IRON);
		this.setWidth(20);
		this.setHeight(20);
	}

}
