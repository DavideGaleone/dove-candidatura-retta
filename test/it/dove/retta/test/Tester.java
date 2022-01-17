package it.dove.retta.test;

import org.junit.*;
import org.junit.jupiter.api.Assertions;

import it.dove.retta.*;
import it.dove.retta.exceptions.RettaNonValidaException;

public class Tester {

	@Test
	public void testPunto() {
		//test di unità "Punto"
		Punto p1=new Punto(2, 3);
		Punto p2=new Punto(2, 3);
		Punto p3=new Punto(5, 7);
		
		Assert.assertTrue(p1.equals(p2));
		Assert.assertFalse(p1.equals(p3));
	}
	
	@Test
	public void testSegmento() {
		//test di unità "Segmento"
		Punto p1=new Punto(2, 3);
		Punto p2=new Punto(5, 7);
		Segmento s1=new Segmento(p1, p2);
		Segmento s2=new Segmento(p1, p2);
		
		Punto p3=new Punto(8, 9);
		Punto p4=new Punto(3, 5);
		Segmento s3=new Segmento(p3, p4);
		
		Assert.assertTrue(s1.equals(s2));
		Assert.assertFalse(s1.equals(s3));
		
		Assert.assertTrue(s1.getPuntoInferiore().equals(p1));
		Assert.assertTrue(s1.getPuntoSuperiore().equals(p2));
		Assert.assertTrue(s1.getPuntoSinistra().equals(p1));
		Assert.assertTrue(s1.getPuntoDestra().equals(p2));
		Assert.assertTrue(s1.getDeltaX() == 3);
		Assert.assertTrue(s1.getDeltaY() == 4);
		
		Segmento s4=new Segmento(p1, p1);
		Assert.assertTrue(s4.isNullo());
		
		Punto ph1=new Punto(3, 2);
		Punto ph2=new Punto(7, 2);
		Punto pv1=new Punto(2, 3);
		Punto pv2=new Punto(2, 7);
		
		Segmento sh=new Segmento(ph1, ph2);
		Segmento sv=new Segmento(pv1, pv2);
		Assert.assertTrue(sh.isOrizzontale());
		Assert.assertFalse(sh.isVerticale());
		Assert.assertTrue(sv.isVerticale());
		Assert.assertFalse(sv.isOrizzontale());
	}
	
	@Test
	public void testRetta() {
		//test di unità "Retta"
		Segmento s0=new Segmento(new Punto(1, 1), new Punto(1, 1));
		Assert.assertThrows(RettaNonValidaException.class, () -> {
			new Retta(0, 0, 5);
	    });
		Assert.assertThrows(RettaNonValidaException.class, () -> {
			Retta.creaDaSegmento(s0);
	    });
		
		try {
			Retta r1=Retta.creaDaFormulaEsplicita(2, 3);
			Retta r2=Retta.creaDaFormulaEsplicita(2, 7);
			Assert.assertTrue(r1.isParallela(r2));
			Assert.assertTrue(r2.isParallela(r1));
			
			Retta r3=Retta.creaDaFormulaEsplicita(1, 3);
			Retta r4=Retta.creaDaFormulaEsplicita(-1, 7);
			Assert.assertTrue(r3.isPerpendicolare(r4));
			Assert.assertTrue(r4.isPerpendicolare(r3));
			
			Retta r5a=new Retta(-1, 1, -5);
			Retta r5b=Retta.creaDaFormulaImplicita(-1, 1, -5);
			Retta r6=Retta.creaDaFormulaEsplicita(1, 5);
			Assert.assertTrue(r5a.equals(r6));
			Assert.assertTrue(r5a.equals(r5b));
			
			Segmento s1=new Segmento(new Punto(2, 4), new Punto(4, 6));
			Retta r7=Retta.creaDaSegmento(s1);
			Retta r8=Retta.creaDaFormulaEsplicita(1, 2);
			Assert.assertTrue(r7.equals(r8));
			Assert.assertTrue(r7.isObliqua());
		} catch (RettaNonValidaException e) {
			e.printStackTrace();
		}
	}
}
