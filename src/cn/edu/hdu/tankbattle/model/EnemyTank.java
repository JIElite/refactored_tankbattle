package cn.edu.hdu.tankbattle.model;

import java.awt.Color;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;


import cn.edu.hdu.tankbattle.constant.Direction;
import cn.edu.hdu.tankbattle.model.map.Map;
import cn.edu.hdu.tankbattle.view.GamePanel;

/**
 * 敌人坦克 继承自Tank类，并且实现Runnable接口 敌人坦克的线程是每隔36毫秒行走的，各种判断（30毫秒）会在这36毫秒以内判断完毕
 * 
 * @author 1052067939
 * @version 1.0
 * @since JavaSe-1.6
 *
 */
public class EnemyTank extends Tank implements Runnable {
	/**
	 * 我的坦克在敌人坦克的相对位置，正北方‘正南方’正西方‘正东方，-1为不知道
	 */
	private int myTankLocation = -1;
	/**
	 * 我的坦克方向
	 */
	private int myTankDirect = Direction.NORTH;
	/**
	 * 定时器
	 */
	private Timer timer;
	/**
	 * 是否要开火
	 */
	private boolean isShot = false;
	/**
	 * 是否在地图中
	 */
	private boolean isInMap = false;

	/**
	 * 敌人坦克构造方法
	 * 
	 * @param x
	 * @param y
	 * @param direct
	 */
	public EnemyTank(Position p, int direct) {
		super(p, direct);
		hp_color = Color.gray;
		setSpeed(4);
		setDirect(Direction.NORTH);
		setHealthPoint(10);
		setSpeedVector(0); // 设为0表示没有保存坦克的速度，按下暂停时速度就不会是0
		Thread threadTank = new Thread(this); // 创建敌人坦克线程
		threadTank.start(); // 启动线程
		// 定时器 每隔0.5秒打一发子弹
		MyTimerTask task = new MyTimerTask(this);
		timer = new Timer();
		timer.schedule(task, 0, 500);
	}
	
	public Image getImage() {
		return TankGameImages.enemyTankImg[getDirect()];
	}
		
	@Override
	public void run() {
		enemyTankRun();
	}
	
	/**
	 * 敌人坦克移动
	 */
	public void enemyTankRun() {
		while (true) {
			switch (getDirect()) { // 选择坦克方向
			case Direction.NORTH:
				for (;;) {
					// 睡眠36毫秒，36毫秒可以保证坦克的信息已经判断过一次了
					this.sleep(36);
					// 如果我的坦克在敌人坦克的正西方
					if (getMyTankLocation() == Direction.WEST) {
						setDirect(Direction.WEST);
						enemyGoWest();
					}
					// 如果我的坦克在敌人坦克的正东方
					if (getMyTankLocation() == Direction.EAST) {
						setDirect(Direction.EAST);
						enemyGoEast();
					}
					// 如果我的坦克在敌人坦克的正南方
					if (getMyTankLocation() == Direction.SOUTH) {
						setDirect(Direction.SOUTH);
						enemyGoSouth();
					}
					// 如果我的坦克在敌人坦克的正北方
					if (getMyTankLocation() == Direction.NORTH) {
						enemyGoNorth();
					}
					// 如果出界或者重叠的话 选择其他方向 跳出
					if (getY() <= 20 || isOverlapNo() == true) {
						setDirect(getRandomDirect(Direction.SOUTH,
								Direction.WEST, Direction.EAST));
						break;
					}
					// 如果现在坦克的方向不是北方，跳出
					if (getDirect() != Direction.NORTH)
						break;
					// 如果不重叠，前进
					if (isOverlapYes() == false)
						goNorth();
				}
				break;
			case Direction.SOUTH:
				for (;;) {
					this.sleep(36);
					if (getMyTankLocation() == Direction.WEST) {
						setDirect(Direction.WEST);
						enemyGoWest();
					}
					if (getMyTankLocation() == Direction.EAST) {
						setDirect(Direction.EAST);
						enemyGoEast();
					}
					if (getMyTankLocation() == Direction.NORTH) {
						setDirect(Direction.NORTH);
						enemyGoNorth();
					}
					if (getMyTankLocation() == Direction.SOUTH) {
						enemyGoSouth();
					}
					if (getY() >= GamePanel.HEIGHT - 20
							|| isOverlapNo() == true) {
						setDirect(getRandomDirect(Direction.NORTH,
								Direction.WEST, Direction.EAST));
						break;
					}
					if (getDirect() != Direction.SOUTH)
						break;
					if (isOverlapYes() == false)
						goSouth();
				}
				break;
			case Direction.WEST:
				for (;;) {
					this.sleep(36);
					if (getMyTankLocation() == Direction.NORTH) {
						setDirect(Direction.NORTH);
						enemyGoNorth();
					}
					if (getMyTankLocation() == Direction.EAST) {
						setDirect(Direction.EAST);
						enemyGoEast();
					}
					if (getMyTankLocation() == Direction.SOUTH) {
						setDirect(Direction.SOUTH);
						enemyGoSouth();
					}
					if (getMyTankLocation() == Direction.WEST) {
						enemyGoWest();
					}
					if (getX() <= 20 || getY() <= 20
							|| isOverlapNo() == true) {
						setDirect(getRandomDirect(Direction.NORTH,
								Direction.SOUTH, Direction.EAST));
						break;
					}
					if (getDirect() != Direction.WEST)
						break;
					if (isOverlapYes() == false)
						goWest();
				}
				break;
			case Direction.EAST:
				for (;;) {
					this.sleep(36);
					if (getMyTankLocation() == Direction.WEST) {
						setDirect(Direction.WEST);
						enemyGoWest();
					}
					if (getMyTankLocation() == Direction.NORTH) {
						setDirect(Direction.NORTH);
						enemyGoNorth();
					}
					if (getMyTankLocation() == Direction.SOUTH) {
						setDirect(Direction.SOUTH);
						enemyGoSouth();
					}
					if (getMyTankLocation() == Direction.EAST) {
						enemyGoEast();
					}
					if (getX() >= GamePanel.WIDTH - 20
							|| getY() <= 20 || isOverlapNo() == true) {
						setDirect(getRandomDirect(Direction.NORTH,
								Direction.SOUTH, Direction.WEST));
						break;
					}
					if (getDirect() != Direction.EAST)
						break;
					if (isOverlapYes() == false)
						goEast();
				}
				break;
			}
			this.sleep(216); // 改变一个方向的话，不要让他很快
			if (isLive() == false) { // 如果坦克死亡的话 该坦克线程结束
				break;
			}
		}
	}

	/**
	 * 判断自己跟别的坦克是否重叠
	 * 
	 * @param enemys
	 *            敌人坦克容量
	 * @param myTanks
	 *            我的坦克容量
	 * @return 是否重叠
	 */
	public boolean isOverlap_(Vector<EnemyTank> enemys, Vector<MyTank> myTanks) {
		for (int i = 0; i < enemys.size(); i++) { // 依次取出每一个敌人坦克
			if (this != enemys.get(i)) {
				if (Overlap(enemys.get(i), 40) == true) { // 判断这两辆坦克是否重叠
					setOverlapNo(true);
					return true; // 一旦有重叠则返回真
				}
			}
		}
		for (int j = 0; j < myTanks.size(); j++) { // 依次取出每个我的坦克
			if (Overlap(myTanks.get(j), 40) == true) { // 判断这两辆坦克是否重叠
				setOverlapYes(true); // 面对我的坦克，敌人坦克开炮过去
				return true; // 一旦有重叠则返回真
			}
		}
		// 如果前面没有返回的话，说明没重叠，返回假
		setOverlapNo(false);
		setOverlapYes(false);
		return false; // 没有重叠现象则返回假
	}

	/**
	 * 每隔36毫秒 一直向西走
	 */
	public void enemyGoWest() {
		for (;;) {
			this.sleep(36);
			if (isOverlapNo() == false && isOverlapYes() == false) { // 不重叠的话
				goWest();
			}
			if (getMyTankLocation() != Direction.WEST) { // 我的坦克不在正西方的时候
				setDirect(getMyTankDirect()); // 让敌人坦克与我的坦克方向一致
				break;
			}
		}
	}

	/**
	 * 每隔36毫秒 一直向东走
	 */
	public void enemyGoEast() {
		for (;;) {
			this.sleep(36);
			if (isOverlapNo() == false && isOverlapYes() == false) {
				goEast();
			}
			if (getMyTankLocation() != Direction.EAST) {
				setDirect(getMyTankDirect());
				break;
			}
		}
	}

	/**
	 * 每隔36毫秒 一直向北走
	 */
	public void enemyGoNorth() {
		for (;;) {
			this.sleep(36);
			if (isOverlapNo() == false && isOverlapYes() == false) {
				goNorth();
			}
			if (getMyTankLocation() != Direction.NORTH) {
				setDirect(getMyTankDirect());
				break;
			}
		}
	}

	/**
	 * 每隔36毫秒 一直向南走
	 */
	public void enemyGoSouth() {
		for (;;) {
			this.sleep(36);
			if (isOverlapNo() == false && isOverlapYes() == false) {
				goSouth();
			}
			if (getMyTankLocation() != Direction.SOUTH) {
				setDirect(getMyTankDirect());
				break;
			}
		}
	}

	/**
	 * 从指定的三个方向中随机选择一个
	 * 
	 * @param direct1
	 *            方向1
	 * @param direct2
	 *            方向2
	 * @param direct3
	 *            方向3
	 */
	public int getRandomDirect(int direct1, int direct2, int direct3) {
		int random = (int) (Math.random() * 3);
		int returnDirect = -1;
		switch (random) {
		case 0:
			returnDirect = direct1;
			break;
		case 1:
			returnDirect = direct2;
			break;
		case 2:
			returnDirect = direct3;
			break;
		}
		return returnDirect;
	}

	/**
	 * 让敌人坦克能够发现我的坦克并开炮
	 * 
	 * @param myTank
	 *            我的坦克
	 * @param map
	 *            地图对象
	 */
	public void findAndKill(MyTank myTank, Map map) {
		int myX = myTank.getX();
		int myY = myTank.getY();
		int enX = this.getX();
		int enY = this.getY();
		if (Math.abs(myX - enX) < 20 && myY <= 580) { // 如果我的坦克在敌人坦克的正北方或正南方
			if (enY < myY) { // 我的坦克在正南方
				int s = 0;
				for (int t = 0; t < map.getIrons().size(); t++) {
					Iron iron = map.getIrons().get(t);
					if (Math.abs(enX - iron.getX()) <= 10 && iron.getY() > enY
							&& iron.getY() < myY) {
						s = 1; // 只要出现一个铁块能挡住子弹，就让s变为1，跳出判断
						break;
					}
				}
				if (s == 0) { // 如果s==1说明没有铁块挡住子弹，可以发射
					setShot(true);
					setMyTankLocation(Direction.SOUTH);
				}
			} else { // 我的坦克在正北方
				int s = 0;
				for (int t = 0; t < map.getIrons().size(); t++) {
					Iron iron = map.getIrons().get(t);
					if (Math.abs(enX - iron.getX()) <= 10 && iron.getY() < enY
							&& iron.getY() > myY) {
						s = 1;
						break;
					}
				}
				if (s == 0) {
					setShot(true);
					setMyTankLocation(Direction.NORTH);
				}
			}
		} else if (Math.abs(myY - enY) < 20 && myY <= 580) { // 如果我的坦克在敌人坦克的正西方或正东方
			if (enX > myX) { // 我的坦克在正西方
				int s = 0;
				for (int t = 0; t < map.getIrons().size(); t++) {
					Iron iron = map.getIrons().get(t);
					// 铁块能挡住子弹，而且在我的坦克和敌人坦克之间
					if (Math.abs(enY - iron.getY()) <= 10 && iron.getX() < enX
							&& iron.getX() > myX) {
						s = 1;
						break;
					}
				}
				if (s == 0) {
					setShot(true);
					setMyTankLocation(Direction.WEST);
				}
			} else { // 我的坦克在正东方
				int s = 0;
				for (int t = 0; t < map.getIrons().size(); t++) {
					Iron iron = map.getIrons().get(t);
					if (Math.abs(enY - iron.getY()) <= 10 && iron.getX() > enX
							&& iron.getX() < myX) {
						s = 1;
						break;
					}
				}
				if (s == 0) {
					setShot(true);
					setMyTankLocation(Direction.EAST);
				}
			}
		} else { // 其他情况敌人坦克不能判断我的坦克位置，要完善的话，还可以继续加进去
			setShot(false);
			setMyTankLocation(-1);
		}
	}
	
	/**
	 * 线程睡眠指定时间
	 * 
	 * @param time
	 *            睡眠时间，单位：毫秒
	 */
	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public int getMyTankLocation() {
		return myTankLocation;
	}

	public void setMyTankLocation(int myTankLocation) {
		this.myTankLocation = myTankLocation;
	}

	public boolean isShot() {
		return isShot;
	}

	public void setShot(boolean isShot) {
		this.isShot = isShot;
	}

	public int getMyTankDirect() {
		return myTankDirect;
	}

	public void setMyTankDirect(int myTankDirect) {
		this.myTankDirect = myTankDirect;
	}

	public boolean isInMap() {
		return isInMap;
	}

	public void setInMap(boolean isInMap) {
		this.isInMap = isInMap;
	}
}

/**
 * 发射子弹
 * 
 * @author 1052067939
 *
 */
class MyTimerTask extends TimerTask {
	EnemyTank tank;

	public MyTimerTask(EnemyTank tank) {
		this.tank = tank;
	}

	@Override
	public void run() {
		if (tank.getSpeedVector() == 0 && tank.isShot() == true)
			tank.shot();
	}

}