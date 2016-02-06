package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoaderFrame extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid pistonOne;
	DoubleSolenoid pistonTwo;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public LoaderFrame () {
    	super("GrabberFrame");
    	// This subsystem is for our Grabber's frame mechanism.
    	
    	pistonOne = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.grabberPiston_A, RobotMap.grabberPiston_B);
    	
    }
    
    public void ExtendGrabber () {
    	pistonOne.set(DoubleSolenoid.Value.kForward);
    }
    
    public void RetractGrabber () {
    	pistonOne.set(DoubleSolenoid.Value.kReverse);
    }
}

