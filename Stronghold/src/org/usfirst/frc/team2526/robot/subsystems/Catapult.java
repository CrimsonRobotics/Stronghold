package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.catapult.StopCatapult;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Catapult extends Subsystem {
    
	
	CANTalon catapultMotorOne, catapultMotorTwo;
	DigitalInput catapultLimit;
	double goal;

    public void initDefaultCommand() {
    	setDefaultCommand(new StopCatapult());
    }
    
    public Catapult () {
    	super("Catapult");
    	
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

    public void update() {
    	SmartDashboard.putBoolean("Catapult Sensor", catapultLimit.get());
    }

}

