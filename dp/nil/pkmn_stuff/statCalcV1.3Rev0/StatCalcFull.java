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
	private static int gen = 4;
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
	public static int intDiv(int top,int bottom) {
		return (int)(top/bottom);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		if (retrys != 0) {
			System.out.printf("Let's try this again, shall we? This is your %d time retrying this session", retrys);
		}
		System.out.printf("Before we do anything else, what generation are you calculating? ");
		gen = scan.nextInt();
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
			System.out.printf("The attack would do %d damage.", AttackCalc(false));
		}else if(calculator == 3) {
			//TODO Implement the experience calculator and a query for arguments. Do NOT forget to make the actual calculator merely a return value.
			
		}else if(calculator == 4) {
			//TODO Implement solver. Solves for things like IVs and other values. Again, don't forget to make it merely a return value.
			
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
		int total = 0;
		System.out.printf("EVs:%n");
		for(int i = 0;i < 6;i++) {
			EVList.add((int)(Math.random()*255));
			total += EVList.get(i);
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
			if (total > 512) {
				i = 0;
				total = 0;
				EVList = new ArrayList<>();
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
					stats.add((int)((intDiv((intDiv(2*Base.get(i)+IVList.get(i)+(EVList.get(i)),4)*level),100)+level+10)));
				}else{
					stats.add((int)((intDiv(((intDiv(2*Base.get(i)+IVList.get(i)+(EVList.get(i)),4))*level),100)+5)*natureVals[i]));
				}
			}catch(Exception e) {
				break;
			}
		}
		return stats;
	}

	public static int AttackCalc(boolean embedStatCalc) {
		Scanner scan = new Scanner(System.in);
		String tempStore;
		int level;
		int funcAtk;
		double atkStage = 1;
		double effAtk;
		int funcDef;
		double defStage = 1;
		double effDef;
		int power;
		double modifier;
		boolean targets;
		boolean badge;
		boolean critical;
		double rand;
		boolean stab;
		double type;
		boolean burn;
		//TODO Add remaining query variables. Also find useful arguments, just in case.
		//Note: Calculation is Damage = ((((((2*Level)/5)+2)*Power*EffAtk/EffDef)/50)+2)*Modifier
		//Note: Modifier stacks multiplicatively, and contains all variables not contained in the main equation, however badge is unused until the gen I & II stat calculators are implemented.
		System.out.printf("Welcome to the damage calculator, this is a calculator for calculating the very complex outcome of damage.%nThis requires a whole lot of values, so it won't be good for doing midbattle, mostly because it requires values from your opponent.%n");
		
		System.out.printf("The first required value is the level of the attacking pokemon.%n");
		level = scan.nextInt();
		
		System.out.printf("The next value is the power of the move.%n");
		power = scan.nextInt();
		
		System.out.printf("The next two values are the effective attack stat and the effective defense. Here's a simple explanation:%n%nThe effective attack stat is either the special attack of the attacker if the move is a special move.%nIf it is a physical move, the attacker's physical attack stat would be used.%nThat stat would then be multiplied by the stat stages of the effective stat, to get the final result.%nA similar process happens for the defense of the defender, except that certain special moves use the defender's defense stat instead of the special defense stat.%n%nYou will be asked for the value of the stat, and then the stat stage. If you have already calculated that, just put zero(0) as the stat stage.%nFunctional Attack: ");
		funcAtk = scan.nextInt();
		
		System.out.printf("Now the stat stage (integers from negative six to six inclusive): ");
		switch(scan.nextInt()){
		case -6:
			atkStage = 2/8;
			break;
		case -5:
			atkStage = 2/7;
			break;
		case -4:
			atkStage = 2/6;
			break;
		case -3:
			atkStage = 2/5;
			break;
		case -2:
			atkStage = 2/4;
			break;
		case -1:
			atkStage = 2/3;
			break;
		case 1:
			atkStage = 3/2;
			break;
		case 2:
			atkStage = 4/2;
			break;
		case 3:
			atkStage = 5/2;
			break;
		case 4:
			atkStage = 6/2;
			break;
		case 5:
			atkStage = 7/2;
			break;
		case 6:
			atkStage = 8/2;
			break;
		}
		effAtk = funcAtk * atkStage;
		System.out.printf("Now time for defense. What is the functional defense? ");
		funcDef = scan.nextInt();
		System.out.printf("Now the other stat stage (integers from negative six to six inclusive): ");
		switch(scan.nextInt()){
		case -6:
			defStage = 2/8;
			break;
		case -5:
			defStage = 2/7;
			break;
		case -4:
			defStage = 2/6;
			break;
		case -3:
			defStage = 2/5;
			break;
		case -2:
			defStage = 2/4;
			break;
		case -1:
			defStage = 2/3;
			break;
		case 1:
			defStage = 3/2;
			break;
		case 2:
			defStage = 4/2;
			break;
		case 3:
			defStage = 5/2;
			break;
		case 4:
			defStage = 6/2;
			break;
		case 5:
			defStage = 7/2;
			break;
		case 6:
			defStage = 8/2;
			break;
		}
		effDef = funcDef * defStage;
		
		System.out.printf("It is now time to determine modifiers. The first one is for hitting multiple targets. Please enter true if it does or false if it does not.%n");
		targets = scan.nextBoolean();
		if(targets) modifier = .75; else modifier = 1;
		
		if (gen == 2) {
			System.out.printf("Do you have the badge associated with the move's typing (true or false)? ");
			badge = scan.nextBoolean();
			if(badge) modifier *= 1.25;
		}
		
		System.out.printf("Is weather helping, harming, or neutral to the attack? ");
		tempStore = scan.next();
		if (tempStore.toUpperCase() == "HELPING") {
			modifier *= 1.5;
		}else if(tempStore.toUpperCase() == "HARMING") {
			modifier *= .5;
		}
		
		System.out.printf("Is the attack a critical hit? ");
		critical = scan.nextBoolean();
		if(critical) {
			if(gen == 2||gen == 3||gen == 4||gen == 5) {
				modifier *= 2;
			}else if(!(gen == 2||gen == 3||gen == 4||gen == 5)&&!(gen == 1)) {
				modifier *= 1.5;
			}
		}
		
		System.out.printf("It is time to determine same type attack bonus. Does the move share a type with the pokemon using it? ");
		stab = scan.nextBoolean();
		if(stab) {
			System.out.printf("Does the pokemon also have adaptability?");
			tempStore = scan.nextLine();
			if(tempStore.equalsIgnoreCase("true")) {
				modifier *= 2;
			}else {
				modifier *= 1.5;
			}
		}
		
		System.out.printf("How effective is the move? Is it 4 times, 2 times, 1 times, .5 times, .25 times, or 0 times? ");
		type = scan.nextDouble();
		if(type == 4||type == 2||type == .5||type == .25||type == 0) {
			modifier *= type;
		}
		
		System.out.printf("Is the move a physical attack? ");
		tempStore = scan.next();
		if (tempStore.equalsIgnoreCase("true")) {
			System.out.printf("Is the user burned? ");
			burn = scan.nextBoolean();
			System.out.printf("Does the user have the ability Guts? ");
			tempStore = scan.next();
			if (gen >= 6) {
				System.out.printf("Is the move facade?");
				if(scan.nextBoolean()) {
					tempStore = "false";
				}
			}
			if(burn && tempStore.equalsIgnoreCase("true")) modifier *= .5;
		}
		
		System.out.printf("Now. It is time for the random multiplier. Enter the random multiplier here. It is from .85 to 1.%n");
		rand = scan.nextDouble();
		while(rand > 1||rand < .85) {
			System.out.printf("That isn't in the range. Would you like a number to be generated for you? ");
			if(scan.nextBoolean()) {
				while (rand < .85) {
					rand = Math.random() + Math.pow(10, -16);
				}
			}else {
				System.out.printf("Well, your last input was %f which is not in the range .85 to 1 inclusive. Try again.%n", rand);
				rand = scan.nextDouble();
			}
		}
		modifier *= rand;
		
		System.out.printf("Enter the multiplier for any last modifiers here. What is it? ");
		modifier *= scan.nextDouble();
		scan.close();
		return (int) Math.floor((Math.floor(Math.floor((Math.floor(Math.floor(Math.floor((2*level)/5)+2)*power)*effAtk)/effDef)/50)+2)*modifier);
	}
}