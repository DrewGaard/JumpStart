
public enum DifficultyEnum {
	EASY, MEDIUM, HARD;
	public String toString(){
		switch(this){
			case EASY:
				return "easy";
			case MEDIUM:
				return "medium";
			case HARD:
				return "hard";
		}
		return "n/a";
	}

}
