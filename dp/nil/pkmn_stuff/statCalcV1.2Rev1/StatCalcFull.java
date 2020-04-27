/**
 * 
 */
package dp.nil.pkmn_stuff;
import java.util.*;
/**
 * @author DragoonsParadox
 *
 */

public class StatCalcFull {

	/**
	 * @param args
	 */
	private final static String[] args = {"None"};
	private static int retrys = 0;
	public enum Nature {
		HARDY,
		LONELY,
		BRAVE,
		ADAMANT,
		NAUGHTY,
		BOLD,
		DOCILE,
		RELAXED,
		IMPISH,
		LAX,
		TIMID,
		HASTY,
		SERIOUS,
		JOLLY,
		NAIVE,
		MODEST,
		MILD,
		QUIET,
		BASHFUL,
		RASH,
		CALM,
		GENTLE,
		SASSY,
		CAREFUL,
		QUIRKY
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		if (retrys != 0) {
			System.out.printf("Let's try this again, shall we? This is your %d time retrying this session", retrys);
		}
		System.out.printf("Type a number. For this current version (version 1.2 revision 0), there are three options, but only one functional option.%nThe following options are available. Please type the number that is where the list is positioned, to select an option.%n1. Stat Calculator. (Current Status: Working as expected, no bugs known.)%n2. Attack calculator. (Current Status: Development started. No working prototype currently available.)%n3. Experience Growth formula calculator. (Current status: No working prototype available, no current active development.)");
		int calculator = scan.nextInt();
		if (calculator == 1){
			//This is the code for the initialization of the stat calculator. It starts up the headed process for the calculator. 
			System.out.printf("Valid values for the following are either true or false.%nWould you like the EVs to be psuedorandomly generated?%n");
			boolean randomEVs = scan.nextBoolean();
			System.out.printf("How about the IVs? Would you like them to be psuedorandomly generated");
			if (randomEVs) {
				System.out.printf(" as well?%n");
			} else {
				System.out.printf(" instead?%n");
			}
			boolean randomIVs = scan.nextBoolean();
			boolean realMode = true;
			if (!(randomEVs && randomIVs)) {
				System.out.printf("Would you like those values to be limited to a reasonable domain since you are inputting your own values?%n");
				realMode = scan.hasNextBoolean();
			}
			StatCalc(randomEVs,randomIVs,realMode);
		}else if(calculator == 2) {
			//TODO Create the attack calculator and a separate method to query for arguments.
			
		}else if(calculator == 3) {
			//TODO Implement the experience calculator and a query for arguments. Do NOT forget to make the actual calculator merely a return value.
			
		}
		scan.close();
	}
	public static void StatCalc(boolean randomEVs, boolean randomIVs, boolean realMode) {
		// This is the place to run the StatCalc method.
		/*Indexes:
		 * 0 is HP
		 * 1 is Atk
		 * 2 is Def
		 * 3 is Sp. Atk
		 * 4 is Sp. Def
		 * 5 is Spd
		 */
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> Base = new ArrayList<>();
		ArrayList<Integer> EVList = new ArrayList<>();
		ArrayList<Integer> IVList = new ArrayList<>();
		ArrayList<Integer> Stats;
		String Nature;
		int Level;
		System.out.printf("Welcome to the PKMN Stat Calculator! Make sure you have the base stats of the pokemon you want to calculate the stats of, as well as the EVs, IVs, Nature, and Level.%nNow, let us begin.");
		System.out.printf("Lets start out with the simple ones. The level and the nature.%nNature (Please put the whole name. This is not case sensitive.): ");
		Nature = scan.nextLine();
		System.out.printf("Level: ");
		Level = Math.abs(scan.nextInt());
		if (realMode) {
			while(Level > 100 || Level == 0) {
				System.out.printf("Try again.");
				Level = Math.abs(scan.nextInt());
			}
		}
		System.out.printf("Time for the base stats.%nHP: ");
		Base.add(scan.nextInt());
		System.out.printf("Atk: ");
		Base.add(scan.nextInt());
		System.out.printf("Def: ");
		Base.add(scan.nextInt());
		System.out.printf("Sp. Atk: ");
		Base.add(scan.nextInt());
		System.out.printf("Sp. Def: ");
		Base.add(scan.nextInt());
		System.out.printf("Spd: ");
		Base.add(scan.nextInt());
		if(!randomEVs) {
			System.out.printf("Time for the EVs.%nHP: ");
			EVList.add(Math.abs(scan.nextInt()));
				if(realMode) {
					while(255 < EVList.get(0)) {
						System.out.printf("Try again.");
						EVList.set(0, Math.abs(scan.nextInt()));
					}
				}
			System.out.printf("Atk: ");
			EVList.add(Math.abs(scan.nextInt()));
			if(realMode) {
				while(255 < EVList.get(1)) {
					System.out.printf("Try again.");
					EVList.set(1, Math.abs(scan.nextInt()));
				}
			}
			System.out.printf("Def: ");
			EVList.add(scan.nextInt());
			if(realMode) {
				while(255 < EVList.get(2)) {
					System.out.printf("Try again.");
					EVList.set(2, Math.abs(scan.nextInt()));
				}
			}
			System.out.printf("Sp. Atk: ");
			EVList.add(scan.nextInt());
			if(realMode) {
				while(255 < EVList.get(3)) {
					System.out.printf("Try again.");
					EVList.set(3, Math.abs(scan.nextInt()));
				}
			}
			System.out.printf("Sp. Def: ");
			EVList.add(scan.nextInt());
			if(realMode) {
				while(255 < EVList.get(4)) {
					System.out.printf("Try again.");
					EVList.set(4, Math.abs(scan.nextInt()));
				}
			}
			System.out.printf("Spd: ");
			EVList.add(scan.nextInt());
			if(realMode) {
				while(255 < EVList.get(5)) {
					System.out.printf("Try again.");
					EVList.set(5, Math.abs(scan.nextInt()));
				}
			}
			if (realMode) {
				if(EVList.get(0) + EVList.get(1) + EVList.get(2) + EVList.get(3) + EVList.get(4) + EVList.get(5) > 510) {
					System.out.printf("I'm sorry. The total must be 510 or less. You can try again, though.");
					retrys++;
					main(args);
					scan.close();
					return;
				}
			}
		}else {
			EVList = EV_generate();
		}
		if (!randomIVs) {
		System.out.printf("Time for the IVs.%nHP: ");
		IVList.add(Math.abs(scan.nextInt()));
		if(realMode) {
			while(32 < IVList.get(0)) {
				System.out.printf("Try again.");
				IVList.set(0, Math.abs(scan.nextInt()));
			}
		}
		System.out.printf("Atk: ");
		IVList.add(Math.abs(scan.nextInt()));
		if(realMode) {
			while(32 < IVList.get(1)) {
				System.out.printf("Try again.");
				IVList.set(1, Math.abs(scan.nextInt()));
			}
		}
		System.out.printf("Def: ");
		IVList.add(Math.abs(scan.nextInt()));
		if(realMode) {
			while(32 < IVList.get(2)) {
				System.out.printf("Try again.");
				IVList.set(2, Math.abs(scan.nextInt()));
			}
		}
		System.out.printf("Sp. Atk: ");
		IVList.add(Math.abs(scan.nextInt()));
		if(realMode) {
			while(32 < IVList.get(3)) {
				System.out.printf("Try again.");
				IVList.set(3, Math.abs(scan.nextInt()));
			}
		}
		System.out.printf("Sp. Def: ");
		IVList.add(Math.abs(scan.nextInt()));
		if(realMode) {
			while(32 < IVList.get(4)) {
				System.out.printf("Try again.");
				IVList.set(4, Math.abs(scan.nextInt()));
			}
		}
		System.out.printf("Spd: ");
		IVList.add(Math.abs(scan.nextInt()));
		if(realMode) {
			while(32 < IVList.get(5)) {
				System.out.printf("Try again.");
				IVList.set(5, Math.abs(scan.nextInt()));
			}
		}
		}else {
			IVList = IV_generate();
		}
		scan.close();
		Stats = StatCalc(Base, IVList, EVList, Level, Nature);
		System.out.printf("These are the stats that were calculated:%nHP: %d%nAtk: %d%nDef: %d%nSp. Atk: %d%nSp. Def: %d%nSpd: %d", Stats.get(0),Stats.get(1),Stats.get(2),Stats.get(3),Stats.get(4),Stats.get(5));
	}
	public static ArrayList<Integer> EV_generate(){
		ArrayList<Integer> EVList = new ArrayList<>();
		System.out.printf("EVs:%n");
		for(int i = 0;i < 6;i++) {
			EVList.add((int)(Math.random()*255));
			switch (i){
			case 0:
				System.out.printf("HP: %d%n", EVList.get(i));
				break;
			case 1:
				System.out.printf("Atk: %d%n", EVList.get(i));
				break;
			case 2:
				System.out.printf("Def: %d%n", EVList.get(i));
				break;
			case 3:
				System.out.printf("Sp. Atk: %d%n", EVList.get(i));
				break;
			case 4:
				System.out.printf("Sp. Def: %d%n", EVList.get(i));
				break;
			case 5:
				System.out.printf("Spd: %d%n", EVList.get(i));
				break;
			}
		}
		return EVList;
	}
	public static ArrayList<Integer> IV_generate(){
		ArrayList<Integer> IVList = new ArrayList<>();
		System.out.printf("IVs:%n");
		for(int i = 0;i < 6;i++) {
			IVList.add((int)Math.floor(Math.random()*32));
			while (IVList.get(i) == 32) {
				IVList.set(i, (int)Math.floor(Math.random()*32));
			}
			switch (i){
			case 0:
				System.out.printf("HP: %d%n", IVList.get(i));
				break;
			case 1:
				System.out.printf("Atk: %d%n", IVList.get(i));
				break;
			case 2:
				System.out.printf("Def: %d%n", IVList.get(i));
				break;
			case 3:
				System.out.printf("Sp. Atk: %d%n", IVList.get(i));
				break;
			case 4:
				System.out.printf("Sp. Def: %d%n", IVList.get(i));
				break;
			case 5:
				System.out.printf("Spd: %d%n", IVList.get(i));
				break;
			}
		}
		return IVList;
	}
	public static ArrayList<Integer> StatCalc(ArrayList<Integer> Base, ArrayList<Integer> IVList, ArrayList<Integer> EVList, int level, String naturestr){
		Nature nature = Nature.valueOf(naturestr.toUpperCase());
		double[] natureVals = {1,1,1,1,1,1};
		switch (nature){
		case HARDY:
			break;
		case DOCILE:
			break;
		case SERIOUS:
			break;
		case BASHFUL:
			break;
		case QUIRKY:
			break;
		case LONELY:
			natureVals[1] = 1.1;
			natureVals[2] = .9;
			break;
		case BRAVE:
			natureVals[1] = 1.1;
			natureVals[5] = .9;
			break;
		case ADAMANT:
			natureVals[1] = 1.1;
			natureVals[3] = .9;
			break;
		case NAUGHTY:
			natureVals[1] = 1.1;
			natureVals[4] = .9;
			break;
		case BOLD:
			natureVals[2] = 1.1;
			natureVals[1] = .9;
			break;
		case RELAXED:
			natureVals[2] = 1.1;
			natureVals[5] = .9;
			break;
		case IMPISH:
			natureVals[2] = 1.1;
			natureVals[3] = .9;
			break;
		case LAX:
			natureVals[2] = 1.1;
			natureVals[4] = .9;
			break;
		case TIMID:
			natureVals[5] = 1.1;
			natureVals[1] = .9;
			break;
		case HASTY:
			natureVals[5] = 1.1;
			natureVals[2] = .9;
			break;
		case JOLLY:
			natureVals[5] = 1.1;
			natureVals[3] = .9;
			break;
		case NAIVE:
			natureVals[5] = 1.1;
			natureVals[4] = .9;
			break;
		case MODEST:
			natureVals[3] = 1.1;
			natureVals[1] = .9;
			break;
		case MILD:
			natureVals[3] = 1.1;
			natureVals[2] = .9;
			break;
		case QUIET:
			natureVals[3] = 1.1;
			natureVals[5] = .9;
			break;
		case RASH:
			natureVals[3] = 1.1;
			natureVals[4] = .9;
			break;
		case CALM:
			natureVals[4] = 1.1;
			natureVals[1] = .9;
			break;
		case GENTLE:
			natureVals[4] = 1.1;
			natureVals[2] = .9;
			break;
		case SASSY:
			natureVals[4] = 1.1;
			natureVals[5] = .9;
			break;
		case CAREFUL:
			natureVals[4] = 1.1;
			natureVals[3] = .9;
			break;
		}
		ArrayList<Integer> stats = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			try {
				if (i==0) {
					stats.add((int)((((2*Base.get(i)+IVList.get(i)+(EVList.get(i)/4))*level)/100)+level+10));
				}else{
					stats.add((int)((((((2*Base.get(i)+IVList.get(i)+(EVList.get(i)/4))*level)/100)+5)*natureVals[i])));
				}
			}catch(Exception e) {
				break;
			}
		}
		return stats;
	}
	public static ArrayList<Integer> StatCalc(String pokemon, ArrayList<Integer> IVList, ArrayList<Integer> EVList, int level, String naturestr){
		//TODO? Probably never, but implement list of pokemon and their base stats to make this work?
		
		ArrayList<Integer> Base = new ArrayList<Integer>();
		for (int i = 1; i < 6; i++) {
			Base.add(1);
		}
		Nature nature = Nature.valueOf(naturestr.toUpperCase());
		double[] natureVals = {1,1,1,1,1,1};
		switch (nature){
		case HARDY:
			break;
		case DOCILE:
			break;
		case SERIOUS:
			break;
		case BASHFUL:
			break;
		case QUIRKY:
			break;
		case LONELY:
			natureVals[1] = 1.1;
			natureVals[2] = .9;
			break;
		case BRAVE:
			natureVals[1] = 1.1;
			natureVals[5] = .9;
			break;
		case ADAMANT:
			natureVals[1] = 1.1;
			natureVals[3] = .9;
			break;
		case NAUGHTY:
			natureVals[1] = 1.1;
			natureVals[4] = .9;
			break;
		case BOLD:
			natureVals[2] = 1.1;
			natureVals[1] = .9;
			break;
		case RELAXED:
			natureVals[2] = 1.1;
			natureVals[5] = .9;
			break;
		case IMPISH:
			natureVals[2] = 1.1;
			natureVals[3] = .9;
			break;
		case LAX:
			natureVals[2] = 1.1;
			natureVals[4] = .9;
			break;
		case TIMID:
			natureVals[5] = 1.1;
			natureVals[1] = .9;
			break;
		case HASTY:
			natureVals[5] = 1.1;
			natureVals[2] = .9;
			break;
		case JOLLY:
			natureVals[5] = 1.1;
			natureVals[3] = .9;
			break;
		case NAIVE:
			natureVals[5] = 1.1;
			natureVals[4] = .9;
			break;
		case MODEST:
			natureVals[3] = 1.1;
			natureVals[1] = .9;
			break;
		case MILD:
			natureVals[3] = 1.1;
			natureVals[2] = .9;
			break;
		case QUIET:
			natureVals[3] = 1.1;
			natureVals[5] = .9;
			break;
		case RASH:
			natureVals[3] = 1.1;
			natureVals[4] = .9;
			break;
		case CALM:
			natureVals[4] = 1.1;
			natureVals[1] = .9;
			break;
		case GENTLE:
			natureVals[4] = 1.1;
			natureVals[2] = .9;
			break;
		case SASSY:
			natureVals[4] = 1.1;
			natureVals[5] = .9;
			break;
		case CAREFUL:
			natureVals[4] = 1.1;
			natureVals[3] = .9;
			break;
		}
		ArrayList<Integer> stats = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			try {
				if (i==0) {
					stats.add((int)((((2*Base.get(i)+IVList.get(i)+(EVList.get(i)/4))*level)/100)+level+10));
				}else{
					stats.add((int)((((((2*Base.get(i)+IVList.get(i)+(EVList.get(i)/4))*level)/100)+5)*natureVals[i])));
				}
			}catch(Exception e) {
				break;
			}
		}
		return stats;
	}

	@SuppressWarnings("unused")
	public static void AttackCalc(boolean embedStatCalc) {
		int funcAtk;
		int funcDef;
		int Power;
		double other;
		//TODO Add remaining query variables. Also find useful arguments, just in case.
	}
}