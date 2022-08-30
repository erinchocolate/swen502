package bugworld;

//public class Test {
//	public static void main(String[] args) {
//		testBugCreation();
//		testMove();
//		testCustomBugCreation();
//	}
//	
//	private static void testBugCreation() {
//		Bug testBug = new Bug();
//		System.out.println("\n*** Bug Creation Test ***");
//		if (testBug != null) {
//			System.out.println("Pass: test bug created.");
//			System.out.println("Bug: " + testBug.toText());
//		}
//	}
//	
//	private static void testCustomBugCreation() {
//		Bug CB1 = new Bug("Fly", "Frank", 'F', 50, 50, 100);
//		System.out.println("\n*** Custon Bug Creation Test ***");
//		if (CB1 != null) {
//			System.out.println("Pass: custom bug created with fixed variables.");
//			System.out.println("CB1: " + CB1.toText());
//		}
//		
//		Main main = new Main();
//		//Bug CB2 = main.generateUserBug();
//		if (CB2 != null) {
//			System.out.println("Pass: custom bug created.");
//			System.out.println("CB2: " + CB2.toText());
//		}
//	}
//	
//	
//	private static void testMove() {
//		Bug testMoveBug = new Bug();
//		boolean movesLeft = false;
//		boolean movesRight = false;
//		boolean movesUp = false;
//		boolean movesDown = false;
//		boolean movesAllDirections = false;
//		
//		int oldX = testMoveBug.getPosX();
//		int oldY = testMoveBug.getPosY();
//		
//		System.out.println("\n*** Test Bug Movement ***");
//		for (int i = 0; i < 100; i++) {
//			testMoveBug.generateDirection();
//			testMoveBug.move();
//			if (oldX == testMoveBug.getPosX()+1) {
//				movesLeft = true;
//			} else if (oldX == testMoveBug.getPosX()-1) {
//				movesRight = true;
//			} else if (oldY == testMoveBug.getPosY()+1) {
//				movesUp = true;
//			} else if (oldY == testMoveBug.getPosY()-1) {
//				movesDown = true;
//			}
//			
//			if (movesUp && movesDown && movesLeft && movesRight) {
//				movesAllDirections = true;
//				System.out.println("Pass: bug moves in every direction");
//				break;
//			}
//		}
//		
//		if (!movesAllDirections) {
//			System.out.println("Inconclusive: bug may not move all directions.");
//		}
//	}
//	
//}
