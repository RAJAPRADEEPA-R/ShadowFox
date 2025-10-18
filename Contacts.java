package demo;
import java.util.*;
//import java.lang.Contacts;
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

public class Contacts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> list = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Contact Management ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // clear input

            if (ch == 1) {
                // Add contact
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter phone: ");
                String phone = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                list.add(new Contact(name, phone, email));
                System.out.println("Contact added!");

            } else if (ch == 2) {
                // View contacts
                if (list.isEmpty()) {
                    System.out.println("No contacts found!");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        Contact c = list.get(i);
                        System.out.println((i + 1) + ". " + c.name + " - " + c.phone + " - " + c.email);
                    }
                }

            } else if (ch == 3) {
                // Update contact
                if (list.isEmpty()) {
                    System.out.println("No contacts to update!");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i).name);
                    }
                    System.out.print("Enter contact number to update: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    if (num >= 1 && num <= list.size()) {
                        Contact c = list.get(num - 1);
                        System.out.print("Enter new name (" + c.name + "): ");
                        String name = sc.nextLine();
                        System.out.print("Enter new phone (" + c.phone + "): ");
                        String phone = sc.nextLine();
                        System.out.print("Enter new email (" + c.email + "): ");
                        String email = sc.nextLine();

                        if (!name.isEmpty()) c.name = name;
                        if (!phone.isEmpty()) c.phone = phone;
                        if (!email.isEmpty()) c.email = email;

                        System.out.println("Contact updated!");
                    } else {
                        System.out.println("Invalid number!");
                    }
                }

            } else if (ch == 4) {
                // Delete contact
                if (list.isEmpty()) {
                    System.out.println("No contacts to delete!");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ". " + list.get(i).name);
                    }
                    System.out.print("Enter contact number to delete: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    if (num >= 1 && num <= list.size()) {
                        list.remove(num - 1);
                        System.out.println("Contact deleted!");
                    } else {
                        System.out.println("Invalid number!");
                    }
                }

            } else if (ch == 5) {
                System.out.println("Exiting... Bye!");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
