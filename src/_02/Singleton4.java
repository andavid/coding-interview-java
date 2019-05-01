package _02;

public class Singleton4 {

  // 饿汉式
  private static final Singleton4 instance = new Singleton4();
  private Singleton4() {}
  public static Singleton4 getInstance() {
    return instance;
  }

  public static void main(String[] args) {
    System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
  }

}