package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.DrivePath;
import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.drive.ManualDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	
	public CANTalon lMotor, rMotor, lMotorSecondary, rMotorSecondary;
	
	RobotDrive drive;
	
    public void initDefaultCommand() { 
        setDefaultCommand(new ManualDrive());
    }
    
    public DriveTrain (){
    	super("DriveTrain");
    	
    	lMotor = new CANTalon(RobotMap.lMotorOne);
    	rMotor = new CANTalon(RobotMap.rMotorOne); 

    	
    	// Add in the two other secondary motors
    	// Left
    	lMotorSecondary = new CANTalon(RobotMap.lMotorTwo);
    	lMotorSecondary.changeControlMode(TalonControlMode.Follower);
    	lMotorSecondary.set(RobotMap.lMotorOne);
    	
    	// Right
    	rMotorSecondary = new CANTalon(RobotMap.rMotorTwo);
    	rMotorSecondary.changeControlMode(TalonControlMode.Follower);
    	rMotorSecondary.set(RobotMap.rMotorOne);
    	
    	
    	
//    	drivePID.setOutputRange(-0.5, 0.5);
//    	drivePID.setOutputRange(-0.5, 0.5);
//    	
//    	turnPID.setAbsoluteTolerance(3.0);
//    	drivePID.setAbsoluteTolerance(5);
    	
    	
    	drive = new RobotDrive(lMotor, rMotor);
    	
    }
    
    
    
    
    public void manualDrive() {
    	lMotor.changeControlMode(TalonControlMode.PercentVbus);
    	rMotor.changeControlMode(TalonControlMode.PercentVbus);
    	
    	if (RobotMap.primaryControl) {
    		// Main driver
    		drive.arcadeDrive(Robot.oi.getGamePad().getRawAxis(1), Robot.oi.getGamePad().getRawAxis(4));
    	} else {
    		// Co Driver
        	drive.arcadeDrive(-Robot.oi.getSecondaryStick().getY() * RobotMap.secondaryWeight, Robot.oi.getThirdStick().getX() * RobotMap.secondaryWeight);
    	}
    }
    
    
    public void driveConstant(double speed, double turnSpeed) {
    	drive.arcadeDrive(speed, turnSpeed);
    }
    
    public void drivePath(DrivePath path) {
    	
    }
    
    
    public void resetEncoders() {
    	lMotor.setEncPosition(0);
    	rMotor.setEncPosition(0);
    }
    
    public void update() {
    	
    	SmartDashboard.putNumber("Left Encoder", lMotor.getEncPosition());
    	SmartDashboard.putNumber("Right Encoder", rMotor.getEncPosition());
    	
    	SmartDashboard.putNumber("Angle Y", Robot.imu.getAngleY());
    	SmartDashboard.putNumber("Angle X", Robot.imu.getAngleX());
    	SmartDashboard.putNumber("Angle Z", Robot.imu.getAngleZ());
    	
    }
}

