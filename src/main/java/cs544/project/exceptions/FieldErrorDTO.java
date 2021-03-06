package cs544.project.exceptions;

/**
 * This DTO which contains the information of a single validation error.
 * 
 * @author rXing
 *
 */
public class FieldErrorDTO {
	private String field;

	private String message;

	public FieldErrorDTO(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FieldErrorDTO [field=" + field + ", message=" + message + "]";
	}

}
