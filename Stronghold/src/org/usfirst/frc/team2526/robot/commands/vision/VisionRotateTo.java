package org.usfirst.frc.team2526.robot.commands.vision;

import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionRotateTo extends Command {

    public VisionRotateTo() {
    	super(6);
        requires(Robot.driveTrain);
    }

    protected void initialize() {
    	
    	

    }
    

    protected void execute() {
    	Robot.driveTrain.updatePIDValues();
    }

    protected boolean isFinished() {
    	return Robot.driveTrain.onTurnTarget() || this.isTimedOut() || !Robot.camera.isUpdating();
    }

    protected void end() {
    	Robot.driveTrain.disableTurnPIDValues();
    }

    protected void interrupted() {
    	end();
    }
}
