package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gate extends Subsystem {

	static boolean open = false;
	
	CANTalon gate = new CANTalon(RobotMap.gateTalon);
	Encoder enc = new Encoder(3, 4, false, Encoder.EncodingType.k4X);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    // TODO: Write this method.
    public void togglePos(){
    	if(open){
    		
    	}else{
    		
    	}
    	
    	open = !open;
    }
}

