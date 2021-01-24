package com.pcq.basic;
import org.testng.annotations.Test;

import com.pcq.util.Console;

import mockit.Tested;
public class KeyWordTest {

	@Tested
	private KeyWord kw;
	
	@Test
	public void testInstanceofExp() {
		Console.print(kw.instanceofExp());
	}
}
