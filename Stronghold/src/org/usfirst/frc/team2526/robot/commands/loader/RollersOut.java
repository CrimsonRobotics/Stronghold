package org.usfirst.frc.team2526.robot.commands.loader;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollersOut extends Command {

    public RollersOut() {
    	requires(Robot.loaderRollers);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.loaderRollers.rollersOut();

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
