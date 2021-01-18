package com.pcq.basic;

import org.testng.annotations.Test;

import com.pcq.util.Console;

import mockit.Tested;

public class BasicDataTypeTest {

	@Tested
  BasicDataType dT;
	
	@Test
  public void f() {
	  Console.print(dT.b);
	  Console.print(dT.s);
	  Console.print(dT.i);
	  Console.print(dT.l);
	  Console.print(dT.d);
	  Console.print(dT.f);
  }
	@Test
  public void testOverFlow() {
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		Console.print(a);
		Console.print(b);
		Console.print(a + b);
		dT.overFlow();
	}
}
