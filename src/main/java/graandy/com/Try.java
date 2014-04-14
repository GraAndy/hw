package graandy.com;

public class Try {
	public int value;
	public Try(int v){
		value = v;
	}
	public Try Add(Try e){
		return new Try(value + e.value);
	}
}
