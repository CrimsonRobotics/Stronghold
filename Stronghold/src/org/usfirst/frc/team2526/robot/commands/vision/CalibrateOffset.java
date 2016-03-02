package org.usfirst.frc.team2526.robot.commands.vision;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.subsystems.VisionCamera;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CalibrateOffset extends Command {

    public CalibrateOffset() {
        requires(Robot.camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double offset = Robot.camera.getRawAngle();
    	
    	VisionCamera.setOffset(offset);
    	Preferences.getInstance().putDouble("Camera Offset", offset);
    }

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}
