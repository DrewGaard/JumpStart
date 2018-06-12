import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import acm.graphics.*;
import acm.program.*;



public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	private WorkoutSpec user;
	
	private SomePane somePane;
	private MenuPane menu;
	private TypeSelectPane typeSelect;
	private BulkingMuscleOptionPane bulkingSelect;
	private CuttingMuscleOptionPane cuttingSelect;
	private StatisticsPane statSelect;
	private NotesPane noteSelect;
	private CardioPane cardioSelect;
	private MainWorkoutPane workoutSelect;
	private DifficultyPane difficultySelect;
	private CustomWorkoutPane custom;
	private Counts workoutCounts;
	private GImage customImage;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void run() {
		user = new WorkoutSpec(null, null, null);
		somePane = new SomePane(this);
		menu = new MenuPane(this);
		typeSelect = new TypeSelectPane(this);
		bulkingSelect = new BulkingMuscleOptionPane(this);
		cuttingSelect = new CuttingMuscleOptionPane(this);
		statSelect = new StatisticsPane(this);
		try {
			noteSelect = new NotesPane(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cardioSelect = new CardioPane(this);
		workoutSelect = new MainWorkoutPane(this);
		difficultySelect = new DifficultyPane(this);
		custom = new CustomWorkoutPane(this);
		setupInteractions();
		switchToSome();
	}
	
	/* Method: setupInteractions
	 * -------------------------
	 * must be called before switching to another
	 * pane to make sure that interactivity
	 * is setup and ready to go.
	 */
	private void setupInteractions() {
		requestFocus();
		addKeyListeners();
		addMouseListeners();
	}
	
	public void switchBack() {
		switchToScreen(menu);
	}
	
	public void switchToSome() {
		switchToScreen(somePane);
	}
	
	public void switchToTypeSelect() {
		switchToScreen(typeSelect);
	}
	
	public void BulkingMuscleOptionPane() {
		switchToScreen(bulkingSelect);
	}
	
	public void CuttingMuscleOptionPane() {
		switchToScreen(cuttingSelect);
	}
	public void switchToStatisticsPane(){
		switchToScreen(statSelect);
	}
	public void switchToNotesPane(){
		switchToScreen(noteSelect);
	}
	public void CardioPane(){
		switchToScreen(cardioSelect);
	}
	public void switchToMainWorkoutPane(){
		switchToScreen(workoutSelect);
	}
	public void switchToDiffcultyScreen(){
		switchToScreen(difficultySelect);
	}
	public void switchToCustom() {
		switchToScreen(custom);
	}
	public WorkoutSpec get_wspec(){
		return user;
	}
	public Counts get_counts(){
		workoutCounts = new Counts();
		return workoutCounts;
	}
	public void set_Custom_img(GImage custom_img){
		customImage = custom_img;
	}
	public GImage get_Custom_img(){
		return customImage;
	}
}
