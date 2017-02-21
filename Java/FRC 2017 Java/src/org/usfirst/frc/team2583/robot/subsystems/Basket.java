package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Basket extends Subsystem {

    private CANTalon jostler = new CANTalon(RobotMap.jostlerTalon);

    public void initDefaultCommand() {
    	//setDefaultCommand(new JostleBasket());
    }
    
    public void jostle(double speed){
    	jostler.set(speed);
    }
    
    public double getSpeed(){
    	return jostler.get();
    }
}

