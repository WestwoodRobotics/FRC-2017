package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.Robot;
import org.usfirst.frc.team2583.robot.RobotMap;
import org.usfirst.frc.team2583.robot.commands.Drive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{

	CANTalon frontleft = new CANTalon(RobotMap.fLeft);
	CANTalon backleft = new CANTalon(RobotMap.bLeft);
	CANTalon frontright = new CANTalon(RobotMap.fRight);
	CANTalon backright = new CANTalon(RobotMap.bRight);
	RobotDrive drive = new RobotDrive(frontleft, backleft, frontright, backright);
	
	private double leftSpeed = 0;
	private double rightSpeed = 0;
	
	public DriveTrain(){
		super("DriveTrain");
		frontleft.setInverted(true);
		backleft.setInverted(true);
		frontright.setInverted(true);
		backright.setInverted(true);
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
		Robot.sensors.getAngle();
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
}
