package org.usfirst.frc.team2583.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int fLeft = 1;
	public static final int bLeft = 3;
	public static final int fRight = 4;
	public static final int bRight = 2;
	
	public static final int rollerTalon = 5;
    public static final int windowTalon = 6;
    
    // Axis
    public static final int leftAxis = 1;
    public static final int rightAxis = 5;
    
    public static final int joyYAxis = 1;
    
    // Buttons
    public static final int rightBumper = 6;
    public static final int YButton = 4;
    
    public static final int trigger = 1;
    
    // Variables
    public static final double maxDriveAccel = 0.2;
    
    public static boolean rollToggle = false;
    public static boolean reverseToggle = false;
}
