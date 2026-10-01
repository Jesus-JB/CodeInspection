package labcodeinspection;

import java.util.Scanner;

/**
 * Aplicación de consola que solicita los datos del empleado y genera su correo.
 */
public final class EmailApp {

	private EmailApp() {
	}

	/**
	 * Punto de entrada de la aplicación.
	 *
	 * @param args argumentos de línea de comandos (no se usan)
	 */
	@SuppressWarnings("PMD.SystemPrintln")
	public static void main(final String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter your first name: ");
			final String firstName = scanner.nextLine();

			System.out.print("Enter your last name: ");
			final String lastName = scanner.nextLine();

			System.out.print("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: ");

			final int depChoice = scanner.nextInt();

			final Email email = new Email(firstName, lastName);
			email.setDeparment(depChoice);
			email.generateEmail();
			email.showInfo();
		}
	}
}
