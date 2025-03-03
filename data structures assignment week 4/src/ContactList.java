import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator; // needed for removing a contact

public class ContactList {
    Scanner scan = new Scanner(System.in);
    LinkedList<Contact> contactList = new LinkedList<>();

    public void addContact(String name, String phoneNumber, String email) {
        Contact newContact = new Contact(name, phoneNumber, email);
        contactList.add(newContact);
        System.out.println("Success!!!!!!!");
    }

    // Remove by Name usin iterator
    public void removeContactByName(String name) {
        Iterator<Contact> iterator = contactList.iterator();
        LinkedList<Contact> matchingContacts = new LinkedList<>(); // for multiple contacts with same name

        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(name)) {
                matchingContacts.add(contact);
            }
        }

        if (matchingContacts.isEmpty()) {
            System.out.println("Contact not found.");
            return;
        }

        if (matchingContacts.size() == 1) {
            Contact contact = matchingContacts.getFirst();
            System.out.println("Contact found: " + contact);
            System.out.println("Delete this contact? (Y/N)");
            char confirmDel = scan.nextLine().toUpperCase().charAt(0);
            if (confirmDel == 'Y') {
                contactList.remove(contact);
                System.out.println("Contact deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Multiple contacts found:");
            for (int i = 0; i < matchingContacts.size(); i++) {
                System.out.println((i + 1) + ". " + matchingContacts.get(i));
            }

            System.out.println("Enter the number of the contact you want to delete:");
            int choice = scan.nextInt();
            scan.nextLine(); // Consume newline

            if (choice >= 1 && choice <= matchingContacts.size()) {
                Contact selectedContact = matchingContacts.get(choice - 1);
                contactList.remove(selectedContact);
                System.out.println("Contact deleted successfully!");
            } else {
                System.out.println("Invalid choice. Deletion cancelled.");
            }
        }
    }

    // emove by Email usin Iterator
    public void removeContactByEmail(String email) {
        Iterator<Contact> iterator = contactList.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getEmail().equalsIgnoreCase(email)) {
                found = true;
                System.out.println("Contact found: " + contact);
                System.out.println("Delete this contact? (Y/N)");
                char confirmDel = scan.nextLine().toUpperCase().charAt(0);
                if (confirmDel == 'Y') {
                    iterator.remove();
                    System.out.println("Contact deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("contact not found.");
        }
    }

    // Remove by Phone Number using Iterator
    public void removeContactByNumber(String number) {
        Iterator<Contact> iterator = contactList.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getPhone().equals(number)) {
                found = true;
                System.out.println("Contact found: " + contact);
                System.out.println("Delete this contact? (Y/N)");
                char confirmDel = scan.nextLine().toUpperCase().charAt(0);
                if (confirmDel == 'Y') {
                    iterator.remove();
                    System.out.println("Contact deleted successfully!");
                } else {
                    System.out.println("deletion cancelled.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }



 //using for loops threw an exception
/*
    public void removeContactByName(String name) {
        for (Contact contact : contactList) {
            if (contact.getName().equals(name)) {
                System.out.println( "Contact found: " + contact.toString() + "\nDelete this contact? (Y/N)" );
                char confirmDel = scan.nextLine().toUpperCase().charAt(0);

                switch(confirmDel){
                    case 'Y':
                        contactList.remove(contact);
                        System.out.println("Success!!!!!!!");
                    case 'N':
                        System.out.println("Cancelled");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }


        }
        System.out.println("Contact not in list");


    }*/


    public void searchEmail(String email) {
        boolean found = false;                               // I did not understand the instruction.
        for (Contact contact : contactList) {               // Does the Email search mean input an email and get the contact OR input name/number and get email?
            if (contact.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Contact found: " + contact.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }


    public void printContacts() {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(contactList.get(i));
        }
    }

    /*
    public void searchByName(String name, String email, String phoneNumber) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhone().equals(phoneNumber) || contactList.get(i).getEmail().equals(email) || contactList.get(i).getName().equals(name) ) {
                System.out.println( "Contact found: " + contactList.get(i).toString() );


            }else{
                System.out.println("Contact not in list");
                break;
            }
        }
    }*/

    // Search by Name
    public void searchByName(String name) {
        boolean found = false;
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found: " + contact.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Search by Phone Number
    public void searchByPhone(String phoneNumber) {
        boolean found = false;
        for (Contact contact : contactList) {
            if (contact.getPhone().equals(phoneNumber)) {
                System.out.println("Contact found: " + contact.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Search by Email
    public void searchByEmail(String email) {
        boolean found = false;
        for (Contact contact : contactList) {
            if (contact.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Contact found: " + contact.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }






}
