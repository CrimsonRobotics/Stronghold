package org.usfirst.frc.team2526.robot.commands.climber;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopClimb extends Command {

    public StopClimb() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.stopClimber();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
