package org.usfirst.frc.team2583.libraries;

import edu.wpi.first.wpilibj.Joystick;

public class XBoxController extends Joystick{

	// Axes
	public static final int LeftX = 0;
    public static final int LeftY = 1;
    public static final int LeftTriggger = 2;
    public static final int RightTrigger = 3;
    public static final int RightX = 4;
    public static final int RightY = 5;
	
	// Buttons
	public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3;
    public static final int Y = 4;
    public static final int LeftBumper = 5;
    public static final int RightBumper = 6;
    public static final int Back = 7;
    public static final int Start = 8;
    public static final int LeftStick = 9;
    public static final int RightStick = 10;
	
	public XBoxController(int port) {
		super(port);
	}

	public double getLeftX(){
		return getRawAxis(LeftX);
	}
	
	public double getLeftY(){
		return getRawAxis(LeftY);
	}
	
	public double getLeftTrigger(){
		return getRawAxis(LeftTriggger);
	}
	
	public double getRightTrigger(){
		return getRawAxis(RightTrigger);
	}
	
	public double getRightX(){
		return getRawAxis(RightX);
	}
	
	public double getRightY(){
		return getRawAxis(RightY);
	}
	
	public boolean getButtonA(){
		return getRawButton(A);
	}
	
	public boolean getButtonB(){
		return getRawButton(B);
	}
	
	public boolean getButtonX(){
		return getRawButton(X);
	}
	
	public boolean getButtonY(){
		return getRawButton(Y);
	}
	
	public boolean getLeftBumper(){
		return getRawButton(LeftBumper);
	}
	
	public boolean getRightBumper(){
		return getRawButton(RightBumper);
	}
	
	public boolean getButtonBack(){
		return getRawButton(Back);
	}
	
	public boolean getButtonStart(){
		return getRawButton(Start);
	}
	
	public boolean getButtonLeftStick(){
		return getRawButton(LeftStick);
	}
	
	public boolean getButtonRightStick(){
		return getRawButton(RightStick);
	}
}
