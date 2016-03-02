package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.commands.SimpleCommand;


/**
 *
 */
public class ShiftDown extends SimpleCommand {

    public ShiftDown() {
    	super("ShiftDown");
    	requires(Robot.sonic);
    }

    protected void initialize() {
    	Robot.sonic.shiftDown();

    }

}
