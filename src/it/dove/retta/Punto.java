package it.dove.retta;

public class Punto {
	public final double x;
	public final double y;
	
	public Punto(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public boolean equals(Punto p) {
		return this.x==p.x && this.y==p.y;
	}
}
