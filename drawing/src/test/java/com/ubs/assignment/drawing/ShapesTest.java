package com.ubs.assignment.drawing;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ShapesTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ShapesTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ShapesTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCanvas()
    {
    	Shapes s = new Shapes();
    	char[][] canvas = s.drawCanvas(4, 5);
        assertTrue( canvas.length == 7 );
        assertTrue( canvas[0].length == 4 );
    }
    
    public void testLine()
    {
    	Shapes s = new Shapes();
    	char[][] canvas = s.drawCanvas(20, 4);
    	s.drawLine(canvas, 1, 2, 6, 2);
    	assertTrue(canvas[2][1] == 'x');
    	assertTrue(canvas[2][4] == 'x');
    	assertTrue(canvas[2][6] == 'x');
    }
    
    public void testRectangle() 
    {
    	Shapes s = new Shapes();
    	char[][] canvas = s.drawCanvas(20, 4);
    	s.drawRectangle(canvas, 14, 1, 18, 3);
    	assertTrue(canvas[3][14] == 'x');
    	assertTrue(canvas[2][18] == 'x');    	
    	assertFalse(canvas[4][18] == 'x');
    }
    
    public void testColor()
    {
    	Shapes s = new Shapes();
    	char[][] canvas = s.drawCanvas(20, 4);
    	s.drawLine(canvas, 1, 2, 6, 2);
    	s.drawLine(canvas, 6, 3, 6, 4);
    	s.drawRectangle(canvas, 14, 1, 18, 3);
    	s.colourArea(canvas, 3, 10, 'o', canvas[3][10]);
    	assertTrue(canvas[3][10] == 'o');
    	assertTrue(canvas[2][18] == 'x');
    	assertFalse(canvas[3][2] == 'x');
    	
    	s.drawLine(canvas, 6, 4, 13, 4);
    	s.colourArea(canvas, 2, 1, '.', canvas[2][1]);
    	assertTrue(canvas[3][10] == 'o');
    	assertTrue(canvas[4][6] == '.');
    }
    
}
