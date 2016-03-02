package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;


/**
 *
 */
public class ShiftUp extends SimpleCommand {

    public ShiftUp() {

    	super("ShiftUp");
    	requires(Robot.sonic);
    }

    protected void initialize() {
    	Robot.sonic.shiftUp();

    }
}
