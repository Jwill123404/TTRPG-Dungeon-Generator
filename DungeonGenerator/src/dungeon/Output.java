package dungeon;
import java.util.Scanner;
public class Output{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("How many rooms wide do you want your dungeon to be? ");
		int w = in.nextInt();
		in.nextLine();
		System.out.print("How many rooms deep do you want your dungeon to be? ");
		int d = in.nextInt();
		in.nextLine();
		System.out.print("How many rooms do you want your dungeon to have? ");
		int r = in.nextInt();
		in.nextLine();
		Generator.generateDungeon(d, w, r);
	}
}
