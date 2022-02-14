package cz.pettep.entity;

public class Test {
     private int ID;
     private String name;

    public Test(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
