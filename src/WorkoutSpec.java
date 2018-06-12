
public class WorkoutSpec {
	private MuscleGroup m;
	private Type t;
	//private long time;
	private DifficultyEnum d;
	
	public WorkoutSpec(MuscleGroup muscle, Type type, DifficultyEnum difficulty){
		m = muscle;
		t = type;
		d= difficulty;
		
	}
	
	
	public void setMuscleGroup(MuscleGroup muscG){
		m =muscG ;
	}
	
	public MuscleGroup getMuscleGroup(){
		return m;
	}
	
	public void setType(Type ty){
		t = ty;
	}
	
	public Type getType(){
		return t;
	}
	
	
	public void setDifficulty(DifficultyEnum difficulty){
		d = difficulty;
	}
	
	public DifficultyEnum getDifficulty(){
		return d;
	}

	
	
	
}
