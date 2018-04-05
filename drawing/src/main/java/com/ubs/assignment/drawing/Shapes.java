package com.ubs.assignment.drawing;


public class Shapes {
	
	private char[][] canvas = null;

	public char[][] drawCanvas(int w, int h) {
			
		canvas = new char[h+2][w];
			for(int i=0; i<canvas.length; i++) {
				for(int j=0; j<canvas[0].length; j++) {
					if(i==0 || i==h+1) {
						canvas[i][j] = '-';
					}else {
						canvas[i][0] = '|';
						canvas[i][w-1] = '|';
					}
				}
				
			}
			
			return canvas;
		}
	
	public void drawLine(char[][] canvas, int x1, int y1, int x2, int y2){
		
		if(x1 == x2) {
			for(int i = y1; i <= y2; i++) {
				canvas[i][x1] = 'x';
			}
		}
		
		if(y1 == y2) {
			for(int i = x1; i <= x2; i++) {
				canvas[y1][i] = 'x';
			}
		}
		
	}
	
	public void drawRectangle(char[][] canvas, int x1, int y1, int x2, int y2){
	
		this.drawLine(canvas, x1, y1, x2, y1);
		this.drawLine(canvas, x1, y1, x1, y2);
		this.drawLine(canvas, x1, y2, x2, y2);
		this.drawLine(canvas, x2, y1, x2, y2);
	}
	
	public void colourArea(char[][] canvas, int x1, int y1, char c, char p) {
	
		if(canvas[x1][y1] != p) {
			return;
		}
		if(canvas[x1][y1] == p) {
			canvas[x1][y1] = c;
			colourArea(canvas, x1 + 1, y1, c, p);
			colourArea(canvas, x1, y1 + 1, c, p);
			colourArea(canvas, x1 - 1, y1, c, p);
			colourArea(canvas, x1, y1 - 1, c, p);
		}
		
	}
	
	public void printCanvas(char[][] canvas) {
		for(int i=0;i<canvas.length;i++) {
			for(int j=0;j<canvas[0].length;j++) {
				System.out.print(canvas[i][j]);
			}
			System.out.println();
		}
	}
}