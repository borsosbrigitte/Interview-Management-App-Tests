package utils;

import java.util.Random;

public class Util {

	public static int generateRandomInt(int upperRange){
	    Random random = new Random();
	    return random.nextInt(upperRange);
	}
}
