package fr.diginamic.reflect;

import org.junit.Test;

public class ReflectUtilsTest {

	@Test
	public void testInstantiate() {
		ReflectUtils.instantiate("testService.modifier(22)");
	}

}
