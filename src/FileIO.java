import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileIO {
	
	/*
	 * Reads in doubles from a file.  Just pass the filename in as a string.
	 * Returns an ArrayList<Double> with the data from the file
	 * 
	 */
	
	public static ArrayList<Double> readData(String Filename){
		Scanner scan = null;
		FileInputStream in = null;
		ArrayList<Double> data = new ArrayList<Double>();
		try {
			in = new FileInputStream(Filename);
			scan = new Scanner(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scan.hasNextDouble()){
			try {
				data.add(scan.nextDouble());
			}
			catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}
		scan.close();
		try {
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public ArrayList<String> readDataString(String Filename){
		Scanner scan = null;
		FileInputStream in = null;
		ArrayList<String> data = new ArrayList<String>();
		try {
			in = new FileInputStream(Filename);
			scan = new Scanner(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scan.hasNextDouble()){
			try {
				data.add(scan.toString());
			}
			catch (InputMismatchException e) {
				e.printStackTrace();
			}
		}
		scan.close();
		try {
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	public void storeText(String text, String Filename){
		PrintWriter storeText = null;
		try {
			storeText = new PrintWriter(Filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		storeText.println(text);
		storeText.close();
	}
	
	public static void storeData(ArrayList<Double> data, String Filename){
		PrintWriter storeData = null;
		try{
			storeData = new PrintWriter(Filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < data.size(); i++){
			storeData.print(data.get(i)+" ");
		}
		storeData.close();
	}
	
	public static String readText(String Filename){
		String content_in_textbox = null;
		try {
			content_in_textbox = new Scanner(new File(Filename)).useDelimiter("\\Z").next();
			//System.out.println(content);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content_in_textbox;
	}
}
