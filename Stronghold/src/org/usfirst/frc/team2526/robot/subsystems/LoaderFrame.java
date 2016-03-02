package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoaderFrame extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid piston;
	DigitalInput loaderSensor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public LoaderFrame () {
    	super("GrabberFrame");
    	// This subsystem is for our Grabber's frame mechanism.
    	
    	piston = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.loaderPiston_A, RobotMap.loaderPiston_B);
    	loaderSensor = new DigitalInput(RobotMap.loaderSensor);
    	
    }
    
    public void ExtendLoader() {
    	piston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void RetractLoader() {
    	piston.set(DoubleSolenoid.Value.kReverse);
    }
    
    
    public boolean getLoaderState() {
    	return loaderSensor.get();
    }
}

