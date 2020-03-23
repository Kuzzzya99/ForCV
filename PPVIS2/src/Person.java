package task5;

public class Person {
    private String firstName;
    private String lastName;

    public Person(String fName){
        this.firstName = fName;
        this.lastName = "";
    }

    public Person(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void SwapFirstWithLast(){
        if(!this.firstName.equals("")) {
            this.lastName = this.firstName;
            this.firstName = "";
        }
    }

    public void SwapLastWithFirst(){
        if(!this.lastName.equals("")) {
            this.firstName = this.lastName;
            this.lastName = "";
        }
    }
}
