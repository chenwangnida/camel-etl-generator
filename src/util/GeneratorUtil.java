package util;
import java.util.HashSet;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class GeneratorUtil {
	// randomly generate double
	public double getRandomlyDouble() {
		return RandomUtils.nextDouble();
	}
	
	// randomly generate double within the specified range
	public double getRandomlyDouble(final int startInclusive, final int endInclusive) {
		return RandomUtils.nextDouble(startInclusive, endInclusive);
	}
	
	//randomly generate string set with size 
	public HashSet<String> getRandomlyString(final int size, final int startInclusive, final int endExclusive) {
		HashSet<String> randomStrSet = new HashSet<String>();
		for (int i = 0; i < size; i++) {
			randomStrSet.add(RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(startInclusive, endExclusive)));
		}
		return randomStrSet;
	}
}
