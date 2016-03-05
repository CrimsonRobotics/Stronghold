package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SonicShifters extends Subsystem {
    
	
	Solenoid shifter;

    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public SonicShifters() {
    	super("SonicShifters");
    	
    	shifter = new Solenoid(RobotMap.PCM_MAIN, RobotMap.sonicPiston);
    }
    
    public void shiftDown() {
    	shifter.set(true);
    }
    
    public void shiftUp() {
    	shifter.set(false);
    }
    
}

