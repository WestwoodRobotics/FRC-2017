package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.RobotMap;
import org.usfirst.frc.team2583.robot.commands.Grab;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {

	Spark grabber = new Spark(RobotMap.grabberSpark);

    public void initDefaultCommand() {
    	setDefaultCommand(new Grab());
    }
    
    public void move(double speed){
    	grabber.set(speed);
    }
}

