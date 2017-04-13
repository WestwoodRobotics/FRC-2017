package org.usfirst.frc.team2583.robot.subsystems;

import org.usfirst.frc.team2583.robot.RobotMap;
import org.usfirst.frc.team2583.robot.commands.Drive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class DriveTrain extends Subsystem{

	private BuiltInAccelerometer accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
	private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	private boolean testBot = true;
	
	private CANTalon frontleft = new CANTalon(RobotMap.fLeft);
	private CANTalon backleft = new CANTalon(RobotMap.bLeft);
	private CANTalon frontright = new CANTalon(RobotMap.fRight);
	private CANTalon backright = new CANTalon(RobotMap.bRight);
	private RobotDrive drive = new RobotDrive(frontleft, backleft, frontright, backright);
	
	private Talon frontleftT = new Talon(RobotMap.fLeft);
	private Talon backleftT = new Talon(RobotMap.bLeft);
	private Talon frontrightT = new Talon(RobotMap.fRight);
	private Talon backrightT = new Talon(RobotMap.bRight);
	
	private Encoder rightEnc = new Encoder(RobotMap.driveRightA, RobotMap.driveRightB, true, Encoder.EncodingType.k4X);
	private Encoder leftEnc = new Encoder(RobotMap.driveLeftA, RobotMap.driveLeftB, false, Encoder.EncodingType.k4X);
	
	public final double g = RobotMap.g;
	
	private double leftSpeed = 0;
	private double rightSpeed = 0;
	
	private double lSpeed = 0; // used for PID Drive
	private double rSpeed = 0; 
	
	private double velX = 0;
	private double velY = 0;
	private double velZ = 0;
	
	private double posX = 0;
	private double posY = 0;
	private double posZ = 0;
	
	public DriveTrain(){
		frontleft.setInverted(true);
		backleft.setInverted(true);
		frontright.setInverted(true);
		backright.setInverted(true);
		
		if (testBot) {
			drive = new RobotDrive(frontleftT, backleftT, frontrightT, backrightT);
		} else
			drive = new RobotDrive(frontleft, backleft, frontright, backright);
		
		
		
		leftEnc.setDistancePerPulse(RobotMap.distancePerEncPulse);
		rightEnc.setDistancePerPulse(RobotMap.distancePerEncPulse);
		
		leftEnc.reset();
		rightEnc.reset();
		gyro.reset();
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}
	
	/**
	 * Drive the robot given inputs each set of wheels
	 * 
	 * @param left the speed for the left wheels
	 * @param right the speed for the right wheels
	 */
	public void tankDrive(double left, double right){
		if(!RobotMap.reverseToggle)drive.tankDrive(left, right);
		else drive.tankDrive(right, left);
		
		leftSpeed = left;
		rightSpeed = right;
	}
	
	public void tankDriveAuto(double left, double right){
		if(RobotMap.reverseToggle)drive.tankDrive(left, right);
		else drive.tankDrive(right, left);
		
		leftSpeed = left;
		rightSpeed = right;
	}
	
	public void pidDrive() {
		// speeds for left and right are set by PIDDriveXX controls
		tankDrive(lSpeed, rSpeed);
	}
	
	/**
	 * Drives the robot straight forward for the specific distance and speed
	 * 
	 * @param speed the speed to drive forward at
	 * @param distance the distance (in units) to drive
	 */
	public void drive(double speed, double angle){
		drive.drive(speed, angle);
		
		leftSpeed = speed;
		rightSpeed = speed;
	}
	
	 // set speed variabls from PIDSubsystem
    public void setRightSpeed(double rightSpeed) {
    	rSpeed = rightSpeed;
    }
    
    public void setLeftSpeed(double leftSpeed) {
    	lSpeed = leftSpeed;
    }
    
    public void setEncoderPIDType(PIDSourceType pType) {
    	leftEnc.setPIDSourceType(pType);
    	rightEnc.setPIDSourceType(pType);
    }
    
    public double getPIDRight() {
    	return rightEnc.pidGet();
    	
    }
    
    public double getPIDLeft() {
    	return leftEnc.pidGet();
    }
	 /* @return the current speed of the right motors
	 */
	public double getRSpeed(){
		return rightSpeed;
	}
	
	/**
	 * 
	 * @return the current speed of the left motors
	 */
	public double getLSpeed(){
		return leftSpeed;
	}
	
	/**
	 * 
	 * @return the value of the encoder on the left set of wheels
	 */
	public int getLeftEncoder(){
		return leftEnc.get();
	}
	
	/**
	 * 
	 * @return the value of the encoder on the right wet of wheels
	 */
	public int getRightEncoder(){
		return rightEnc.get();
	}
	
	public double getLeftDistance(){
		return leftEnc.getDistance();
	}
	
	public double getRightDistance(){
		return rightEnc.getDistance();
	}
	
	public double getRightRate() {
		return rightEnc.getRate();
	}
	
	public double getLeftRate() {
		return leftEnc.getRate();
	}
	
	/**
	 * reset the encoder's value on the left set of wheels
	 */
	public void resetLeftEncoder(){
		leftEnc.reset();
	}
	
	/**
	 * reset the encoder's value on the right set of wheels
	 */
	public void resetRightEncoder(){
		rightEnc.reset();
	}
	
	/**
	 * reset both encoders on the drivetrain
	 */
	public void resetEncoders(){
		leftEnc.reset();
		rightEnc.reset();
	}
	
	/**
	 * 
	 * @return the value of the built-in accelerometer's x-axis
	 */
	public double getXAccel(){
		return Math.abs(accel.getX()) > RobotMap.accelDeadband ? accel.getX()/g : 0;
	}
	
	/**
	 * 
	 * @return the value of the built-in accelerometer's y-axis
	 */
	public double getYAccel(){	
		return Math.abs(accel.getY()) > RobotMap.accelDeadband ? accel.getY()/g : 0;
	}
	
	/**
	 * 
	 * @return the value of the built-in accelerometer's z-axis, compensating for gravity
	 */
	public double getZAccel(){
		double a = accel.getZ() - 1;
		return Math.abs(a) > RobotMap.accelDeadband ? a/g : 0;
	}
	
	/**
	 * 
	 * @return the angle heading of the robot
	 */
	public double getGyroAngle(){
		return gyro.getAngle();
//		return 0;
	}
	
	public void resetGyro(){
		gyro.reset();
//		return;
	}
	
	public double getXVel(){
		return velX;
	}
	
	public double getYVel(){
		return velY;
	}
	
	public double getZVel(){
		return velZ;
	}
	
	public double getXPos(){
		return posX;
	}
	
	public double getYPos(){
		return posY;
	}
	
	public double getZPos(){
		return posZ;
	}
	
	public void updateVectors(){
		velX += getXAccel() * RobotMap.clock;
		velY += getYAccel() * RobotMap.clock;
		velZ += getZAccel() * RobotMap.clock;
		
		posX += velX * RobotMap.clock;
		posY += velY * RobotMap.clock;
		posZ += velZ * RobotMap.clock;
	}
}
