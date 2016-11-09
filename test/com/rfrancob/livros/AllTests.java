package com.rfrancob.livros;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
		TestePessoa.class,
		TesteLivro.class,
		TesteBiblioteca.class
})

public class AllTests {
	
}
