package lab6;

public class FactoryDemo {
	public static void main(String[] args) {
		ShoesFactory sf = new LeatherShoesFactory("G");
		makeShoes(sf);
		
		System.out.println();
		
		ShoesFactory sf2 = new SportShoesFactory("Nike");
		makeShoes(sf2);		

	}
	
	public static void makeShoes(ShoesFactory f) {
		System.out.println(f.makeShoesBody());
		System.out.println(f.makeShoesBottom());	
		System.out.println(f.makeShoesStrap());	
	}
}

class ShoesBody {
}

class ShoesBottom{	
}

class ShoesStrap{	
}

class SportShoesBody extends ShoesBody{
	private String name;
	
	public SportShoesBody(String name) {
		this.name = name;
		System.out.println("Making Sport Shoes Body...");
	}

	@Override
	public String toString() {
		return name + " Sport Shoes Body Finished";
	}
}

class SportShoesStrap extends ShoesStrap{
	private String name;
	
	public SportShoesStrap(String name) {
		this.name = name;
		System.out.println("Making Sport Shoes Strap...");
	}
	
	@Override
	public String toString() {
		return name + " Sport Shoes Strap Finished";
	}
}

class SportShoesBottom extends ShoesBottom{
	private String name;
	
	public SportShoesBottom(String name) {
		this.name = name;
		System.out.println("Making Sport Shoes Bottom...");
	}
	
	@Override
	public String toString() {
		return name + " Sport Shoes Bottom Finished";
	}
}

class LeatherShoesBody extends ShoesBody{
	private String name;
	
	public LeatherShoesBody(String name) {
		this.name = name;
		System.out.println("Making Leather Shoes Body...");
	}
	
	@Override
	public String toString() {
		return name + " Leather Shoes Body Finished";
	}
}

class LeatherShoesStrap extends ShoesStrap{
	private String name;
	
	public LeatherShoesStrap(String name) {
		this.name = name;
		System.out.println("Making Leather Shoes Strap...");
	}
	
	@Override
	public String toString() {
		return name + " Leather Shoes Strap Finished";
	}
}

class LeatherShoesBottom extends ShoesBottom{
	private String name;
	
	public LeatherShoesBottom(String name) {
		this.name = name;
		System.out.println("Making Leather Shoes Bottom...");
	}
	
	@Override
	public String toString() {
		return name + " Leather Shoes Bottom Finished";
	}
}

interface ShoesFactory {
	public ShoesBody makeShoesBody();
	public ShoesBottom makeShoesBottom();
	public ShoesStrap makeShoesStrap();
	
}

class SportShoesFactory implements ShoesFactory {
	private String name;
	
	public SportShoesFactory(String name) {
		this.name = name;
	}
	
	public ShoesBody makeShoesBody() {
		return new SportShoesBody(name);
	}

	public ShoesBottom makeShoesBottom() {
		return new SportShoesBottom(name);
	}
	public ShoesStrap makeShoesStrap() {
		return new SportShoesStrap(name);
	}
}

class LeatherShoesFactory implements ShoesFactory {
	private String name;
	
	public LeatherShoesFactory(String name) {
		this.name = name;
	}
	
	public ShoesBody makeShoesBody() {
		return new LeatherShoesBody(name);
	}

	public ShoesBottom makeShoesBottom() {
		return new LeatherShoesBottom(name);
	}
	public ShoesStrap makeShoesStrap() {
		return new LeatherShoesStrap(name);
	}	
}
