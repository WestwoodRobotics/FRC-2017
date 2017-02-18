package org.usfirst.frc.team2583.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Sensors extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	ADXRS450_Gyro gyro1 = new ADXRS450_Gyro();
	AnalogInput ultraSonic = new AnalogInput(0);
	
	public Sensors() {
		super("Sensor SS");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getAngle() {
    	double angle;
    	angle = gyro1.getAngle();
    	SmartDashboard.putNumber("Gyro1", angle);
    	return angle;
    }
    
    public void reset() {
    	gyro1.reset();
    }
    
    public double getDistance() {
    	double dist;
    	dist = ultraSonic.getAverageVoltage() / 0.0244;
    	SmartDashboard.putNumber("UltraDist", dist);
    	return dist;
    }
    
}

