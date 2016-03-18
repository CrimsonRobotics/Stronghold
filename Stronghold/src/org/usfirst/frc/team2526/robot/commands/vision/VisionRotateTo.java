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
    	double currentAngle = Robot.imu.getAngleZ();
    	
    	double angle = Robot.camera.getAngle();
    	SmartDashboard.putNumber("Abs Target Vision Angle", currentAngle+angle);
    	
    	// Vision uses the right side as negative, Gyro's right side is positive
    	// TODO Robot.driveTrain.setAngle(currentAngle+angle);
    	// TODO Robot.driveTrain.enableTurnPIDValues();
    }
    

    protected void execute() {
    	// TODO Robot.driveTrain.updatePIDValues();
    }

    protected boolean isFinished() {
    	// TODO return Robot.driveTrain.onTurnTarget() || this.isTimedOut() || !Robot.camera.isUpdating();
    	return false;
    	
    }

    protected void end() {
    	// TOOD Robot.driveTrain.disableTurnPIDValues();
    }

    protected void interrupted() {
    	end();
    }
}
