package it.dove.retta;

public class Segmento {
	public final Punto a;
	public final Punto b;
	
	public Segmento(Punto a, Punto b) {
		this.a=a;
		this.b=b;
	}
	
	public boolean isNullo() {
		return a.equals(b);
	}
	public boolean isOrizzontale() {
		return !isNullo() && a.y==b.y;
	}
	public boolean isVerticale() {
		return !isNullo() && a.x==b.x;
	}
	
	public Punto getPuntoSuperiore() {
		if(a.y>b.y)
			return a;
		else
			return b;
	}
	public Punto getPuntoInferiore() {
		if(a.y<b.y)
			return a;
		else
			return b;
	}
	public Punto getPuntoSinistra() {
		if(a.x<b.x)
			return a;
		else
			return b;
	}
	public Punto getPuntoDestra() {
		if(a.x>b.x)
			return a;
		else
			return b;
	}
	
	public double getDeltaX() {
		return getPuntoDestra().x-getPuntoSinistra().x;
	}
	public double getDeltaY() {
		return getPuntoSuperiore().y-getPuntoInferiore().y;
	}
	
	public boolean equals(Segmento s) {
		return a.equals(s.a) && b.equals(s.b);
	}
}
