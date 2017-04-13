package org.usfirst.frc.team2583.robot;

import org.usfirst.frc.team2583.robot.commands.AddGear;
import org.usfirst.frc.team2583.robot.commands.Barf;
import org.usfirst.frc.team2583.robot.commands.RemoveGear;
import org.usfirst.frc.team2583.robot.commands.ReverseToggle;
import org.usfirst.frc.team2583.robot.commands.SpeedDrive;
import org.usfirst.frc.team2583.robot.commands.StartFast;
import org.usfirst.frc.team2583.robot.commands.StartSlow;
import org.usfirst.frc.team2583.robot.commands.StopFast;
import org.usfirst.frc.team2583.robot.commands.StopSlow;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public XboxController x1 = new XboxController(0);;
	public Joystick joy = new Joystick(1);
	
	public OI(){
		
		// Flight joystick buttons/axis
		Button toggleBarf = new JoystickButton(joy, RobotMap.barfButton);
		toggleBarf.whenPressed(new Barf());
		Button addGear = new JoystickButton(joy, 5);
		addGear.whenPressed(new AddGear());
		Button removeGear = new JoystickButton(joy, 4);
		removeGear.whenPressed(new RemoveGear());
		
		Button pidDrive = new JoystickButton(joy, RobotMap.pidDrive);
		pidDrive.whenPressed(new SpeedDrive(32));  // drive distance in inches using PID
		
		// Xbox controller buttons/axis
		Button toggleReverse = new JoystickButton(x1, RobotMap.YButton);
		toggleReverse.whenPressed(new ReverseToggle());
		Button toggleSlow = new JoystickButton(x1, RobotMap.rightBumper);
		toggleSlow.whenPressed(new StartSlow());
		toggleSlow.whenReleased(new StopSlow());
		Button toggleFast = new JoystickButton(x1, RobotMap.leftBumper);
		toggleFast.whenPressed(new StartFast());
		toggleFast.whenReleased(new StopFast());
	}
}

