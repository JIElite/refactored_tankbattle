package cn.edu.hdu.tankbattle.model;


/**
 * 铁块类，继承自东西类
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public class Iron extends Stuff {

	public Iron(Position p) {
		super(p);
		setType(Stuff.IRON);
		setWidth(20);
		setHeight(20);
	}

}
