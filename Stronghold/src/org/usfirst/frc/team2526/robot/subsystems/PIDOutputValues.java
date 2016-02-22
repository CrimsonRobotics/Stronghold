package org.usfirst.frc.team2526.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;

public class PIDOutputValues {
	double turnValue = 0; // -1 to 1;
	double magnitudeValue = 0;
	
	public void setTurnValue(double turn) {
		this.turnValue = turn;
	}
	
	public void setMagnitudeValue(double mag) {
		this.magnitudeValue = mag;
	}
	
	public void updateSpeed(RobotDrive drive) {
		drive.arcadeDrive(magnitudeValue, turnValue, false);
	}

}
