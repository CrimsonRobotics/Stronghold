package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SonicShifters extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid leftShifter;
	DoubleSolenoid rightShifter;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public SonicShifters() {
    	super("SonicShifters");
    	
    	leftShifter = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.leftSonic_A, RobotMap.leftSonic_B);
    	rightShifter = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.rightSonic_A, RobotMap.rightSonic_B);
    }
    
    public void shiftDown() {
    	leftShifter.set(DoubleSolenoid.Value.kForward);
    	rightShifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftUp() {
    	leftShifter.set(DoubleSolenoid.Value.kReverse);
    	rightShifter.set(DoubleSolenoid.Value.kReverse);
    }
    
}

