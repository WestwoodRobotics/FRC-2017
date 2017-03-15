package org.usfirst.frc.team2583.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// CAN Talon Motors
	public static final int fLeft = 1;
	public static final int bLeft = 3;
	public static final int fRight = 4;
	public static final int bRight = 2;
	
	public static final int rollerTalon = 5;
    public static final int jostlerTalon = 6;
    public static final int windowTalon = 7;
    public static final int climbTalon = 8;
    public static final int grabberVictor = 0;
    
    // Sensors
    public static final int flapTopSwitch = 0;
    public static final int flapBotSwitch = 1;
    
    public static final int gateEncA = 2;
    public static final int gateEncB = 3;
    public static final int driveRightA = 4;
    public static final int driveRightB = 5;
    public static final int driveLeftA = 6;
    public static final int driveLeftB = 7;
    
    // Axis
    public static final int leftYAxis = 1;
    public static final int rightYAxis = 5;
    public static final int rightTrigger = 3;
    
    public static final int joyYAxis = 1;
    
    // Buttons
    public static final int rightBumper = 6;
    public static final int leftBumper = 5;
    public static final int YButton = 4;
    public static final int XButton = 3;
    
    public static final int trigger = 1;
    public static final int barfButton = 6;
    
    // Speed Constants
    public static final double maxFast = 0.85;
    public static final double maxMedium = 0.75;
    public static final double maxSlow = 0.5;
    public static final double jostleSpeed = 1;
    public static final double climbSpeed = 1;
    public static final double rollSpeed = 0.8;
    public static final double autoSpeed = 0.6;
    
    // Other Constants
    public static final double wheelCircumference = 6 * Math.PI; // Circumference of the wheel in inches
    public static final double distancePerEncPulse = 1 / 360 * wheelCircumference;	// Distance traveled per pulse in inches
    public static final double Kp = 0.03;	// Scaling constant for turning with help of gyro
    public static final double g = 32.174;	// Acceleration due to gravity in ft/sec^2
    public static final double accelDeadband = 0.03;
    public static final double clock = 0.02; // Commands are called every 0.02 seconds to update
    
    // Toggle Variables
    public static boolean rollToggle = false;
    public static boolean reverseToggle = false;
    public static boolean fastToggle = false;
    public static boolean slowToggle = false;
}
