package org.usfirst.frc.team2526.robot.commands.drive;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EnablePID extends Command {

	double distance;
	
    public EnablePID() {
		requires(Robot.driveTrain);
    	
    }
    

    protected void initialize() {
    	Robot.driveTrain.enableDrivePIDValues();
    	Robot.driveTrain.enableTurnPIDValues();
    }

    protected void execute() {
    	Robot.driveTrain.updatePIDValues();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
