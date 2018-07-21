package learning;

public class Power {
	
	public static double powerOf(int base,int power) {
		
		if (power == 0) {
			return 1;
		}
		
		if (power <0) {
			if (base == 0) {
				throw new IllegalArgumentException("Base can not be 0 when power is negative");
			}
			return 1/powerOf(base, -power);
		} else {
		double result = powerOf(base,(int)power/2);
		if (power%2 == 0) {
			return result*result;
		} else {
			return result*result*base;
		}
		//return base*powerOf(base,power/2);
		
	}
	}
	
	public static void main (String args[]) {
		System.out.println(2+"to the power 3 "+Power.powerOf(2, 3));
		System.out.println(2+"to the power 4 "+Power.powerOf(2, 4));
		System.out.println(2+"to the power 5 "+Power.powerOf(2, -5));
	}

}
