package _02;

public class Singleton1 {

  // 懒汉式，线程不安全
  private static Singleton1 instance;
  private Singleton1() {}
  public static Singleton1 getInstance() {
    if (instance == null) {
      instance = new Singleton1();
    }
    return instance;
  }

  public static void main(String[] args) {
    System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
  }

}