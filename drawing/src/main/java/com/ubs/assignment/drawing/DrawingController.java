package com.ubs.assignment.drawing;

import java.util.Scanner;

/**
 * Drawing Controller!
 *
 */
public class DrawingController 
{
	private volatile static boolean isDrawActive = true;
	private static char[][] canvas = null;
	
    public static void main( String[] args )
    {
        System.out.println( "Drawing Controller!" );
        System.out.println("Enter Command");
        Scanner sc = null;
        Shapes s = new Shapes();
        
        while(isDrawActive)
        {
        	sc = new Scanner(System.in);
            String command = sc.nextLine();
            String[] arguments = command.split(" ");
            
        	switch(arguments[0])
        	{
        		case "C":
        			int w = getInteger(arguments[1]);
        			int h = getInteger(arguments[2]);
        			
        			canvas = s.drawCanvas(w, h);
        			printCanvas(canvas);
        			
        			break;
        			
        		case "L":
        			int x1 = getInteger(arguments[1]);
        			int y1 = getInteger(arguments[2]);
        			int x2 = getInteger(arguments[3]);
        			int y2 = getInteger(arguments[4]);
        			
        			if(checkIfNull(canvas))
        				continue;
        			
        			s.drawLine(canvas, x1, y1, x2, y2);
        			printCanvas(canvas);
        			
        			break;
        			
        		case "R":
        			x1 = getInteger(arguments[1]);
        			y1 = getInteger(arguments[2]);
        			x2 = getInteger(arguments[3]);
        			y2 = getInteger(arguments[4]);
        			
        			if(checkIfNull(canvas))
        				continue;
        			
        			s.drawRectangle(canvas, x1, y1, x2, y2);
        			printCanvas(canvas);
        			
        			break;
        			
        		case "B":
        			x1 = getInteger(arguments[1]);
        			y1 = getInteger(arguments[2]);
        			char c = arguments[3].toCharArray()[0];
        			
        			if(checkIfNull(canvas))
        				continue;
        			
        			s.colourArea(canvas, y1, x1, c, canvas[y1][x1]);
        			printCanvas(canvas);
        			
        			break;
        			
        		case "Q":
        			isDrawActive = false;
        			
        			break;
        	}
        }

    }
    
    private static int getInteger(String val) {
    	return new Integer(val);
    }
    
    private static boolean checkIfNull(char[][] canvas) {
    	return canvas != null ? false: true;
    }
    
    private static void printCanvas(char[][] canvas) {
		for(int i=0;i<canvas.length;i++) {
			for(int j=0;j<canvas[0].length;j++) {
				System.out.print(canvas[i][j]);
			}
			System.out.println();
		}
	}
}
