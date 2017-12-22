package testmine;

import java.lang.reflect.Modifier;

import org.junit.Test;

public class MineTest {

	@Test
	public void test01() {
		int a = Modifier.constructorModifiers();
		System.out.println(a);
	}

	@Test
	public void test02() {
		System.out.println(Math.log(1000000));
	}
	
	@Test
	public void test03(){
		
	}
		
}
