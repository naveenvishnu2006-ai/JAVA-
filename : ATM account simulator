import java.sql.Connection; import java.sql.DriverManager;
import java.sql.PreparedStatement; import java.sql.ResultSet;
import java.sql.SQLException; import java.util.Scanner;

public class ATMSimulator {
private static final String DB_URL = "jdbc:mysql://localhost:3306/bank_db"; private static final String USER = "root";
private static final String PASS = "password";

public static void main(String[] args) { Scanner scanner = new Scanner(System.in);
System.out.println("===================================");
System.out.println("	ATM ACCOUNT SIMULATOR"); System.out.println("===================================");

try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS))

{






AND pin=?";

{


System.out.print("Enter Account Number: "); String accNo = scanner.nextLine(); System.out.print("Enter PIN: ");
String pin = scanner.nextLine();

String authQuery = "SELECT name, balance FROM users WHERE accNo=? try (PreparedStatement authStmt = conn.prepareStatement(authQuery))
authStmt.setString(1, accNo); authStmt.setString(2, pin);
ResultSet rs = authStmt.executeQuery();

if (rs.next()) {
String name = rs.getString("name"); double balance = rs.getDouble("balance"); System.out.println("

Login Successful! Welcome, " + name + ".");

boolean active = true; while (active) {
System.out.println("

Main Menu:");


System.out.println("1. Check Balance"); System.out.println("2. Withdraw Cash"); System.out.println("3. Deposit Cash"); System.out.println("4. Exit"); System.out.print("Enter choice: ");
int choice = scanner.nextInt();

switch (choice) { case 1:

System.out.println("	");
System.out.printf("Your Current Balance is: Rs.
%.2f
", balance);

System.out.println("	");
break; case 2:
System.out.print("Enter amount to withdraw: "); double withdrawAmt = scanner.nextDouble();
if (withdrawAmt > 0 && withdrawAmt <= balance) { balance -= withdrawAmt;
updateBalance(conn, accNo, balance); System.out.println("Cash dispensed

successfully.");


funds or invalid amount.");


} else {
System.out.println("Error: Insufficient










successfully.");


amount.");

}
break; case 3:
System.out.print("Enter amount to deposit: "); double depositAmt = scanner.nextDouble();
if (depositAmt > 0) { balance += depositAmt;
updateBalance(conn, accNo, balance); System.out.println("Cash deposited

} else {
System.out.println("Error: Invalid deposit





Goodbye!");




again.");

}
break; case 4:
System.out.println("Thank you for using our ATM.

active = false; break;
default:
System.out.println("Invalid choice. Try

}
}

} else {
System.out.println("
Authentication Failed. Invalid Account Number or PIN.");
}
}
} catch (SQLException e) {
System.out.println("Database Connection Error: " + e.getMessage());
} finally {
scanner.close();
}
}

private static void updateBalance(Connection conn, String accNo, double newBalance) throws SQLException {
String updateQuery = "UPDATE users SET balance=? WHERE accNo=?";

 

