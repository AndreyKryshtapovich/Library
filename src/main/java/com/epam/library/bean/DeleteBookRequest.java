package com.epam.library.bean;

public class DeleteBookRequest extends Request {
	
	private static final long serialVersionUID = 1L;
	private String targetTitle;
	
	public DeleteBookRequest(){
		
	}

	public String getTargetTitle() {
		return targetTitle;
	}

	public void setTargetTitle(String targetTitle) {
		this.targetTitle = targetTitle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((targetTitle == null) ? 0 : targetTitle.hashCode());
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
		DeleteBookRequest other = (DeleteBookRequest) obj;
		if (targetTitle == null) {
			if (other.targetTitle != null)
				return false;
		} else if (!targetTitle.equals(other.targetTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DeleteBookRequest [targetTitle=" + targetTitle + "]";
	}
	
	

}
