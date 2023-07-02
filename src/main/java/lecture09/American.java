package lecture09;

public class American extends Person {
    public American(String name, String sex, String religion, boolean hasJob, String egn, String country) {
        super(name, sex, religion, "English", hasJob, "American", egn, country);
    }

    public void celebrateThanksgiving() {
        System.out.println("I am celebrating Thanksgiving on the fourth Tuesday in November");
    }
}
