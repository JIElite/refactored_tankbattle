package cn.edu.hdu.tankbattle.model;


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
		setType(Stuff.WATER);
		setWidth(20);
		setHeight(20);
	}

}
