package models;

import java.time.LocalTime;

public class Transaction {

	private TransactionType type;
	private int value;
	private LocalTime time;
	private String description;

	public Transaction(TransactionType type, int value) {
		super();
		this.type = type;
		this.value = value;
		this.time = LocalTime.now();
	}

	public TransactionType getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

	public LocalTime getTime() {
		return time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
