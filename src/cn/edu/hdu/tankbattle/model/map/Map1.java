/**
 * 第一关地图
 */
package cn.edu.hdu.tankbattle.model.map;

import cn.edu.hdu.tankbattle.model.Brick;
import cn.edu.hdu.tankbattle.model.Iron;
import cn.edu.hdu.tankbattle.model.Water;

/**
 * 第一关地图类
 * 
 * @author 1052067939
 * @since JavaSe-1.6
 */
public class Map1 extends Map {
			
	public void initBricks() {
		for (int i = 0; i < 30; i++) {
			if (i % 2 == 0)
				continue;
			bricks.add(new Brick(20*i+10, 470));
		}
		bricks.add(new Brick(200, 290));
		bricks.add(new Brick(220, 290));
		bricks.add(new Brick(200, 310));
		bricks.add(new Brick(220, 310));
	}
	
	public void initWater() {
		for (int i = 0; i < 25; i++) {
			waters.add(new Water(20*i + 60, 130));
		}
		for (int i = 8; i < 15; i++) {
			waters.add(new Water(100, 20*i+120));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			waters.add(new Water(20*i+60, 60));
		}
		waters.add(new Water(380, 290));
		waters.add(new Water(400, 290));
		waters.add(new Water(380, 310));
		waters.add(new Water(400, 310));
	}
	
	public void initIron() {
		for (int i = 0; i < 29; i++) {
			if (i % 2 == 0 || i % 3 == 0)
				continue;
			irons.add(new Iron(20*i+10, 540));
		}
		for (int i = 0; i < 27; i++) {
			if (i % 3 == 0)
				continue;
			if (i >= 10 && i <= 15)
				continue;
			irons.add(new Iron(20*i-10, 200));
		}
		irons.add(new Iron(10, 540));
		irons.add(new Iron(230, 150));
		irons.add(new Iron(230, 170));
		irons.add(new Iron(290, 200));
		irons.add(new Iron(290, 290));
		irons.add(new Iron(310, 290));
		irons.add(new Iron(290, 310));
		irons.add(new Iron(310, 310));
		irons.add(new Iron(590, 400));
		irons.add(new Iron(570, 400));

	}
}
