import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("admin", "1234");
        List<Donor> donors = new ArrayList<>();
        List<Recipient> recipients = new ArrayList<>();

        System.out.println("Admin Login");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (!admin.authenticate(username, password))
        {
            System.out.println("Invalid credentials! Exiting...");
            return;
        }

        System.out.println("\nChoose your Option:");
        System.out.println("1. Donor");
        System.out.println("2. Recipient");
        System.out.print("Choose an option: ");
        int userType = scanner.nextInt();
        scanner.nextLine();

        if (userType == 1) {
            while (true) {
                System.out.println("\nDonor Module");
                System.out.println("1. Add Donor");
                System.out.println("2. View Donors");
                System.out.println("3. Search Donors by Blood Group");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Donor Name: ");
                        String donorName = scanner.nextLine();
                        System.out.print("Enter Blood Group: ");
                        String donorBloodGroup = scanner.nextLine();
                        System.out.print("Enter Phone: ");
                        String donorPhone = scanner.nextLine();
                        System.out.print("Enter City: ");
                        String donorCity = scanner.nextLine();

                        donors.add(new Donor(donorName, donorBloodGroup, donorPhone, donorCity));
                        System.out.println("Donor added successfully!");
                        break;

                    case 2:
                        if (donors.isEmpty()) {
                            System.out.println("No donors available!");
                        } else {
                            System.out.println("List of Donors:");
                            for (Donor donor : donors) {
                                System.out.println(donor);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter Blood Group to search: ");
                        String searchGroup = scanner.nextLine();
                        boolean foundDonor = false;
                        for (Donor donor : donors) {
                            if (donor.getBloodGroup().equalsIgnoreCase(searchGroup)) {
                                System.out.println(donor);
                                foundDonor = true;
                            }
                        }
                        if (!foundDonor) {
                            System.out.println("No donors found with blood group " + searchGroup);
                        }
                        break;

                    case 4:
                        System.out.println("Exiting Donor Module...");
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } else if (userType == 2) {
            while (true) {
                System.out.println("\nRecipient Module");
                System.out.println("1. Register Recipient");
                System.out.println("2. View Recipients");
                System.out.println("3. Request Blood");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Recipient Name: ");
                        String recipientName = scanner.nextLine();
                        System.out.print("Enter Blood Group: ");
                        String recipientBloodGroup = scanner.nextLine();
                        System.out.print("Enter Phone: ");
                        String recipientPhone = scanner.nextLine();
                        System.out.print("Enter City: ");
                        String recipientCity = scanner.nextLine();

                        recipients.add(new Recipient(recipientName, recipientBloodGroup, recipientPhone, recipientCity));
                        System.out.println("Recipient registered successfully!");
                        break;

                    case 2:
                        if (recipients.isEmpty())
                        {
                            System.out.println("No recipients available!");
                        } else
                        {
                            System.out.println("List of Recipients:");
                            for (Recipient recipient : recipients) {
                                System.out.println(recipient);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter Blood Group to search for donors: ");
                        String neededBloodGroup = scanner.nextLine();
                        boolean foundRecipient = false;
                        for (Donor donor : donors)
                        {
                            if (donor.getBloodGroup().equalsIgnoreCase(neededBloodGroup)) {
                                System.out.println("Matching Donor Found: " + donor);
                                foundRecipient = true;
                            }
                        }
                        if (!foundRecipient)
                        {
                            System.out.println("No donors found for blood group " + neededBloodGroup);
                        }
                        break;

                    case 4:
                        System.out.println("Exiting Recipient Module...");
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } else
        {
            System.out.println("Invalid selection! Exiting...");
        }
    }
}
