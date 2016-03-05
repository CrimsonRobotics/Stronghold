package org.usfirst.frc.team2526.robot.commands.loader;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollBallIn extends Command {

    public RollBallIn() {
    	requires(Robot.loaderRollers);
    }

    protected void initialize() {
    	Robot.loaderRollers.rollersIn();
    }

    protected void execute() {
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
