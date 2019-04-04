import java.util.*;

public class PigDiceGame {
	public static void main(String[] args) {
		int Player1Points = 0;
		int Player2Points = 0;
		int tempturnscore = 0;
		int turn = 1; //1 corresponds to player 1, -1 corresponds to player 2
		System.out.println("Welcome to the amazing pig game.");
		System.out.println("The rules are simple: Two players race to reach 100 points.");
		System.out.println("Each turn, a player repeatedly rolls a die until either a 1 is rolled or the player holds and scores the sum of the rolls.");
		System.out.println("If the player rolls a:");
		System.out.println("1: the player scores nothing and it becomes the opponent's turn.");
		System.out.println("2-6: the number is added to the player's turn total and the player's turn continues.");
		System.out.println("If the player holds, then");
		System.out.println("the turn total is added to the player's score and it becomes the opponent's turn.");
		System.out.println("Ready? (Player one's turn)");
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
		Scanner in = new Scanner(System.in);
		while(Player1Points < 100 && Player2Points < 100){
			String input = new String(in.nextLine());
			if(input.equals("roll")) {
				Random Rand = new Random();
				int DiceNumber = Rand.nextInt(6);
				DiceNumber+=1;
				System.out.println("You rolled a " + DiceNumber);
				if(DiceNumber==1) {
					tempturnscore = 0;
					if(turn==1) {
						System.out.println("It was player one's turn, they have " + Player1Points + " points and now it is player two's turn, they have " + Player2Points + " points.");
						turn = turn*-1;
					}
					else {
						System.out.println("It was player two's turn, they have " + Player2Points + " points and now it is player one's turn, they have " + Player1Points + " points.");
						turn = turn*-1;
					}
				}
				else {
					tempturnscore = tempturnscore + DiceNumber;
				}
			}
			else if(input.equals("hold")) {
				if(turn==1) {
					Player1Points = Player1Points + tempturnscore;
					tempturnscore = 0;
					turn = turn*-1;
					System.out.println("Player one has " + Player1Points + " points.  " + "Player two has " + Player2Points + " points.");
				}
				else {
					Player2Points = Player2Points + tempturnscore;
					tempturnscore = 0;
					turn = turn*-1;
					System.out.println("Player one has " + Player1Points + " points.  " + "Player two has " + Player2Points + " points.");
				}
			}
			else {
				System.out.println("Please input hold or roll.");
			}
		}
		if(Player1Points >= 100) {
			System.out.println("Player one wins with:" + Player1Points);
		}
		else {
			System.out.println("Player two wins with:" + Player2Points);
		}
	}
}
