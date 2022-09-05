package bugworld;

public class BugWorld {
	private static int bugNum = 3;	
	private static int plantNum = 1;	
	private static int obstacleNum = 3;	
	private static int width = 8;
	private static int height = 8;

	private World world;
	
	public BugWorld() throws InterruptedException {
		world = new World(width,height,bugNum,plantNum,obstacleNum);
		world.drawWorld();
		//Thread.sleep(1000);
		world.moveBug();
		world.drawWorld();
		//Thread.sleep(1000);
		world.moveBug();
		world.drawWorld();		
	}
	
	
}
