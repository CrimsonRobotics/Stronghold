package org.usfirst.frc.team2526.robot.commands.catapult;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopCatapult extends Command {

    public StopCatapult() {
    	requires(Robot.catapult);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.catapult.stopCatapult();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
