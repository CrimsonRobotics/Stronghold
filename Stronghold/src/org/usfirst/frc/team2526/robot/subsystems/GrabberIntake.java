package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberIntake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon grabberOne;
	CANTalon grabberTwo;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public GrabberIntake() {
    	super("GrabberIntake");
    	// This subsystem is for our Grabber's Intake Mechanism.
    	
    	grabberOne = new CANTalon(RobotMap.grabberMotorOne);
    	grabberTwo = new CANTalon(RobotMap.grabberMotorTwo);
    	
    	grabberOne.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	grabberTwo.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    }
    
    public void ballIn() {
    	grabberOne.set(.5);
    	grabberTwo.set(-.5);
    	
    }
    
}

