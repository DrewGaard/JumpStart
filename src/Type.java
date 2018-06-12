
public enum Type {
	CUTTING, BULKING, CARDIO, CUSTOM;
	public String toString(){
		switch(this){
			case CUTTING:
				return "cutting";
			case BULKING:
				return "bulking";
			case CARDIO:
				return "cardio";
			case CUSTOM:
				return "custom";
		}
		return "n/a";
	}

}
