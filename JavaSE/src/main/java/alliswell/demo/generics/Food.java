package alliswell.demo.generics;

//Lev 1
public class Food {
    public String name = "Food";
}

//Lev 2
class Meat extends Food {
    public String name = "Meat";
}
class Fruit extends Food {
    public String name = "Fruit";
}

class Apple extends Fruit{
    public String name = "Apple";}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}

//Lev 4
class RedApple extends Apple{}
class GreenApple extends Apple{}