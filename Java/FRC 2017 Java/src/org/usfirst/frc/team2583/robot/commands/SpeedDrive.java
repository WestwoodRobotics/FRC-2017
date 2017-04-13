package org.usfirst.frc.team2583.robot.commands;

import org.usfirst.frc.team2583.robot.Robot;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpeedDrive extends Command {

	private double distGoal;
	
    public SpeedDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }
    
    public SpeedDrive(double driveDist) {
    	this();
    	distGoal = driveDist;  // target distance to drive
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.setEncoderPIDType(PIDSourceType.kRate);
    	Robot.driveRT.setSetpoint(5.0); // set speed
    	Robot.driveRT.enable();         // start PID control
    	Robot.driveLF.setSetpoint(5.0); // set speed
    	Robot.driveLF.enable();         // start PID control
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.pidDrive();  // drive at rates set by PID controllers
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// stop at position
        return (Robot.drivetrain.getLeftDistance()+Robot.drivetrain.getRightDistance())/2 > distGoal;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive(0.0, 0.0);
    	Robot.driveRT.disable();  // disable pid loop
    	Robot.driveLF.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
