/**
 * 第一关地图
 */
package cn.edu.hdu.tankbattle.model.map;

import cn.edu.hdu.tankbattle.model.Position;

import java.util.Vector;

/**
 * 第一关地图类
 * 
 * @author 1052067939
 * @since JavaSe-1.6
 */
public class Map1 extends Map {
	
	@Override 
	public void initBricks() {
		Vector<Position> positions = new Vector<Position>();
		
		for (int i = 0; i < 30; i++) {
			if (i % 2 == 0)
				continue;
			positions.add(new Position(20*i+10, 470));
		}
		positions.add(new Position(200, 290));
		positions.add(new Position(220, 290));
		positions.add(new Position(200, 310));
		positions.add(new Position(220, 310));
		
		this.initStuff(0, positions);
	}
	
	@Override
	public void initWater() {
		Vector<Position> positions = new Vector<Position>();
		
		for (int i = 0; i < 25; i++) {
			positions.add(new Position(20*i + 60, 130));
		}
		for (int i = 8; i < 15; i++) {
			positions.add(new Position(100, 20*i+120));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			positions.add(new Position(20*i+60, 60));
		}
		positions.add(new Position(380, 290));
		positions.add(new Position(400, 290));
		positions.add(new Position(380, 310));
		positions.add(new Position(400, 310));
		
		this.initStuff(2, positions);
	}
	
	@Override
	public void initIron() {
		Vector<Position> positions = new Vector<Position>();
		
		for (int i = 0; i < 29; i++) {
			if (i % 2 == 0 || i % 3 == 0)
				continue;
			positions.add(new Position(20*i+10, 540));
		}
		for (int i = 0; i < 27; i++) {
			if (i % 3 == 0)
				continue;
			if (i >= 10 && i <= 15)
				continue;
			positions.add(new Position(20*i-10, 200));
		}
		positions.add(new Position(10, 540));
		positions.add(new Position(230, 150));
		positions.add(new Position(230, 170));
		positions.add(new Position(290, 200));
		positions.add(new Position(290, 290));
		positions.add(new Position(310, 290));
		positions.add(new Position(290, 310));
		positions.add(new Position(310, 310));
		positions.add(new Position(590, 400));
		positions.add(new Position(570, 400));
		
		this.initStuff(1, positions);
	}
}
