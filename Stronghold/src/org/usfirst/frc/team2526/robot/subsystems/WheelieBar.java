package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WheelieBar extends Subsystem {
    
	
	DoubleSolenoid piston;
	public boolean wheelieState;

    public void initDefaultCommand() {
    }
    
    public WheelieBar() {
    	super("Wheelie Bar");
    	
    	piston = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.wheelie_A, RobotMap.wheelie_B);
    }
    
    public void extendWheelie() {
    	piston.set(DoubleSolenoid.Value.kForward);
    	wheelieState = true;
    }
    
    public void retractWheelie() {
    	piston.set(DoubleSolenoid.Value.kReverse);
    	wheelieState = false;
    }
    
    public boolean getWheelieState() {
    	return wheelieState;
    }
}

