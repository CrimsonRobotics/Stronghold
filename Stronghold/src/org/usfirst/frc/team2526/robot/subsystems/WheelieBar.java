package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.RetractWheelie;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WheelieBar extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid piston;
	public boolean wheelieState;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new RetractWheelie());
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

