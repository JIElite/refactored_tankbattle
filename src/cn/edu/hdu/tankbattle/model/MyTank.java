package cn.edu.hdu.tankbattle.model;

import java.awt.Color;
import java.awt.Image;
import java.util.Vector;


/**
 * 我的坦克类，继承自坦克类
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 */
public class MyTank extends Tank  {
	/**
	 * 构造方法
	 * 
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @param direct
	 *            方向
	 */
	public MyTank(Position p, int direct) {
		super(p, direct);
		hp_color = Color.green;
		setHealthPoint(10);
	}

	/**
	 * 判断是否重叠
	 * 
	 * @param enemys
	 *            敌人坦克容量
	 * @return 是否重叠
	 */
	public boolean isOverlap_(Vector<EnemyTank> enemys) {
		for (int i = 0; i < enemys.size(); i++) { // 依次取出每个敌人坦克
			if (Overlap(enemys.get(i), 40) == true)// 如果这两辆坦克重叠
				return true; // 则返回真
		}
		return false; // 不重叠返回假
	}
	
	public Image getImage() {
		return TankGameImages.myTankImg[getDirect()];
	}
	
}