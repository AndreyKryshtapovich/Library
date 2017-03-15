package com.epam.library.bean;

public class ReportLineGThanOneBook {
	
	private String employeeName;
	private int numberOfBooks;
	
	public ReportLineGThanOneBook(){
		
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
		ReportLineGThanOneBook other = (ReportLineGThanOneBook) obj;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (numberOfBooks != other.numberOfBooks)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + employeeName  + ":" +  numberOfBooks + "]";
	}
	
	

}
