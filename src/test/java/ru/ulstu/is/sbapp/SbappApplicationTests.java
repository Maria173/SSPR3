package ru.ulstu.is.sbapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import ru.ulstu.is.sbapp.operation.service.OperationService;

@SpringBootTest
class SbappApplicationTests {
	@Autowired
	OperationService operationService;

	@Test
	void testOperationKvadrat() {
		final String res = operationService.count(3, "kvadrat");
		Assertions.assertEquals("Квадрат: 9", res);
	}

	@Test
	void testOperationKoren() {
		final String res = operationService.count(9, "koren");
		Assertions.assertEquals("Корень: 3.0", res);
	}
}
