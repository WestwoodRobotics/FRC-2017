package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.RobotMap;
import org.usfirst.frc.team2583.robot.commands.Grab;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {

	Talon grabber = new Talon(RobotMap.grabberVictor);

    public void initDefaultCommand() {
    	setDefaultCommand(new Grab());
    }
    
    public void move(double speed){
    	grabber.set(speed);
    }
}

