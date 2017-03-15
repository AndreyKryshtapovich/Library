package com.epam.library.bean;

public class GetBookByTitleRequest extends Request {
	
	private static final long serialVersionUID = 1L;
	private String targetTitle;
	
	public GetBookByTitleRequest(){
		
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
		int result = 1;
		result = prime * result + ((targetTitle == null) ? 0 : targetTitle.hashCode());
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
		GetBookByTitleRequest other = (GetBookByTitleRequest) obj;
		if (targetTitle == null) {
			if (other.targetTitle != null)
				return false;
		} else if (!targetTitle.equals(other.targetTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GetBookByTitleRequest [targetTitle=" + targetTitle + "]";
	}
	
	

}
