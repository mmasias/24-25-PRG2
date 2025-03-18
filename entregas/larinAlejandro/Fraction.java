package entregas;
import entregas.larinAlejandro.reto004.Fraction;

public final class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {

        assert denominator == 0 : "Denominator cannot be equal to zero";
        int gcd = gcd(numerator,denominator);

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;

        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

	public Fraction(int numerator) {
		this(numerator, 1);
	}
    
	public Fraction() {
		this(0);
	}

    public Fraction add(Fraction fraction){
        return new Fraction(this.numerator * fraction.denominator + fraction.numerator * this.denominator, this.denominator * fraction.denominator);
    }

    public Fraction add(int integer){
        return add(new Fraction(integer));
    }

    private Fraction negate() {
        return new Fraction(-this.numerator, this.denominator);
    }

    public Fraction subtract(Fraction fraction) {
        return add(fraction.negate());
    }

    public Fraction subtract(int integer){
        return subtract(new Fraction(integer));
    }

    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    public Fraction oppose(){
        return new Fraction(this.numerator, this.denominator);
    }

    public Fraction multiply(Fraction fraction){
        return new Fraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction multiply(int integer){
        return  multiply(new Fraction(integer));
    }

    public Fraction invert(){
        assert this.numerator != 0 : "A fraction with a numerator of zero cannot be inverted.";
        return new Fraction(this.denominator, this.numerator);
    }

    public Fraction divide(Fraction fraction){
        return multiply(fraction.invert());
    }

    public Fraction divide(int integer){
        return divide(new Fraction(integer));
    }

    public Fraction pow(int exponent){
        return new Fraction((int)Math.pow(this.numerator, exponent), (int)Math.pow(this.denominator, exponent));
    }
    
    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public boolean isLessThan(Fraction fraction){
        return !isGreaterThan(fraction);
    }

    public boolean isGreaterThan(Fraction fraction){
        return this.numerator * fraction.denominator > fraction.numerator * this.denominator;
    }

    public boolean equals(Fraction fraction){
        return this.numerator * fraction.denominator == fraction.numerator * this.denominator;
    }

    public double valueOf(){
        return (double)this.numerator / this.denominator;
    }

    public int compareTo(Fraction fraction){
        return equals(fraction) ? 0 : isLessThan(fraction) ? 1 : -1;
    }

    public Fraction cloneFraction() {
        return new Fraction(this.numerator, this.denominator);
    }

    @Override
    public String toString() {
        return this.denominator == 1 ? Integer.toString(this.numerator) : this.numerator + "/" + this.denominator;
    }
}

