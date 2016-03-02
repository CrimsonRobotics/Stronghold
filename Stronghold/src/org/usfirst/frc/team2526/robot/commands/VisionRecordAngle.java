package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionRecordAngle extends Command {

    public VisionRecordAngle() {
        requires(Robot.camera);
    }

    protected void initialize() {
    }

	protected void execute() {
		Robot.camera.updateAngle();		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
}
