package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoaderFrame extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid piston;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public LoaderFrame () {
    	super("GrabberFrame");
    	// This subsystem is for our Grabber's frame mechanism.
    	
    	piston = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.grabberPiston_A, RobotMap.grabberPiston_B);
    	
    }
    
    public void ExtendLoader() {
    	piston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void RetractLoader() {
    	piston.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void ExtendLoaderWait() {
    	Timer.delay(0);
    	piston.set(DoubleSolenoid.Value.kForward);
    }
}

