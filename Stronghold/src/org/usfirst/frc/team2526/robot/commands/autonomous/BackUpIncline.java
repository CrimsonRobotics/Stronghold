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
		startAngle = Robot.imu.getAngleX();
		
		Robot.driveTrain.driveConstantBack();
		Robot.driveTrain.enableTurnPIDValues();
	}

	protected void execute() {
		Robot.driveTrain.updatePIDValues();
	}

	protected boolean isFinished() {
		double angleDifference = Robot.imu.getAngleX()-startAngle;
		SmartDashboard.putNumber("angleDifference", angleDifference);
		return Robot.imu.getAngleX()-startAngle < -5.0;
	}

	protected void end() {
		Robot.driveTrain.stopDriving();
		
	}

	protected void interrupted() {
		end();
	}

}
