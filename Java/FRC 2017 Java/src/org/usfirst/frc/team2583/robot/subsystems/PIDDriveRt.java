package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.Robot;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PIDDriveRt extends PIDSubsystem {

	// Initialize your subsystem here
    public PIDDriveRt() {
    	super("PIDDriveRt",0.3,0.0,0.0);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	
    	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return Robot.drivetrain.getPIDRight();
        // return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	Robot.drivetrain.setRightSpeed(output);  // set variable in driveTrain
    }
}
