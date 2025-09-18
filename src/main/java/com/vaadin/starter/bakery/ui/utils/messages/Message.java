package com.vaadin.starter.bakery.ui.utils.messages;

/**
 * Utility class for standard messages and dialog captions in the Bakery application.
 * <p>
 * Provides constants and factory methods for confirmation and error dialogs.
 * </p>
 *
 * @author GitHub Copilot
 */
public class Message {

	/**
	 * Caption for delete confirmation dialogs.
	 */
	public static final String CONFIRM_CAPTION_DELETE = "Confirm Delete";
	/**
	 * Message for delete confirmation dialogs.
	 */
	public static final String CONFIRM_MESSAGE_DELETE = "Are you sure you want to delete the selected Item? This action cannot be undone.";
	/**
	 * Caption for delete button.
	 */
	public static final String BUTTON_CAPTION_DELETE = "Delete";
	/**
	 * Caption for cancel button.
	 */
	public static final String BUTTON_CAPTION_CANCEL = "Cancel";

	/**
	 * Message supplier for unsaved changes dialog.
	 */
	public static final MessageSupplier UNSAVED_CHANGES = createMessage("Unsaved Changes", "Discard", "Continue Editing",
			"There are unsaved modifications to the %s. Discard changes?");

	/**
	 * Message supplier for delete confirmation dialog.
	 */
	public static final MessageSupplier CONFIRM_DELETE = createMessage(CONFIRM_CAPTION_DELETE, BUTTON_CAPTION_DELETE,
			BUTTON_CAPTION_CANCEL, CONFIRM_MESSAGE_DELETE);

	private final String caption;
	private final String okText;
	private final String cancelText;
	private final String message;

	/**
	 * Constructs a message with the given caption, button texts, and message body.
	 *
	 * @param caption dialog caption
	 * @param okText OK button text
	 * @param cancelText Cancel button text
	 * @param message message body
	 */
	public Message(String caption, String okText, String cancelText, String message) {
		this.caption = caption;
		this.okText = okText;
		this.cancelText = cancelText;
		this.message = message;
	}

	/**
	 * Creates a MessageSupplier for parameterized messages.
	 *
	 * @param caption dialog caption
	 * @param okText OK button text
	 * @param cancelText Cancel button text
	 * @param message message body (can be formatted)
	 * @return MessageSupplier instance
	 */
	private static MessageSupplier createMessage(String caption, String okText, String cancelText, String message) {
		return (parameters) -> new Message(caption, okText, cancelText, String.format(message, parameters));
	}

	/**
	 * Gets the dialog caption.
	 *
	 * @return caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * Gets the OK button text.
	 *
	 * @return OK button text
	 */
	public String getOkText() {
		return okText;
	}

	/**
	 * Gets the cancel button text.
	 *
	 * @return cancel button text
	 */
	public String getCancelText() {
		return cancelText;
	}

	/**
	 * Gets the message body.
	 *
	 * @return message body
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Functional interface for supplying parameterized messages.
	 */
	@FunctionalInterface
	public interface MessageSupplier {
		/**
		 * Creates a message with the given parameters.
		 *
		 * @param parameters parameters for formatting the message
		 * @return Message instance
		 */
		Message createMessage(Object... parameters);
	}
}
