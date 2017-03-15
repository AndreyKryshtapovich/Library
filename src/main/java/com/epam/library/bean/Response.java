package com.epam.library.bean;

import java.util.List;

import com.epam.library.domain.Book;

public class Response {
	
	private boolean errorStatus;
	private String errorMessage;
	private String simpleMessage;
	private List<Book> bookList;
	private List<ReportLineGThanOneBook> reportEmplWithGThanOneBook;
	private List<ReportLineLQThanTwoBooks> reportEmplWithLQThanTwoBooks;
	
	public Response(){
		
	}

	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSimpleMessage() {
		return simpleMessage;
	}

	public void setSimpleMessage(String simpleMessage) {
		this.simpleMessage = simpleMessage;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<ReportLineGThanOneBook> getReportEmplWithGThanOneBook() {
		return reportEmplWithGThanOneBook;
	}

	public void setReportEmplWithGThanOneBook(List<ReportLineGThanOneBook> reportEmplWithGThanOneBook) {
		this.reportEmplWithGThanOneBook = reportEmplWithGThanOneBook;
	}

	public List<ReportLineLQThanTwoBooks> getReportEmplWithLQThanTwoBooks() {
		return reportEmplWithLQThanTwoBooks;
	}

	public void setReportEmplWithLQThanTwoBooks(List<ReportLineLQThanTwoBooks> reportEmplWithLQThanTwoBooks) {
		this.reportEmplWithLQThanTwoBooks = reportEmplWithLQThanTwoBooks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookList == null) ? 0 : bookList.hashCode());
		result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + (errorStatus ? 1231 : 1237);
		result = prime * result + ((reportEmplWithGThanOneBook == null) ? 0 : reportEmplWithGThanOneBook.hashCode());
		result = prime * result
				+ ((reportEmplWithLQThanTwoBooks == null) ? 0 : reportEmplWithLQThanTwoBooks.hashCode());
		result = prime * result + ((simpleMessage == null) ? 0 : simpleMessage.hashCode());
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
		Response other = (Response) obj;
		if (bookList == null) {
			if (other.bookList != null)
				return false;
		} else if (!bookList.equals(other.bookList))
			return false;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (errorStatus != other.errorStatus)
			return false;
		if (reportEmplWithGThanOneBook == null) {
			if (other.reportEmplWithGThanOneBook != null)
				return false;
		} else if (!reportEmplWithGThanOneBook.equals(other.reportEmplWithGThanOneBook))
			return false;
		if (reportEmplWithLQThanTwoBooks == null) {
			if (other.reportEmplWithLQThanTwoBooks != null)
				return false;
		} else if (!reportEmplWithLQThanTwoBooks.equals(other.reportEmplWithLQThanTwoBooks))
			return false;
		if (simpleMessage == null) {
			if (other.simpleMessage != null)
				return false;
		} else if (!simpleMessage.equals(other.simpleMessage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Response [errorStatus=" + errorStatus + ", errorMessage=" + errorMessage + ", simpleMessage="
				+ simpleMessage + ", bookList=" + bookList + ", reportEmplWithGThanOneBook="
				+ reportEmplWithGThanOneBook + ", reportEmplWithLQThanTwoBooks=" + reportEmplWithLQThanTwoBooks + "]";
	}
}
