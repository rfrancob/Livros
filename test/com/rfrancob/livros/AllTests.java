package com.rfrancob.livros;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({ TesteLivro.class, TestePessoa.class })
public class AllTests {
	
	public static Test suite(){
		TestSuite suite = new TestSuite("teste");
		
		suite.addTestSuite(TesteLivro.class);
		suite.addTestSuite(TestePessoa.class);
		
		return (Test) suite;
		
	}
}
