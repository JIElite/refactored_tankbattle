package cn.edu.hdu.tankbattle.model.map;

import cn.edu.hdu.tankbattle.model.Iron;

public class Map2 extends Map {
	public void initBricks() {
		
	}
	
	public void initIron() {
		for (int i = 0; i < 25; i++) {
			if (i % 2 == 0)
				continue;
			if (i == 11 || i == 12 || i == 13)
				continue;
			irons.add(new Iron(20*i+60, 60));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			irons.add(new Iron(20*i+60, 540));
		}
		for (int i = 0; i < 25; i++) {
			if (i % 2 == 0)
				continue;
			if (i == 11 || i == 12 || i == 13)
				continue;
			irons.add(new Iron(60, 20*i+60));
		}
		for (int i = 0; i < 25; i++) {
			if (i % 2 == 0)
				continue;
			if (i == 11 || i == 12 || i == 13)
				continue;
			irons.add(new Iron(540, 20*i+60));
		}
		irons.add(new Iron(290, 290));
		irons.add(new Iron(310, 290));
		irons.add(new Iron(290, 310));
		irons.add(new Iron(310, 310));
	}
	
	public void initWater() {
		
	}
}
