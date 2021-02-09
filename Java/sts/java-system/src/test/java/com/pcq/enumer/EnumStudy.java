package com.pcq.enumer;

import org.testng.annotations.Test;
import static com.pcq.enumer.Color.*;

public class EnumStudy {
	
	
	@Test
	public void testEnumClass() {
		for(Color c : Color.values()) {
			System.out.println(c.name());
		}
		System.out.println(GREEN);
		System.out.println(BLUE.getDeclaringClass() + " : " + BLUE.toString());
		System.out.println(RED.ordinal());
	}
}
