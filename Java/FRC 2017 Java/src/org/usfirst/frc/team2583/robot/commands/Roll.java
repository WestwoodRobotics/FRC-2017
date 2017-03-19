package org.usfirst.frc.team2583.robot.commands;

import org.usfirst.frc.team2583.robot.OI;
import org.usfirst.frc.team2583.robot.Robot;
import org.usfirst.frc.team2583.robot.RobotMap;
import org.usfirst.frc.team2583.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Roll extends Command {

	Roller roller = Robot.roller;
	OI oi = Robot.oi;
	
    public Roll() {
    	requires(roller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Robot.oi.joy.getTrigger()){
    		if(Math.abs(Robot.oi.joy.getRawAxis(RobotMap.joyYAxis)) > 0.1){
    			roller.roll(Robot.oi.joy.getRawAxis(RobotMap.joyYAxis));
    		}else{
    			roller.roll(Robot.oi.x1.getRawAxis(RobotMap.rightTrigger) - Robot.oi.x1.getRawAxis(RobotMap.leftTrigger));
    		}
    	}
    	
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
