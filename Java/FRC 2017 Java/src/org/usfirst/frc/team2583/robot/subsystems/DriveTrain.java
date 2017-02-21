package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.RobotMap;
import org.usfirst.frc.team2583.robot.commands.Drive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{

	private CANTalon frontleft = new CANTalon(RobotMap.fLeft);
	private CANTalon backleft = new CANTalon(RobotMap.bLeft);
	private CANTalon frontright = new CANTalon(RobotMap.fRight);
	private CANTalon backright = new CANTalon(RobotMap.bRight);
	private RobotDrive drive = new RobotDrive(frontleft, backleft, frontright, backright);
	
	private Encoder rightEnc = new Encoder(RobotMap.driveRightA, RobotMap.driveRightB, false, Encoder.EncodingType.k4X);
	private Encoder leftEnc = new Encoder(RobotMap.driveLeftA, RobotMap.driveLeftB, false, Encoder.EncodingType.k4X);
	
	
	private double leftSpeed = 0;
	private double rightSpeed = 0;
	
	public DriveTrain(){
		frontleft.setInverted(true);
		backleft.setInverted(true);
		frontright.setInverted(true);
		backright.setInverted(true);
		
		rightEnc.setReverseDirection(true);
		
		leftEnc.reset();
		rightEnc.reset();
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
	
	public void tankDrive(double left, double right){
		if(!RobotMap.reverseToggle)drive.tankDrive(left, right);
		else drive.tankDrive(right, left);
		
		leftSpeed = left;
		rightSpeed = right;
	}
	
	/**
	 * 
	 * @return the current speed of the right motors
	 */
	public double getRSpeed(){
		return rightSpeed;
	}
	
	/**
	 * 
	 * @return the current speed of the left motors
	 */
	public double getLSpeed(){
		return leftSpeed;
	}
	
	public int getLeftEncoder(){
		return leftEnc.get();
	}
	
	public int getRightEncoder(){
		return rightEnc.get();
	}
	
	public void resetLeftEncoder(){
		leftEnc.reset();
	}
	
	public void resetRightEncoder(){
		rightEnc.reset();
	}
	
	public void resetEncoders(){
		leftEnc.reset();
		rightEnc.reset();
	}
}
