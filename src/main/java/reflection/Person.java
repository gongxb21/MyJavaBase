package reflection;

import java.io.Serializable;

public class Person extends Animal implements Serializable {

    public Person() {
    }

    ;

    public Person(String job) {
        this.job = job;
    }

    public String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void coding() {
        System.out.println("Person can code");
    }

    private void hello() {
        System.out.println("Person can hello");
    }
}
