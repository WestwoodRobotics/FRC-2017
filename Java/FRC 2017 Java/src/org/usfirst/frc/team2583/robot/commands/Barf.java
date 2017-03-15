package org.usfirst.frc.team2583.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Barf extends CommandGroup {

    public Barf() {
    	addParallel(new JostleBasket());
    	addParallel(new ToggleFlap());
    }
}
