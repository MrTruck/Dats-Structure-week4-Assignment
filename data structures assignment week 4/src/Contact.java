import java.util.LinkedList;

public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    LinkedList<Contact> contactList = new LinkedList<>();

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getName() { return name; }
    public String getPhone() { return phoneNumber; }
    public String getEmail() { return email; }



    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
