public class NumberGuessingGame {

	public static void main(String[] args) {
		System.out.println("------------------------------- ");
		System.out.println("WELCOME TO CODTECH IT SOLUTIONS ");
		System.out.println("------------------------------- ");
		System.out.println("NUMBER GUESSING GAME BETWEEN 1 TO 100");
		System.out.println("--------------------");
		Random rand = new Random();
		int number = rand.nextInt(1, 100);
		int guess, count = 7;
		try (Scanner sc = new Scanner(System.in)) {
			while (count != 0) {
				while (true) {
					try {
						System.out.println("Chances left: " + count--);
						System.out.println("Enter an integer to guess the exact number: ");
						guess = sc.nextInt();
						if (guess > 100 || guess <= 0) {
							throw new Exception();
						}
						break;
					} catch (InputMismatchException e) {
						System.err.println("ENTER ONLY INTEGERS");
						sc.next();
					} catch (Exception e) {
						System.err.println("NUMBER SHOULD BE BETWEEN 1 AND 100");
					}
				}
				if (guess > number) {
					System.out.println("TOO HIGH");
				} else if (guess < number) {
					System.out.println("TOO LOW");
				} else {
					System.out.println("HURRAY..!YOU WIN");
					System.exit(0);
				}
			}
			if(count==0) System.out.println("YOU LOSE...TRY AGAIN\nYOUR NUMBER IS "+number);
		}
	}
}