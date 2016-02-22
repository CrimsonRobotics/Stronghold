package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.Drive;

import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public CANTalon lMotorOne, lMotorTwo, rMotorOne, rMotorTwo;
	
	RobotDrive drive;


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }
    
    public DriveTrain (){
    	super("DriveTrain");
    	
    	lMotorOne = new CANTalon(RobotMap.lMotorOne);
    	lMotorTwo = new CANTalon(RobotMap.lMotorTwo);
    	rMotorOne = new CANTalon(RobotMap.rMotorOne);
    	rMotorTwo = new CANTalon(RobotMap.rMotorTwo);
    	
    	lMotorOne.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	lMotorTwo.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	rMotorOne.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	rMotorTwo.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	
    	drive = new RobotDrive(lMotorOne, lMotorTwo, rMotorOne, rMotorTwo);
    	
    	
    	
    }
    
    public void arcadeDrive() {

    	if (RobotMap.primaryControl) {
    		// Main driver
    		drive.arcadeDrive(Robot.oi.getPrimaryStick().getY(), -Robot.oi.getSecondaryStick().getX());
    	} else {
    		// Co Driver
        	drive.arcadeDrive(-Robot.oi.getThirdStick().getY() * RobotMap.secondaryWeight, -Robot.oi.getFourthStick().getX() * RobotMap.secondaryWeight);
    	}
    	
    	
    }
    
    public void driveStraight(double distance) {
    	lMotorOne.set(distance);
    	lMotorTwo.set(distance);
    	rMotorOne.set(-distance);
    	rMotorTwo.set(-distance);
    }
    
    public void stopDriving() {
    	lMotorOne.set(0);
    	lMotorTwo.set(0);
    	rMotorOne.set(0);
    	rMotorTwo.set(0);
    }
    
    public void turnAngle(double angle) {
    	lMotorOne.set(Robot.imu.getAngleZ() + angle);
    	lMotorTwo.set(Robot.imu.getAngleZ() + angle);
    	rMotorOne.set(-Robot.imu.getAngleZ() + angle);
    	rMotorTwo.set(-Robot.imu.getAngleZ() + angle);
    }
    

    
}

