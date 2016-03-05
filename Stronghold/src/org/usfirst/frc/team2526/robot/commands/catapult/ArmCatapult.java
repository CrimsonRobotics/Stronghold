package org.usfirst.frc.team2526.robot.commands.catapult;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmCatapult extends Command {

    public ArmCatapult() {
    	requires(Robot.catapult);
    }

    protected void initialize() {
    }

    protected void execute() {    	
    	Robot.catapult.armCatapult();
    }

    protected boolean isFinished() {
    	return Robot.catapult.getLimitSwitchStatus();

    }

    protected void end() {
    	Robot.catapult.stopCatapult();
    }

    protected void interrupted() {
    }
}
