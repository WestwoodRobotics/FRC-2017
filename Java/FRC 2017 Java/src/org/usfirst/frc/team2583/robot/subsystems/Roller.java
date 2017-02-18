package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.RobotMap;
import org.usfirst.frc.team2583.robot.commands.Roll;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	CANTalon rollerMotor = new CANTalon(RobotMap.rollerTalon);
	
	public Roller() {
		super("Roller");
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new Roll());
    }
    
    public void roll(double speed){
    	rollerMotor.set(speed);
    }
}

