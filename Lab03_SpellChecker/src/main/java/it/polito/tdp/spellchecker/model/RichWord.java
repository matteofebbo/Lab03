package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String richWord;
	private boolean correct;
	
	public RichWord() {
		this.richWord="";
		this.correct=true;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public String getRichWord() {
		return richWord;
	}

	public void setRichWord(String richWord) {
		this.richWord = richWord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((richWord == null) ? 0 : richWord.hashCode());
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
		RichWord other = (RichWord) obj;
		if (richWord == null) {
			if (other.richWord != null)
				return false;
		} else if (!richWord.equals(other.richWord))
			return false;
		return true;
	}
	
	
}
