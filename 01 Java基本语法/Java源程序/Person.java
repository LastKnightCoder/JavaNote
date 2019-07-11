public class Person {
    private String name;
    private int age;
    
    // public String getName() {
        // return name;
    // }
    // public void setName(String who){
        // name = who;
    // }
    // 
    // public int getAge() {
        // return age;
    // }
    // public void setAge(int num){
        // age = num;
    // }
    // 
    // public void eat() {
        // System.out.println("吃吃吃");
    // }
    // public void sleep() {
        // System.out.println("睡睡睡");
    // }
    
    public static void main(String[] args) {
        // Person per = new Person(); //创建一个名为per的对象
        // System.out.println(per.name);
        // System.out.println(per.age);
        // per.eat();
        // per.sleep();

        Person per = new Person();
        per.name = "李四";
        per.age = 21;
        System.out.println("我叫做：" + per.name +"，我：" + per.age + "岁。");
    }
}