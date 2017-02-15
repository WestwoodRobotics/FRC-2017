package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.commands.OperateFlap;
import org.usfirst.frc.team2583.robot.RobotMap;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallFlap extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	static BallFlap instance;
	CANTalon windowMotor = new CANTalon(RobotMap.windowTalon);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new OperateFlap());
    }
    
    public void runMotor(double speed){
    	windowMotor.set(speed);
    }
    
}

