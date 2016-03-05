package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.drive.Drive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	
	public CANTalon lMotor, rMotor, lMotorTwo, rMotorTwo;
	

	RobotDrive drive;

	AnalogInput ultraSonic;
	
	double sumSensor = 0;
	double averageCount = 0;
	
	
    public void initDefaultCommand() { 
        setDefaultCommand(new Drive());
    }
    
    public DriveTrain (){
    	super("DriveTrain");
    	
    	
    	
    	ultraSonic = new AnalogInput(1);
    	
    	lMotor = new CANTalon(RobotMap.lMotorOne);
    	rMotor = new CANTalon(RobotMap.rMotorOne); 
    	lMotorTwo = new CANTalon(RobotMap.lMotorTwo);
    	rMotorTwo = new CANTalon(RobotMap.rMotorTwo);
    	
    	lMotorTwo.changeControlMode(TalonControlMode.Follower);
    	rMotorTwo.changeControlMode(TalonControlMode.Follower);
    	lMotorTwo.set(RobotMap.lMotorOne);
    	rMotorTwo.set(RobotMap.rMotorOne);
    	
    	
    
    	
    	drive = new RobotDrive(lMotor, rMotor);
    	
    }
    

    
    public void freeArcadeDrive() {
    	
    	if (RobotMap.primaryControl) {
    		// Main driver
    		drive.arcadeDrive(Robot.oi.getGamePad().getRawAxis(1), Robot.oi.getGamePad().getRawAxis(4));
    	} else {
    		// Co Driver
        	drive.arcadeDrive(-Robot.oi.getSecondaryStick().getY() * RobotMap.secondaryWeight, Robot.oi.getThirdStick().getX() * RobotMap.secondaryWeight);
    	}
    	
    }
    
    public void driveForward() {
    	lMotor.set(1);
    	rMotor.set(-1);
    }
    
    public void driveBackToDefense() {
    	lMotor.set(-0.4);
    	rMotor.set(0.4);
    }
    
    public void driveConstant(double speed) {
    	lMotor.set(speed);
    	rMotor.set(-speed);
    }
    
    public void setDriveStraight(double inches, double startingAngle) {
    	double ticks = Statics.Inches.inchesToTicks(inches);
    	
    	lMotor.setEncPosition(0);
    	rMotor.setEncPosition(0);
    	

    }


    
    public void stopDriving() {
    	
    	lMotor.set(0);
    	rMotor.set(0);
    }
    
    public void beginDriveHold() {
    	lMotor.disable();
    	rMotor.disable();
    	rMotorTwo.disable();
    	lMotorTwo.disable();
    }
    
    public void releaseDriveHold() {
    	lMotor.enable();
    	rMotor.enable();
    	rMotorTwo.enable();
    	lMotorTwo.enable();
    }

    public double getRawLeftEncoder() {
    	return lMotor.getEncPosition();
    }
    
    public double getRawRightEncoder() {
    	return rMotor.getEncPosition();
    }
    
    public double getDistanceAwayFromFront() {
    	return ultraSonic.getAverageValue()*0.393701;
    }
    
    public void resetEncoders() {
    	lMotor.setEncPosition(0);
    	rMotor.setEncPosition(0);
    }
    
    public void update() {
    	sumSensor += ultraSonic.getValue();
    	averageCount++; 
    	
    	if (averageCount > 100) {
    		SmartDashboard.putNumber("UltraOut", sumSensor/averageCount);
    		averageCount = 0;
    		
    		sumSensor = 0;
    	}
    	
    	
    	SmartDashboard.putNumber("Left Encoder", getRawLeftEncoder());
    	SmartDashboard.putNumber("Right Encoder", getRawRightEncoder());
    	
    	SmartDashboard.putNumber("Angle Y", Robot.imu.getAngleY());
    	SmartDashboard.putNumber("Angle X", Robot.imu.getAngleX());
    	SmartDashboard.putNumber("Angle Z", Robot.imu.getAngleZ());
    	
    	SmartDashboard.putNumber("Ultrasonic Internal Average Value", ultraSonic.getAverageValue()* 0.393701);
    }
}

