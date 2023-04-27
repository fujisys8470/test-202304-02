package junitTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import test.JUnitSample;

public class JUnitSampleTest {

	@Test
	public void ともに自然数() {

		int result = JUnitSample.calculation(3, 5);

		assertThat(result, is(8));

	}

}
