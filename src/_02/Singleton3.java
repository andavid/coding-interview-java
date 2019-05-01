package _02;

public class Singleton3 {

  // 双重校验锁
  private static volatile Singleton3 instance;
  private Singleton3() {}
  public static Singleton3 getInstance() {
    if (instance == null) {
      synchronized (Singleton3.class) {
        if (instance == null) {
          instance = new Singleton3();
        }
      }
    }
    return instance;
  }

  public static void main(String[] args) {
    System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
  }

}