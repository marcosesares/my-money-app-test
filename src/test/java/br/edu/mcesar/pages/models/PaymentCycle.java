package br.edu.mcesar.pages.models;

import java.util.List;

public class PaymentCycle {

	private String name;
	private Integer month;
	private Integer year;
	private List<Credits> credits;
	private List<Debits> debits;

	public PaymentCycle(String name, Integer month, Integer year, List<Credits> credits, List<Debits> debits) {
		super();
		this.name = name;
		this.month = month;
		this.year = year;
		this.credits = credits;
		this.debits = debits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<Credits> getCredits() {
		return credits;
	}

	public void setCredits(List<Credits> credits) {
		this.credits = credits;
	}

	public List<Debits> getDebits() {
		return debits;
	}

	public void setDebits(List<Debits> debits) {
		this.debits = debits;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

}
