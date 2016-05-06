package org.usfirst.frc.team2526.robot.commands.loader;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollersInFire extends Command {

    public RollersInFire() {
    	requires(Robot.loaderRollers);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.loaderRollers.rollersInFire();

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
