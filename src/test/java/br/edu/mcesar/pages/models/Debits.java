package br.edu.mcesar.pages.models;

public class Debits {
	
	private String name;
	private String value;
	private Enum<Status> status;

	public Debits(String name, String value, Enum<Status> status) {
		super();
		this.name = name;
		this.value = value;
		this.status = status;
	}

	public enum Status {
	    PAGO, AGENDADO, PENDENTE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Enum<Status> getStatus() {
		return status;
	}

	public void setStatus(Enum<Status> status) {
		this.status = status;
	}
}
