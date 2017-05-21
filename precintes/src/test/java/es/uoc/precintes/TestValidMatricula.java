package es.uoc.precintes;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uoc.precintes.utils.ModelUtils;

public class TestValidMatricula {

	@Test
	public void test() {
		assertTrue(ModelUtils.matriculaValida("6461BSB"));
		assertTrue(ModelUtils.matriculaValida("A 4220BJ"));
		assertTrue(ModelUtils.matriculaValida("B 123456"));
		assertTrue(ModelUtils.matriculaValida("IB4220BJ"));
		assertFalse(ModelUtils.matriculaValida("XX"));
	}

}
