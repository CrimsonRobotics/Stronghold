package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.catapult.HoldCatapult;

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
    	setDefaultCommand(new HoldCatapult());
    }
    
    public Catapult () {
    	super("Catapult");
    	// This susbsystem is for our catapult.
    	
    	catapultMotorOne = new CANTalon(RobotMap.catapultTalonOne);
    	catapultMotorTwo = new CANTalon(RobotMap.catapultTalonTwo);
    	
    	catapultMotorOne.changeControlMode(TalonControlMode.Position);
    	catapultMotorTwo.changeControlMode(TalonControlMode.Position);
    	catapultMotorOne.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	
    	catapultMotorOne.setPID(RobotMap.catapultP, RobotMap.catapultI, RobotMap.catapultD);
    	catapultMotorOne.enableControl();
    	//catapultMotor.set(6);
    	
    	catapultLimit = new DigitalInput(RobotMap.catapultSensor);
    	
    }
    
    public boolean getLimitSwitchStatus() {
    	return catapultLimit.get();
    		
    }
    
    public void catapultFire() {
    	catapultMotorOne.set(-1);
    	catapultMotorTwo.set(-1);
    }
    
    public void armCatapult() {
    	catapultMotorOne.set(-1);
    	catapultMotorTwo.set(-1);
    }
    
    public void stopCatapult() {
    	catapultMotorOne.set(0);
    	catapultMotorTwo.set(0);
    }
    
    public void holdCatapult() {
    	catapultMotorOne.set(0);
    	catapultMotorTwo.set(0);
    	Timer.delay(Statics.CATAPULT_HOLD_DELAY);
    }

    
    public void moveCatapult() {
    	goal = 1500;
    	updateGoal();
    }
    
    
    public double getPosition() {
    	return catapultMotorOne.getEncPosition();
    }
    
    public void setCurrent() {
    	goal = catapultMotorOne.getEncPosition();
    }
    
    public void setCatapultHold() {
    	catapultMotorOne.setEncPosition(0);
    	goal = 0;
    	updateGoal();
    }
    
    public void fireCatapult() {
    	goal = RobotMap.firePosition;
    	updateGoal();
    }
    
    public void updateGoal() {
    	catapultMotorOne.setPosition(goal);
    }
    
    public void resetGoal() {
    	catapultMotorOne.setEncPosition(0);
    	goal = 0;
    	updateGoal();
    }
    

}

