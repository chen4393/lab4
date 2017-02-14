public class OwlStats {
  private double avgAge = 0.0f;
  private Owl heaviest;
  private Owl youngest;
  public void analyze(Owl[] owls) {
    int sum = 0;
    for (int i = 0; i < owls.length; i++)
      sum += owls[i].getAge();
    avgAge = (double)sum / owls.length;
    youngest = owls[0];
    for (int i = 1; i < owls.length; i++) {
      if (owls[i].getAge() < youngest.getAge())
        youngest = owls[i];
    }
    heaviest = owls[0];
    for (int i = 1; i < owls.length; i++) {
      if (owls[i].getWeight() > heaviest.getWeight())
        heaviest = owls[i];
    }
  }
  public Owl getYoungest() {
    if (youngest == null)
      return null;
    return youngest;
  }
  public Owl getHeaviest() {
    if (heaviest == null)
      return null;
    return heaviest;
  }
  public String toString() {
    String s = null;
    //boolean isInt = false;
    avgAge = round1(avgAge, 1);
    String sAvgAge = null;
    if (avgAge - (int)avgAge == 0)
      sAvgAge = Integer.toString((int)avgAge);
    else
      sAvgAge = Double.toString(avgAge);
    s = "Youngest: " + youngest.getName() + ", Heaviest: " + heaviest.getName() + ", Average age: " + sAvgAge;
    return s;
  }
  public static void main(String[] args) {
    Owl leslie = new Owl("leslie", 10, 10);
    Owl andy = new Owl("andy", 5, 11);
    Owl ron = new Owl("ron", 21, 21);
    Owl[] dataset = {leslie, andy, ron};
    OwlStats pawneePop = new OwlStats();
    pawneePop.analyze(dataset);
    Owl heaviest = pawneePop.getHeaviest();
    Owl youngest = pawneePop.getYoungest();
    Owl ron2 = new Owl("ron", 21, 21);
    String expectedSummary = "Youngest: andy, Heaviest: ron, Average age: 12";
    String actualSummary = pawneePop.toString();
    System.out.println(actualSummary);
    System.out.println("Heaviest Test: " + heaviest.equals(ron));
    System.out.println("Youngest Test: " + youngest.equals(andy));
    System.out.println("Equals Test: " + ron.equals(ron2));
    System.out.println("Summary Test: " + expectedSummary.equals(actualSummary));
    Owl jerry = new Owl("jerry/gary", 22, 22);
    dataset[2] = jerry;
    pawneePop.analyze(dataset);
    heaviest = pawneePop.getHeaviest();
    expectedSummary = "Youngest: andy, Heaviest: jerry/gary, Average age: 12.3";
    actualSummary = pawneePop.toString();
    System.out.println(actualSummary);
    System.out.println("Testing for changes dataset");
    System.out.println("Heaviest Test: " + heaviest.equals(jerry));
    System.out.println("Summary Test: " + expectedSummary.equals(actualSummary));
  }
  public static double round1(double value, int scale) {
    return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
  }
}
