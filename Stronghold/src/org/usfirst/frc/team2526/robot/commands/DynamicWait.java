package org.usfirst.frc.team2526.robot.commands;

import org.usfirst.frc.team2526.robot.Statics;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class DynamicWait extends WaitCommand {

	String delayName;
	
	public DynamicWait(String delayName) {
		super("Wait From " + delayName,Statics.getDouble(delayName));
		this.delayName = delayName;
	}
	
	public void initialize() {
		this.setTimeout(Statics.getDouble(delayName));
	}

}
