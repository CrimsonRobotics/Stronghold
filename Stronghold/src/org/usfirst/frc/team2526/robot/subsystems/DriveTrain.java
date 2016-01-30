package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.Drive;

import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public CANTalon lMotorOne, lMotorTwo, rMotorOne, rMotorTwo;
	
	RobotDrive crane;


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
    	
    	crane = new RobotDrive(RobotMap.lMotorOne, RobotMap.lMotorTwo, RobotMap.rMotorOne, RobotMap.rMotorTwo);
    	
    	
    	
    }
    
    public void arcadeDrive() {

    	if (RobotMap.primaryControl) {
    		// Main driver
    		crane.arcadeDrive(Robot.oi.getPrimaryValue().getY(), -Robot.oi.getSecondaryValue().getX());
    	} else {
    		// Co Driver
        	crane.arcadeDrive(-Robot.oi.getThirdValue().getY() * RobotMap.secondaryWeight, -Robot.oi.getFourthValue().getX() * RobotMap.secondaryWeight);
    	}
    	
    			
    	
    	SmartDashboard.putNumber("Left Motor One Voltage", lMotorOne.getOutputVoltage());
    	SmartDashboard.putNumber("Left Motor Two Voltage", lMotorTwo.getOutputVoltage());
    	SmartDashboard.putNumber("Right Motor One Voltage", rMotorOne.getOutputVoltage());
    	SmartDashboard.putNumber("Right Motor Two Voltage", rMotorTwo.getOutputVoltage());
    	
    }
    

    
}
