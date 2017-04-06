
package org.usfirst.frc.team2583.robot;

import org.usfirst.frc.team2583.robot.commands.AutoForwardGear;
import org.usfirst.frc.team2583.robot.commands.AutoLeftGear;
import org.usfirst.frc.team2583.robot.commands.AutoRightGear;
import org.usfirst.frc.team2583.robot.commands.BaselineAuto;
import org.usfirst.frc.team2583.robot.commands.UpdateDash;
import org.usfirst.frc.team2583.robot.subsystems.BallFlap;
import org.usfirst.frc.team2583.robot.subsystems.Basket;
import org.usfirst.frc.team2583.robot.subsystems.Climber;
import org.usfirst.frc.team2583.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2583.robot.subsystems.Roller;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

//	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public final static DriveTrain drivetrain = new DriveTrain();
	public final static BallFlap flap = new BallFlap();
	public final static Roller roller = new Roller();
	public final static Basket basket = new Basket();
	public final static Climber climber = new Climber();
//	public static Grabber grabber;// = new Grabber();
	public final static OI oi = new OI();
	
    Command autonomousCommand;
    UpdateDash dashboardUpdate;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	//CameraServer.getInstance().startAutomaticCapture();
    	dashboardUpdate = new UpdateDash();
    	dashboardUpdate.start();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	drivetrain.resetEncoders();
    	if(dashboardUpdate != null && !dashboardUpdate.isRunning()){
    		dashboardUpdate.start();
    	}
    	
    	int autochoice = (int)SmartDashboard.getNumber("Auto Select", 1);

    	autonomousCommand =   autochoice == 4 ? new BaselineAuto()
    						: autochoice == 3 ? new AutoRightGear() 
    						: autochoice == 2 ? new AutoLeftGear()
    						: new AutoForwardGear();

    	if (autonomousCommand != null){
    		autonomousCommand.start();
    	}
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        if (dashboardUpdate != null && !dashboardUpdate.isRunning()) dashboardUpdate.start();
        drivetrain.resetEncoders();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
