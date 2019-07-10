public class Person {
    String name;
    int age;
    
    public void eat() {
        System.out.println("吃吃吃");
    }
    public void sleep() {
        System.out.println("睡睡睡");
    }
    
    public static void main(String[] args) {
        Person per = new Person(); //创建一个名为per的对象
        System.out.println(per.name);
        System.out.println(per.age);
        per.eat();
        per.sleep();
    }
}