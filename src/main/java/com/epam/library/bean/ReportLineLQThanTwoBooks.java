package com.epam.library.bean;

import java.sql.Date;

public class ReportLineLQThanTwoBooks {

	private String employeeName;
	private Date emplsDateOfBirth;
	private int numberOfBooks;

	public ReportLineLQThanTwoBooks() {

	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getEmplsDateOfBirth() {
		return emplsDateOfBirth;
	}

	public void setEmplsDateOfBirth(Date emplsDateOfBirth) {
		this.emplsDateOfBirth = emplsDateOfBirth;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((emplsDateOfBirth == null) ? 0 : emplsDateOfBirth.hashCode());
		result = prime * result + numberOfBooks;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportLineLQThanTwoBooks other = (ReportLineLQThanTwoBooks) obj;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (emplsDateOfBirth == null) {
			if (other.emplsDateOfBirth != null)
				return false;
		} else if (!emplsDateOfBirth.equals(other.emplsDateOfBirth))
			return false;
		if (numberOfBooks != other.numberOfBooks)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "["+ employeeName +", "  + emplsDateOfBirth + ":" + numberOfBooks + "]";
	}

}
