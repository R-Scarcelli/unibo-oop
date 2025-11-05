class TestCalculator {
  public static void main(String[] args) {
      Calculator calc = new Calculator();
      System.out.println("1 + 2 = " + calc.add(1.0, 2.0));
      System.out.println("-1 - 2 = " + calc.sub(-1.0, 2.0));
      System.out.println("6 * 3 = " + calc.mul(6.0, 3.0));
      System.out.println("8 / 4 = " + calc.div(8.0, 4.0));
  }
}
