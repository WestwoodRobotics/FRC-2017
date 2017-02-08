package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.commands.Roll;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private static Roller instance;
	
	CANTalon rollerSIM = new CANTalon(5);
	
    public void initDefaultCommand() {
        setDefaultCommand(new Roll());
    }
    
    public static Roller getInstance(){
    	if(instance == null)instance = new Roller();
    	return instance;
    }
    
    public void roll(double speed){
    	rollerSIM.set(speed);
    }
}

