package it.dove.retta;

import it.dove.retta.exceptions.RettaNonValidaException;

public class Retta {
	private final double a;
	private final double b;
	private final double c;
	
	public Retta(double a, double b, double c) throws RettaNonValidaException {
		//formula implicita: ax + by + c = 0
		//a e b non possono essere contemporaneamente zero
		if(a==0 && b==0) {
			throw new RettaNonValidaException();
		}
		this.a=a;
		this.b=b;
		this.c=c;
	}

	public static Retta creaDaFormulaImplicita(double a, double b, double c) throws RettaNonValidaException {
		return new Retta(a, b, c);
	}
	public static Retta creaDaFormulaEsplicita(double m, double q) throws RettaNonValidaException {
		//formula esplicita: y = mx + q
		//tutti i valori di m e q possono essere accettati
		//conversione in implicita: -mx + y - q = 0
		return new Retta(-m, 1, -q);
	}
	public static Retta creaRettaOrizzontale(double y) throws RettaNonValidaException {
		return new Retta(0, 1, -y);
	}
	public static Retta creaRettaVerticale(double x) throws RettaNonValidaException {
		return new Retta(1, 0, -x);
	}
	public static Retta creaDaSegmento(Segmento s) throws RettaNonValidaException {
		if(s.isNullo()) {
			throw new RettaNonValidaException();
		}
		else if(s.isOrizzontale()) {
			return creaRettaOrizzontale(s.a.y);
		}
		else if(s.isVerticale()) {
			return creaRettaVerticale(s.a.x);
		}
		else {
			double m=s.getDeltaY()/s.getDeltaX();
			double q=(s.a.y-m*s.a.x);
			return creaDaFormulaEsplicita(m, q);
		}
	}
	
	public boolean isOrizzontale() {
		return a==0;
	}
	public boolean isVerticale() {
		return b==0;
	}
	public boolean isObliqua() {
		return a!=0 && b!=0;
	}
	
	public boolean isParallela(Retta r) {
		return a==r.a && b==r.b;
	}
	public boolean isPerpendicolare(Retta r) {
		if(a==(-r.b) && b==r.a) return true;
		if(a==r.b && b==(-r.a)) return true;
		return false;
	}
	
	public boolean equals(Retta r) {
		return a==r.a && b==r.b && c==r.c;
	}
}
