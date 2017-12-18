package cn.edu.hdu.tankbattle.model.map;

import java.util.Vector;

import cn.edu.hdu.tankbattle.constant.StuffType;
import cn.edu.hdu.tankbattle.model.Position;


public class Map2 extends Map {
	
	@Override
	public void initIron() {
		Vector<Position> positions = new Vector<Position>();
		
		for (int i = 0; i < 25; i++) {
			if (i % 2 == 0)
				continue;
			if (i == 11 || i == 12 || i == 13)
				continue;
			positions.add(new Position(20*i+60, 60));
		}
		for (int i = 0; i < 25; i++) {
			if (i == 11 || i == 12 || i == 13)
				continue;
			positions.add(new Position(20*i+60, 540));
		}
		for (int i = 0; i < 25; i++) {
			if (i % 2 == 0)
				continue;
			if (i == 11 || i == 12 || i == 13)
				continue;
			positions.add(new Position(60, 20*i+60));
		}
		for (int i = 0; i < 25; i++) {
			if (i % 2 == 0)
				continue;
			if (i == 11 || i == 12 || i == 13)
				continue;
			positions.add(new Position(540, 20*i+60));
		}
		positions.add(new Position(290, 290));
		positions.add(new Position(310, 290));
		positions.add(new Position(290, 310));
		positions.add(new Position(310, 310));
		
		initStuff(StuffType.IRON, positions);
	}
}

	

