import java.util.Scanner; // import the Scanner class 

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        ContactList contactList = new ContactList();

        while(true){
            System.out.println("********************************\n(A)dd \n(D)elete \n(E)mail Search \n(S)earch \n(P)rint  \n(Q)uit \n******************************** \nEnter a command: ");
            char input = scan.nextLine().toUpperCase().charAt(0); // there is no nextChar method?

            switch (input){
                case 'A':
                    System.out.println("Enter a name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter phone number: ");
                    String phoneNumber = scan.nextLine();
                    System.out.println("Enter email: ");
                    String email = scan.nextLine();

                    contactList.addContact(name, phoneNumber, email);
                    break;

                case 'D':
                    System.out.println("Delete by: (N)ame / (P)honeNumber / (E)mail");
                    char deleteByInput = scan.nextLine().toUpperCase().charAt(0);

                    switch (deleteByInput){
                        case 'N':
                            System.out.println("Enter a name: ");
                            String deleteInputName = scan.nextLine();
                            contactList.removeContactByName(deleteInputName);
                            break;
                        case 'P':
                            System.out.println("Enter phone number: ");
                            String deleteInputPhone = scan.nextLine();
                            contactList.removeContactByNumber(deleteInputPhone);
                            break;
                        case 'E':
                            System.out.println("Enter email: ");
                            String deleteInputEmail = scan.nextLine();
                            contactList.removeContactByEmail(deleteInputEmail);
                            break;
                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                    break;

                case 'E':
                    System.out.println("Enter Email: ");
                    String searchByEmail = scan.nextLine();
                    contactList.searchEmail(searchByEmail);
                    break;

                case 'S':
                    System.out.println("Search by: (N)ame / (P)honeNumber / (E)mail");
                    char searchInput = scan.nextLine().toUpperCase().charAt(0);
                    switch (searchInput){
                        case 'N':
                            System.out.println("Enter name: ");
                            String searchName = scan.nextLine();

                            contactList.searchByName(searchName);
                            break;
                        case 'P':
                            System.out.println("Enter phone number: ");
                            String searchPhone = scan.nextLine();

                            contactList.searchByPhone(searchPhone);
                            break;
                        case 'E':
                            System.out.println("Enter email: ");
                            String searchEmail = scan.nextLine();

                            contactList.searchByEmail(searchEmail);
                            break;
                    }
                    break;
                case 'P':
                    contactList.printContacts();
                    break;
                case'Q':
                    System.out.println("Goodby");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
