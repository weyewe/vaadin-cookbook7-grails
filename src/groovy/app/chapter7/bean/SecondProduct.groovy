package app.chapter7.bean

class SecondProduct {
	int code
	String name 
	double price 
	
	public SecondProduct( int code ) {
		this.code = code 
	}
	
	public SecondProduct( int code, String name, double price) {
		this.code = code
		this.name = name 
		this.price = price 
	}


}
