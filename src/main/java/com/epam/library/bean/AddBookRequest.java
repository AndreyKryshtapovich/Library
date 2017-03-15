package com.epam.library.bean;

public class AddBookRequest extends Request  {

	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String brief;
	private Integer publishYear;
	
	public AddBookRequest(){
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Integer getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + ((publishYear == null) ? 0 : publishYear.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddBookRequest other = (AddBookRequest) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (publishYear == null) {
			if (other.publishYear != null)
				return false;
		} else if (!publishYear.equals(other.publishYear))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddBookRequest [title=" + title + ", author=" + author + ", brief=" + brief + ", publishYear="
				+ publishYear + "]";
	}
	
}
