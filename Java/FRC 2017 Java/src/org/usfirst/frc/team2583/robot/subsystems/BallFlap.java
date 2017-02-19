package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallFlap extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	DigitalInput limitUp = new DigitalInput(0);
	DigitalInput limitDown = new DigitalInput(1);
	
	public boolean open = true;
	private Spark windowMotor = new Spark(RobotMap.windowSpark);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	//setDefaultCommand(new OperateFlap());
    }
    
    public void initialize(){
    	while(!limitUp.get())
    		runMotor(0.8);
    	runMotor(0);
    }
    
    public void runMotor(double speed){
    	if((speed < 0 && limitDown.get()) || (speed > 1 && limitUp.get())) return;
    	
    	windowMotor.set(speed);
    }
    
    public void togglePos(){
    	while(open ? !limitDown.get() : !limitUp.get()){
    		runMotor(open ? -.8 : .8);
    	}
    	
    	runMotor(0);
    	open = !open;
    }
    
}

