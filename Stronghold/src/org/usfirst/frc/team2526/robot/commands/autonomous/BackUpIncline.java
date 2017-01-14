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
		
		
//		Robot.driveTrain.driveConstant(-0.4);
		Robot.driveTrain.enableTurnPIDValues();
	}

	protected void execute() {
		Robot.driveTrain.updatePIDValues();
	}

	

	protected void end() {
		Robot.driveTrain.stopDriving();
		
	}

	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
