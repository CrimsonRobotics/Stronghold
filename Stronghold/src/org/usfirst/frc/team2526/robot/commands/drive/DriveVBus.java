package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveVBus extends Command {

    public DriveVBus() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.freeArcadeDrive();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
