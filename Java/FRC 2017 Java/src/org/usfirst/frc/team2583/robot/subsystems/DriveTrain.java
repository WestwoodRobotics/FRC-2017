package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.commands.Drive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem{

	private static DriveTrain instance;
	
	CANTalon frontleft = new CANTalon(1);
	CANTalon backleft = new CANTalon(3);
	CANTalon frontright = new CANTalon(4);
	CANTalon backright = new CANTalon(2);
	RobotDrive drive = new RobotDrive(frontleft, backleft, frontright, backright);
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}

	public static DriveTrain getInstance(){
		if(instance == null) instance = new DriveTrain();
		return instance;
	}
	
	public void tankDrive(double left, double right){
		drive.tankDrive(left, right);
	}
}
