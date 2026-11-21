package dungeon;

public class RoomPrinter{
	//⌈¯⌉
	//⌊_⌋
	private static String topO =	"|¯¯¯  ¯¯¯|";
	private static String topC =	"|¯¯¯¯¯¯¯¯|";
	private static String mid =		"|        |";
	private static String leftO =	" ";
	private static String leftC =	"|";
	private static String rightO =	" ";
	private static String rightC =	"|";
	private static String bottomO =	"|___  ___|";
	private static String bottomC =	"|________|";
	private static String[] room = {
			"Entrance",
			"  Boss  ",
			"Treasure",
			" Enemy  ",
			"  Trap  ",
			" Puzzle "
	};
	
	public static void printRoom(int[][] rooms, int[][] setup){
		for(int row = 0; row < rooms.length; row += 2){
			for(int i = 0; i < 5; i++){
				for(int col = 0; col < rooms[row].length; col += 2){
					if(i == 0 && rooms[row][col] > 0){
						if(row == 0 || rooms[row - 1][col] == 0){
							System.out.print(topC);
						}else{
							System.out.print(topO);
						}
					}else if(i == 0){
						System.out.print("          ");
					}if((i == 1 || i == 3) && rooms[row][col] > 0){
						System.out.print(mid);
					}else if(i == 1 || i == 3){
						System.out.print("          ");
					}if(i == 2 && rooms[row][col] > 0){
						if(col == 0 || rooms[row][col - 1] == 0){
							System.out.print(leftC);
						}else if(rooms[row][col - 1] == 2){
							System.out.print(leftO);
						}
						System.out.print(room[setup[row][col]]);
						if(col == rooms[row].length - 1 || rooms[row][col + 1] == 0){
							System.out.print(rightC);
						}else if(rooms[row][col + 1] == 2){
							System.out.print(rightO);
						}
					}else if(i == 2){
						System.out.print("          ");
					}if(i == 4 && rooms[row][col] > 0){
						if(row == rooms.length - 1 || rooms[row + 1][col] == 0){
							System.out.print(bottomC);
						}else{
							System.out.print(bottomO);
						}
					}else if(i == 4){
						System.out.print("          ");
					}
					
				}System.out.println();
			}
		}
	}
}









