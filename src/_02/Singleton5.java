package _02;

public class Singleton5 {

  // 静态内部类
  private static class SingletonHolder {
    public static final Singleton5 INSTANCE = new Singleton5();
  }
  private Singleton5() {}
  public static Singleton5 getInstance() {
    return SingletonHolder.INSTANCE;
  }

  public static void main(String[] args) {
    System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
  }

}