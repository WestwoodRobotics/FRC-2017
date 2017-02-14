package org.usfirst.frc.team2583.robot.commands;

import org.usfirst.frc.team2583.robot.OI;
import org.usfirst.frc.team2583.robot.Robot;
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
		drivetrain.tankDrive(oi.x1.getLeftY(), oi.x1.getRightY());
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
