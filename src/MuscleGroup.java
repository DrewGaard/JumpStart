
public enum MuscleGroup {
	CHEST, ARMS, SHOULDERS, BACK, LEGS, CORE;
	public String toString(){
		switch (this){
			case CHEST:
				return "chest";
			case ARMS:
				return "arms";
			case SHOULDERS:
				return "shoulders";
			case BACK:
				return "back";
			case LEGS:
				return "legs";
			case CORE:
				return "core";
		}
		return "n/a";
			
	}
}
