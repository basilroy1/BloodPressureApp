package com.example.demo;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class DemoApplicationTests {

	@Test
	void applicationStarts() {
		DemoApplication.main(new String[]{});
		Assertions.assertTrue(true);
	}
}
