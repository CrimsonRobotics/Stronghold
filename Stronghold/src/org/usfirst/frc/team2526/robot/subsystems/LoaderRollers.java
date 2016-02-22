package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.Statics;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoaderRollers extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon loaderMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public LoaderRollers() {
    	super("GrabberIntake");
    	// This subsystem is for our Grabber's Intake Mechanism.
    	
    	loaderMotor = new CANTalon(RobotMap.loaderTalon);
    	
    	loaderMotor.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void rollersIn() {
    	loaderMotor.set(Statics.LOADER_SPEED_IN);
    }
    
    public void rollersOut() {
    	loaderMotor.set(Statics.LOADER_SPEED_OUT);
    }
    
    public void ballIn() {
    	loaderMotor.set(Statics.LOADER_SPEED_IN);
    	Timer.delay(Statics.LOADER_IN_DELAY);
    	loaderMotor.set(0);
    	
    }

    
}

