class StrategicPattern{

	public static void main(String[] args){
	//	System.out.println("Hello World");
		Duck d1 = new MallardDuck();
		d1.setFlyable(new Nofly());
		d1.fly();
	}
}

abstract class Duck{

	// Variable Property of DUCK 
	Flyable flyable ;
	Quackable quackable;

	public Duck(Flyable fl,Quackable ql){
		this.flyable = fl;
		this.quackable = ql;
	}
	public Duck(){
		
	}

	abstract public void swim();

	public void fly(){
		flyable.fly();

	}

	public void quack(){
		quackable.quack();
	}

	public void setFlyable(Flyable fl){
		this.flyable = fl;
	}

	public Flyable getFlyable(){
		return this.flyable;
	}
	public void setQuackable(Quackable ql){
		this.quackable = ql;
	}

	public Quackable getQuackable(){
		return this.quackable;
	}
}

// Flying Behaviours
interface Flyable {
	public void fly();

}
class Nofly implements Flyable {
	public void fly(){
		System.out.println(" I am not able to fly!!");
	}

}
class Flywithwings implements Flyable {
	public void fly(){
		System.out.println(" I can Fly with Wings");
	}
}

// Quacking Behaviours 
interface Quackable{
	public void quack();
}

class Quack implements Quackable {

	public void quack(){
		System.out.println(" I can Quack");
	}

}

class Squeak implements Quackable {
	public void quack(){
		System.out.println(" I can inly Squeak");
	}
}

class NoSound implements Quackable {
	public void quack(){
		System.out.println(" I am not able to make sound");
	}
}

class MallardDuck extends Duck{
	public void swim(){
		System.out.println(" All duck can swim");
	}
}



