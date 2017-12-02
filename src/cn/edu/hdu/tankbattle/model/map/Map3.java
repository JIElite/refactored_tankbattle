package cn.edu.hdu.tankbattle.model.map;

import cn.edu.hdu.tankbattle.model.Brick;


public class Map3 extends Map {
	
	@Override
	public void initBricks() {
		for (int i = 0; i < 25; i++) {
			bricks.add(new Brick(20 * i + 60, 60));
		}
		for (int i = 0; i < 25; i++) {
			bricks.add(new Brick(20 * i + 60, 140));
		}
		for (int i = 0; i < 25; i++) {
			bricks.add(new Brick(20 * i + 60, 220));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			bricks.add(new Brick(20 * i + 60, 460));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			bricks.add(new Brick(20 * i + 60, 540));
		}
		for (int i = 0; i < 25; i++) {
			bricks.add(new Brick(60, 20 * i + 60));
		}
		for (int i = 0; i < 25; i++) {
			bricks.add(new Brick(540, 20 * i + 60));
		}
		bricks.add(new Brick(290, 290));
		bricks.add(new Brick(310, 290));
		bricks.add(new Brick(290, 310));
		bricks.add(new Brick(310, 310));
	}
	
}