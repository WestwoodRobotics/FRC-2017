package org.usfirst.frc.team2583.robot;

import org.usfirst.frc.team2583.robot.commands.Barf;
import org.usfirst.frc.team2583.robot.commands.ReverseToggle;
import org.usfirst.frc.team2583.robot.commands.RollToggle;
import org.usfirst.frc.team2583.robot.commands.SlowToggle;

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
		Button toggleRollJ = new JoystickButton(joy, 3);
		toggleRollJ.whenPressed(new RollToggle());
		Button toggleBarf = new JoystickButton(joy, RobotMap.barfButton);
		toggleBarf.whenPressed(new Barf());
		
		Button toggleReverse = new JoystickButton(x1, RobotMap.YButton);
		toggleReverse.whenPressed(new ReverseToggle());
		Button toggleSlow = new JoystickButton(x1, RobotMap.XButton);
		toggleSlow.whenPressed(new SlowToggle());
	}
}

