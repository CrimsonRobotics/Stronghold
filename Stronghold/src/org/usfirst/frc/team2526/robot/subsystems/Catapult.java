package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.catapult.StopCatapult;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Catapult extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon catapultMotorOne, catapultMotorTwo;
	DigitalInput catapultLimit;
	double goal;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopCatapult());
    }
    
    public Catapult () {
    	super("Catapult");
    	// This susbsystem is for our catapult.
    	
    	catapultMotorOne = new CANTalon(RobotMap.catapultTalonOne);
    	catapultMotorTwo = new CANTalon(RobotMap.catapultTalonTwo);
    	
    	catapultMotorTwo.changeControlMode(TalonControlMode.Follower);
    	catapultMotorTwo.set(RobotMap.catapultTalonOne);

    	
    	catapultLimit = new DigitalInput(RobotMap.catapultSensor);
    	
    }
    
    public boolean getLimitSwitchStatus() {
    	return catapultLimit.get();
    		
    }
    
    public void catapultFire() {
    	catapultMotorOne.set(-1);
    }
    
    public void armCatapult() {
    	catapultMotorOne.set(Statics.getDouble("Catapult Arm Speed"));
    }
    
    public void stopCatapult() {
    	catapultMotorOne.set(0);
    }

    

}

