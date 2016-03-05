package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.Statics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConstantDrive extends Command {

    public ConstantDrive(double time) {
    	super(time);
    	requires(Robot.driveTrain);
        
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.driveConstant(Statics.getDouble("Auto Speed"), Robot.imu.getAngleY());
    	Robot.driveTrain.updatePIDValues();
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
