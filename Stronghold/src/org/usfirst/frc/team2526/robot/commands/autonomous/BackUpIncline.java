package org.usfirst.frc.team2526.robot.commands.autonomous;


import org.usfirst.frc.team2526.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BackUpIncline extends Command {
	public BackUpIncline() {
		requires(Robot.driveTrain);
	}
	
	double startAngle;
	protected void initialize() {
		startAngle = Robot.imu.getAngleZ();
		
//		Robot.driveTrain.driveConstant(-0.4);
		// Robot.driveTrain.enableTurnPIDValues(); TODO
	}

	protected void execute() {
		// TODO Robot.driveTrain.updatePIDValues();
	}

	protected boolean isFinished() {
		double angleDifference = Robot.imu.getAngleZ()-startAngle;
		SmartDashboard.putNumber("angleDifference", angleDifference);
		return Robot.imu.getAngleZ()-startAngle < -5.0;
	}

	protected void end() {
		// TODO Robot.driveTrain.stopDriving();
		
	}

	protected void interrupted() {
		end();
	}

}
