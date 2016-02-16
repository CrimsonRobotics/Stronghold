package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.catapult.HoldCatapult;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Catapult extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon catapultMotor;
	AnalogInput catapultLimit;
	double goal;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new HoldCatapult());
    }
    
    public Catapult () {
    	super("Catapult");
    	// This susbsystem is for our catapult.
    	
    	catapultMotor = new CANTalon(RobotMap.catapultMotor);
    	
    	catapultMotor.changeControlMode(CANTalon.TalonControlMode.Position);
    	catapultMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	
    	catapultMotor.setPID(RobotMap.catapultP, RobotMap.catapultI, RobotMap.catapultD);
    	catapultMotor.enableControl();
    	//catapultMotor.set(6);
    	
    	catapultLimit = new AnalogInput(0);
    	
    }
    
    public boolean getLimitSwitchStatus() {
    	if(catapultLimit.getValue() <= 100.0 && catapultLimit.getValue() >= -100.0) {
    		return true;
    		}
    	else {
    		return false;
    	}
    		
    }

    
    public void moveCatapult() {
    	goal = 1500;
    	updateGoal();
    }
    
    
    public double getPosition() {
    	return catapultMotor.getEncPosition();
    }
    
    public void setCurrent() {
    	goal = catapultMotor.getEncPosition();
    }
    
    public void setCatapultHold() {
    	catapultMotor.setEncPosition(0);
    	goal = 0;
    	updateGoal();
    }
    
    public void fireCatapult() {
    	goal = RobotMap.firePosition;
    	updateGoal();
    }
    
    public void updateGoal() {
    	catapultMotor.setPosition(goal);
    }
    
    public void resetGoal() {
    	catapultMotor.setEncPosition(0);
    	goal = 0;
    	updateGoal();
    }
    

}

