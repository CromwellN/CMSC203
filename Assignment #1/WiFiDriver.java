import java.util.Scanner;

public class WiFiDriver {

	public static void main(String[] args) {
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.");
		
		System.out.println("\nReboot the computer and try to connect");
		Scanner myobj = new Scanner(System.in);
		
		System.out.println("\nDid that fix the problem? (yes/No) :");
		String userInput = myobj.nextLine();
		if(userInput.equals("yes")) {
			System.out.println("Rebooting your computer seemed to work");
			System.exit(0);
		}
		else{
			System.out.println("Reboot the computer and try to connect");
			System.out.println("\nDid that fix the problem? (yes/No) :" );
			userInput = myobj.nextLine();
			if(userInput.equals("yes")) {
				System.out.println("Rebooting your computer seemed to work");
				System.exit(0);
			}
			else{
				System.out.println("Make sure the cables connecting the router are fimly plugged in and power is getting to the router");
				System.out.println("\nDid that fix the problem? (yes/No) :" );
				userInput = myobj.nextLine();
				if(userInput.equals("yes")) {
					System.out.println("Checking the router's cables seemed to work");
					System.exit(0);
				}
				else {
					System.out.println("\nMove the computer closer to the router and try to connect");
					System.out.println("\nDid that fix the problem? (yes/No) :" );
					userInput = myobj.nextLine();
					if (userInput.equals("yes")) {
						System.out.println("Moving the router's cables seemed to work");
						System.exit(0);
					}
					else {
						System.out.println("\nContact your ISP");
						System.out.println("Make sure your ISP is hooked up to your router.");
						System.exit(0);
					}
					
				}
			
			}
			
		}
	}

}
