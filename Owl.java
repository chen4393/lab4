public class Owl {
  private String name;
  private int age;
  private int weight;

  public boolean equals(Owl other) {
    if (this.name.equals(other.getName()) && this.age == other.getAge() && this.weight == other.getWeight())
      return true;
    return false;
  }
  public Owl (String n, int a, int w) {
    name = n;
    age = a;
    weight = w;
  }
  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }
  public int getWeight() {
    return weight;
  }
}
