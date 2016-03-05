package org.usfirst.frc.team2526.robot.commands.loader;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendLoader extends Command {

    public ExtendLoader() {
    	requires(Robot.loaderFrame);
    }

    protected void initialize() {
    	Robot.loaderFrame.ExtendLoader();
    	
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return !Robot.loaderFrame.getLoaderState();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
