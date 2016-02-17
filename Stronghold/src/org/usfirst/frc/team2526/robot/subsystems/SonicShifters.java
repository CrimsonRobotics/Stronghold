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
	
	DoubleSolenoid shifter;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public SonicShifters() {
    	super("SonicShifters");
    	
    	shifter = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.sonic_A, RobotMap.sonic_B);
    }
    
    public void shiftDown() {
    	shifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftUp() {
    	shifter.set(DoubleSolenoid.Value.kReverse);
    }
    
}

