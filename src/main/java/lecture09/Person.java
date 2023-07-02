package lecture09;

import java.time.LocalDate;

public class Person {
    private final String name;
    private final String religion;
    private final String language;
    private final String nationality;
    private String sex;
    private boolean hasJob;
    private String egn;
    private String birthDate;
    private int age;
    private String country;

    public Person(String name, String sex, String religion, String language, boolean hasJob, String nationality, String egn, String country) {
        this.name = name;
        setSex(sex);
        this.religion = religion;
        this.language = language;
        this.hasJob = hasJob;
        this.nationality = nationality;
        setEgn(egn);
        setBirthDate(egn);
        setAge(egn);
        this.country = country;
    }

    private void setAge(String egn) {
        String birthYear = "19" + egn.substring(0, 2);
        int currentYear = LocalDate.now().getYear();
        this.age = currentYear - Integer.parseInt(birthYear);
    }

    private void setBirthDate(String egn) {
        String month = egn.substring(2, 4);
        String date = egn.substring(4, 6);
        this.birthDate = month + "-" + date;
    }

    private void setEgn(String egn) {
        if (egn.length() == 10 && containsOnlyDigits(egn)) {
            this.egn = egn;
        } else {
            throw new RuntimeException("The provided EGN is not valid! The EGN must contain only 10 digits!");
        }
    }

    private boolean containsOnlyDigits(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private void setSex(String sex) {
        try {
            validateSex(sex);
            this.sex = sex;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateSex(String sex) throws Exception {
        String male = "Male";
        String female = "Female";

        if (!sex.equalsIgnoreCase(male) && !sex.equalsIgnoreCase(female)) {
            throw new Exception("Please provide a valid value for sex. Valid options are 'male' or 'female'");
        }
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    public void celebrateEaster() {
        if (religion.equalsIgnoreCase("orthodox") || religion.equalsIgnoreCase("catholic")) {
            System.out.println("I am celebrating Easter");
        } else {
            System.out.println("I am not celebrating Easter");
        }
    }

    public boolean isAdult() {
        switch (country) {
            case "Bulgaria":
            case "Italy":
                return age >= 18;
            case "USA":
                return age >= 21;
            default:
                throw new RuntimeException("We don't have information about country: " + country);
        }
    }

    public boolean canTakeLoan() {
        return hasJob;
    }

    public void setHasJob(boolean hasJob) {
        this.hasJob = hasJob;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
