package _02;

public class Singleton2 {

  // 懒汉式，线程安全
  private static Singleton2 instance;
  private Singleton2() {}
  public static synchronized Singleton2 getInstance() {
    if (instance == null) {
      instance = new Singleton2();
    }
    return instance;
  }

  public static void main(String[] args) {
    System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
  }

}