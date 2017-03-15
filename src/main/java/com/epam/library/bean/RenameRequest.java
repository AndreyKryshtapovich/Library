package com.epam.library.bean;

public class RenameRequest extends Request {
	
	private static final long serialVersionUID = 1L;
	private String oldTitle;
	private String newTitle;
	
	public RenameRequest(){
		
	}

	public String getOldTitle() {
		return oldTitle;
	}

	public void setOldTitle(String oldTitle) {
		this.oldTitle = oldTitle;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((newTitle == null) ? 0 : newTitle.hashCode());
		result = prime * result + ((oldTitle == null) ? 0 : oldTitle.hashCode());
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
		RenameRequest other = (RenameRequest) obj;
		if (newTitle == null) {
			if (other.newTitle != null)
				return false;
		} else if (!newTitle.equals(other.newTitle))
			return false;
		if (oldTitle == null) {
			if (other.oldTitle != null)
				return false;
		} else if (!oldTitle.equals(other.oldTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RenameRequest [oldTitle=" + oldTitle + ", newTitle=" + newTitle + "]";
	}
	
	

}
