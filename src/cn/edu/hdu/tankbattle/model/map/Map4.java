package cn.edu.hdu.tankbattle.model.map;

import cn.edu.hdu.tankbattle.model.Water;

public class Map4 extends Map {
	
	public void initBricks() {
		
	}
	
	public void initIron() {
		
	}

	public void initWater() {
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			waters.add(new Water(20 * i + 60, 60));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			waters.add(new Water(20 * i + 60, 460));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			waters.add(new Water(20 * i + 60, 140));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			waters.add(new Water(20 * i + 60, 540));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			waters.add(new Water(60, 20 * i + 60));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			waters.add(new Water(540, 20 * i + 60));
		}
		waters.add(new Water(290, 290));
		waters.add(new Water(310, 290));
		waters.add(new Water(290, 310));
		waters.add(new Water(310, 310));
	}
}
