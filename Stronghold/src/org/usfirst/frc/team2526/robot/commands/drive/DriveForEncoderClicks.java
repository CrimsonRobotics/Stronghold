package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.Statics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForEncoderClicks extends Command {
	double distance;
    public DriveForEncoderClicks() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	distance = Statics.getDouble("AUTO Distance to Drive Encoders");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveConstant(Statics.getDouble("Auto Speed Target"), 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.driveTrain.getRawLeftEncoder()) > distance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stopDriving();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
