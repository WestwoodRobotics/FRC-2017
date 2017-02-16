package org.usfirst.frc.team2583.robot.commands;

import org.usfirst.frc.team2583.robot.OI;
import org.usfirst.frc.team2583.robot.Robot;
import org.usfirst.frc.team2583.robot.RobotMap;
import org.usfirst.frc.team2583.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command{

	DriveTrain drivetrain = Robot.drivetrain;
	OI oi = Robot.oi;
	
	public Drive(){
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		this.setInterruptible(true);
		
	}

	@Override
	protected void execute() {
		double left = Robot.oi.x1.getRawAxis(RobotMap.leftAxis) * (RobotMap.reverseToggle ? -1 : 1) * (RobotMap.slowToggle ? RobotMap.maxSlow : RobotMap.maxSpeed);
		double right = Robot.oi.x1.getRawAxis(RobotMap.rightAxis) * (RobotMap.reverseToggle ? -1 : 1) * (RobotMap.slowToggle ? RobotMap.maxSlow : RobotMap.maxSpeed);
		
		drivetrain.tankDrive(left, right);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
