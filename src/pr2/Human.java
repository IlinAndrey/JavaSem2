package pr2;

import java.time.LocalDate;
public class Human {
    int age;
    int weight;
    String firstName;
    String lastName;
    LocalDate birthDate;

    public Human(int age, int weight, String firstName, String lastName, LocalDate birthDate) {
        this.age = age;
        this.weight = weight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", weight=" + weight +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
