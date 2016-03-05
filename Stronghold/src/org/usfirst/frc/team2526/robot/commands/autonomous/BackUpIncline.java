package org.usfirst.frc.team2526.robot.commands.autonomous;


import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.Statics;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BackUpIncline extends Command {
	public BackUpIncline() {
		requires(Robot.driveTrain);
	}
	
	double startAngle;
	protected void initialize() {
		startAngle = Robot.imu.getAngleZ();

	}

	protected void execute() {
		Robot.driveTrain.driveConstant(Statics.getDouble("Auto Speed Back To Incline"));
	}

	protected boolean isFinished() {
		double angleDifference = Robot.imu.getAngleZ()-startAngle;
		SmartDashboard.putNumber("angleDifference", angleDifference);
		return Robot.imu.getAngleZ()-startAngle < -5.0;
	}

	protected void end() {
		Robot.driveTrain.stopDriving();
		
	}

	protected void interrupted() {
		end();
	}

}
