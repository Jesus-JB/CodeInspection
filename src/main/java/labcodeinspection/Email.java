package labcodeinspection;

import java.util.Locale;

/**
 * Representa la cuenta de correo institucional de un empleado.
 */
public class Email {

	/** Nombre del empleado. */
	private final String firstName;
	/** Apellido del empleado. */
	private final String lastName;
	/** Contraseña generada para la cuenta. */
	private String password;
	/** Departamento al que pertenece el empleado. */
	private String department;
	/** Longitud por defecto de la contraseña generada. */
	private final int defaultPasswordLength = 8;
	/** Dirección de correo generada. */
	private String email;

	/**
	 * Crea un correo para el empleado indicado.
	 *
	 * @param firstName nombre del empleado
	 * @param lastName  apellido del empleado
	 */
	public Email(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Muestra por consola la información de la cuenta.
	 */
	@SuppressWarnings("PMD.SystemPrintln")
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + firstName + "\nLAST NAME= " + lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}

	/**
	 * Asigna el departamento según el código elegido.
	 *
	 * @param depChoice 1 = ventas, 2 = desarrollo, 3 = contabilidad
	 */
	public void setDeparment(final int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			this.department = "general";
			break;
		}
	}

	private String randomPassword(final int length) {
		final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		final char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			final int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}

	/**
	 * Genera la contraseña y la dirección de correo del empleado.
	 */
	public void generateEmail() {
		this.password = this.randomPassword(this.defaultPasswordLength);
		this.email = this.firstName.toLowerCase(Locale.ROOT) + this.lastName.toLowerCase(Locale.ROOT) + "@"
				+ this.department + ".espol.edu.ec";
	}
}
