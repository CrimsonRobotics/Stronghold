package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.Statics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConstantDriveStatic extends Command {

    public ConstantDriveStatic() {
    	super(Statics.getDouble("Auto Time"));
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	this.setTimeout(Statics.getDouble("Auto Time"));
    }

    protected void execute() {
    	Robot.driveTrain.driveConstant(Statics.getDouble("Auto Speed"), Statics.getDouble("Auto Turn Offset"));
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
