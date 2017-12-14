package cn.edu.hdu.tankbattle.control;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import cn.edu.hdu.tankbattle.bullet.Bullet;
import cn.edu.hdu.tankbattle.constant.Direction;
import cn.edu.hdu.tankbattle.model.Bomb;
import cn.edu.hdu.tankbattle.model.EnemyTank;
import cn.edu.hdu.tankbattle.model.MyTank;
import cn.edu.hdu.tankbattle.model.Stuff;
import cn.edu.hdu.tankbattle.model.Tank;
import cn.edu.hdu.tankbattle.model.TankGameImages;
import cn.edu.hdu.tankbattle.model.map.Map;
import cn.edu.hdu.tankbattle.view.GamePanel;

/**
 * 游戏绘画类
 * 
 * @author 1052067939
 * @since JavaSe-1.6
 */
public class Draw {
	/**
	 * 画出地图
	 * 
	 * @param g
	 *            Graphics
	 * @param map
	 *            地图对象
	 * @param panel
	 *            被画的那个面板
	 */
	public void drawMap(Graphics g, Map map, JPanel panel) {
		Vector<Stuff> stuffs = map.getMapStuffs();
		this.drawMapStuffs(g, stuffs, panel);
	}
	
	public void drawMapStuffs(Graphics g, Vector<Stuff> stuffs, JPanel panel) {
		for (int i = 0; i < stuffs.size(); i++) {
			Stuff stuff = stuffs.get(i);
			g.drawImage(TankGameImages.stuffImg[stuff.getType()],
					stuff.getX() - 10, stuff.getY() - 10, 20, 20, panel);
		}
	}
	
	/**
	 * 画出游戏右边的那个面板
	 * 
	 * @param g
	 *            Graphics
	 * @param tgp
	 *            游戏主要面板对象
	 */
	public void drawInformationPanel(Graphics g, GamePanel tgp) {
		// TODO Enemy tanks 的數目在哪裡得知？可能要先了解 MVC 才能下去改
		for (int i = 0; i < tgp.getControl().getEnemyTankNum(); i++) {
			if (i >= 4) {
				g.drawImage(TankGameImages.enemyTankImg[Direction.NORTH],
						402 + 50 * i, 100, 40, 40, tgp);
			} else {
				g.drawImage(TankGameImages.enemyTankImg[Direction.NORTH],
						602 + 50 * i, 20, 40, 40, tgp);
			}
		}
		for (int j = 0; j < tgp.getControl().getMyTankNum(); j++) {
			g.drawImage(TankGameImages.myTankImg[Direction.NORTH], 602 + 50 * j,
					400, 40, 40, tgp);
		}
		g.drawString("我的坦克子弹数目:" + tgp.getControl().getMyBulletNum(), 620, 500);
	}
	
	/**
	 * 画出爆炸
	 * 
	 * @param g
	 *            Graphics
	 * @param bombs
	 *            炸弹对象容器
	 * @param panel
	 *            被画的那个面板
	 */
	public void drawBomb(Graphics g, Vector<Bomb> bombs, JPanel panel) {
		for (int i = 0; i < bombs.size(); i++) {
			Bomb b = bombs.get(i); // 从炸弹容器中取出一颗炸弹
			b.draw(g, panel);
			b.lifeDown(); // 生命随时间衰减
			if (b.getLifeTime() == 0) { // 该炸弹死亡
				b.setLive(false);
			}
		}
	}
	
	/**
	 * 画出东西（包括坦克、障碍物。。）
	 * 
	 * @param g
	 *            Graphics
	 * @param stuff
	 *            东西对象
	 * @param panel
	 *            被画的那个面板
	 */
	public void drawTank(Graphics g, Tank tank, JPanel panel) {
		tank.draw(g, panel);
	}

	/**
	 * 画出敌人坦克和子弹
	 * 
	 * @param g
	 *            Graphics
	 * @param enemys
	 *            敌人坦克容量
	 * @param panel
	 *            被画的面板
	 */
	public void drawEnemyTank(Graphics g, Vector<EnemyTank> enemys, JPanel panel) {
		for (int i = 0; i < enemys.size(); i++) {
			enemys.get(i).draw(g, panel);
			for (int j = 0; j < enemys.get(i).getBullets().size(); j++) {
				if (enemys.get(i).getBullets().get(j) != null) {
					Bullet eb = enemys.get(i).getBullets().get(j);
					g.drawImage(TankGameImages.bullet, eb.getX() - 2,
							eb.getY() - 2, 4, 4, panel);
				}
			}
		}
	}
	
	/**
	 * 画出我的坦克和子弹
	 * 
	 * @param g
	 *            Graphics
	 * @param myTanks
	 *            我的坦克容量
	 * @param panel
	 *            被画的那个面板
	 */
	public void drawMyTank(Graphics g, Vector<MyTank> myTanks, JPanel panel) {
		for (int m = 0; m < myTanks.size(); m++) {
			MyTank myTank = myTanks.get(m); // 取出我的坦克
			myTank.draw(g, panel);
			for (int i = 0; i < myTank.getBullets().size(); i++) {
				if (myTank.getBullets().get(i) != null) {
					Bullet b = myTank.getBullets().get(i);
					g.drawImage(TankGameImages.bullet, b.getX() - 2,
							b.getY() - 2, 4, 4, panel);
				}
			}
		}
	}
}
