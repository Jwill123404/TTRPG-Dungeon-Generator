package dungeon;

public class Generator{
	public static int[][] dungeon;
	public static int[][] rooms;

	public static void generateDungeon(int d, int w, int r){
		dungeon = new int[(d * 2) - 1][(w * 2) - 1];
		rooms = new int[(d * 2) - 1][(w * 2) - 1];
		if(r > d * w){
			r = d * w;
		}
		int r1 = (int)(Math.random() * d) * 2;
		int r2 = (int)(Math.random() * w) * 2;
		dungeon[r1][r2] = 1;
		rooms[r1][r2] = 0;
		int[] door;
		int i = 1;
		while(i < r - 1){
			while(dungeon[r1][r2] == 1 || !hasNeighbor(dungeon, r1, r2)){
				r1 = (int)(Math.random() * d) * 2;
				r2 = (int)(Math.random() * w) * 2;
			}
			if (dungeon[r1][r2] == 1) {
			    System.out.println("OVERWRITE DETECTED!");
			    System.out.println("Position: " + r1 + ", " + r2);
			}
			dungeon[r1][r2] = 1;
			int rom = (int)(Math.random() * 4) + 2;
			rooms[r1][r2] = rom;
			door = findNeighbor(dungeon, r1, r2);
			dungeon[door[0]][door[1]] = 2;
			i++;
		}
		while(dungeon[r1][r2] == 1 || !hasNeighbor(dungeon, r1, r2)){
			r1 = (int)(Math.random() * d) * 2;
			r2 = (int)(Math.random() * w) * 2;
		}
		dungeon[r1][r2] = 1;
		rooms[r1][r2] = 1;
		door = findNeighbor(dungeon, r1, r2);
		dungeon[door[0]][door[1]] = 2;
		RoomPrinter.printRoom(dungeon, rooms);
	}
	private static boolean hasNeighbor(int[][] D, int d, int w){
		int count = 0;
		if(w == 0){
		}else if(D[d][w-2] != 0){
			count++;
		}
		if(w == D[d].length - 1) {
		}else if(D[d][w+2] != 0){
			count++;
		}
		if(d == 0){
		}else if(D[d-2][w] != 0){
			count++;
		}
		if(d == D.length - 1){
		}else if(D[d+2][w] != 0){
			count++;
		}
		if(count > 0){
			return true;
		}
		return false;
	}

	private static int[] findNeighbor(int[][] D, int d, int w){
		int[] pos = new int[2];
		if(w == 0){
		}else if(D[d][w-2] != 0){
			pos[0] = d;
			pos[1] = w - 1;
			return pos;
		}
		if(w == D[d].length - 1) {
		}else if(D[d][w+2] != 0){
			pos[0] = d;
			pos[1] = w + 1;
			return pos;
		}
		if(d == 0){
		}else if(D[d-2][w] != 0){
			pos[0] = d - 1;
			pos[1] = w;
			return pos;
		}
		if(d == D.length - 1){
		}else if(D[d+2][w] != 0){
			pos[0] = d + 1;
			pos[1] = w;
			return pos;
		}
		return pos;
	}
}








