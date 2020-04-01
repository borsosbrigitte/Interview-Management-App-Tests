package utils;

import java.nio.charset.Charset;
import java.util.Random;

public class Util {

	public static int generateRandomInt(int upperRange){
	    Random random = new Random();
	    return random.nextInt(upperRange);
	}
	
	public static String generateRandomString() {
		String characters="ABCDEFGHJKLMNOPRSTUVWXYZ";
		String randomString="";
		
		int length=3;
		Random rand=new Random();
		char[] text=new char[length];
		for(int i=0;i<length;i++) {
			text[i]=characters.charAt(rand.nextInt(characters.length()));
		}
		for(int i=0;i<text.length;i++) {
			randomString+=text[i];
		}
		return randomString;
	}

   }


	

