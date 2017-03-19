package org.usfirst.frc.team2583.robot.commands;

import org.usfirst.frc.team2583.robot.Robot;
import org.usfirst.frc.team2583.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UpdateDash extends Command {

    public UpdateDash() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Populates the driverstation's dashboard with variable values
     */
    protected void execute() {
    	SmartDashboard.putNumber("Left Encoder", Robot.drivetrain.getLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.drivetrain.getRightEncoder());
		
		SmartDashboard.putNumber("Left Speed", Math.abs(Robot.drivetrain.getLSpeed()));
		SmartDashboard.putNumber("Right Speed", Math.abs(Robot.drivetrain.getRSpeed()));
		
		SmartDashboard.putBoolean("Reversed", RobotMap.reverseToggle);
		SmartDashboard.putBoolean("Fast", RobotMap.fastToggle);
		SmartDashboard.putBoolean("Slow", RobotMap.slowToggle);
		
		SmartDashboard.putNumber("X Accel", Robot.drivetrain.getXAccel());
		SmartDashboard.putNumber("Y Accel", Robot.drivetrain.getYAccel());
		SmartDashboard.putNumber("Z Accel", Robot.drivetrain.getZAccel());
		
		SmartDashboard.putNumber("Horizontal Heading", Math.sin(Math.toRadians(Robot.drivetrain.getGyroAngle())) * 50 + 50);
		SmartDashboard.putNumber("Vertical Heading", Math.cos(Math.toRadians(Robot.drivetrain.getGyroAngle())) * 50 + 50);
		
		Robot.drivetrain.updateVectors();
		
		SmartDashboard.putNumber("X Velocity", Robot.drivetrain.getXVel());
		SmartDashboard.putNumber("Y Velocity", Robot.drivetrain.getYVel());
		SmartDashboard.putNumber("Z Velocity", Robot.drivetrain.getZVel());
		
		SmartDashboard.putNumber("X Position", Robot.drivetrain.getXPos());
		SmartDashboard.putNumber("Y Position", Robot.drivetrain.getYPos());
		SmartDashboard.putNumber("Z Position", Robot.drivetrain.getZPos());
		
		SmartDashboard.putNumber("Gears", RobotMap.gearsPlaced);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
