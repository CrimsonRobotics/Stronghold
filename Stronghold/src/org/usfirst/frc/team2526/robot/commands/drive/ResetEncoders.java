package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;

/**
 *
 */
public class ResetEncoders extends SimpleCommand {

    public ResetEncoders() {
    	super("Reset Encoders");
        requires(Robot.driveTrain);
    }

    protected void initialize() {
    	Robot.driveTrain.resetEncoders();
    }


}
