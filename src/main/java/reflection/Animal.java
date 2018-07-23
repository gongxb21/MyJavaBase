package reflection;

public class Animal {
    public String name;
    private String age;
    private static String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        Animal.gender = gender;
    }

    public void run() {
        System.out.println("Animal can run");
    }

}
