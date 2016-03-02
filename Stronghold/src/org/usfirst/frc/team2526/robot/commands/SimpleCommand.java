package org.usfirst.frc.team2526.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public abstract class SimpleCommand extends Command {

	public SimpleCommand(String name) {
		super(name);
	}

	protected void execute() {}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {}

	protected void interrupted() {
		end();
	}

}
