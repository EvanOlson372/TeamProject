package code.ui;

import java.util.Scanner;

import javax.swing.SwingUtilities;

import code.textBasedUI.TextBasedUI;

public class UIDriver {

	private static TextBasedUI textBased;
	private static POSGUI posGUI;
	
	
	public static void main(String[] args) {
		
	
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\n                              (1) Text");
		System.out.println("\n                              (2) GUI");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		switch (input) {
		case "1":
			textBased = new TextBasedUI();
			textBased.run();
			
			break;
		case "2":
				SwingUtilities.invokeLater(new POSGUI());
			break;
		
		}
	}

}
