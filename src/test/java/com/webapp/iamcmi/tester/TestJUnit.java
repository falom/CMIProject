package com.webapp.iamcmi.tester;

import org.testng.junit.*;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class TestJUnit {
	public void main(String[] args){
		testAdd();
	}
	
	@Test
	public void testAdd(){
		String str="Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
	
}
