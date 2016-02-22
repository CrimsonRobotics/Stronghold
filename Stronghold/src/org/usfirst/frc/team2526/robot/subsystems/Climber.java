package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.Statics;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Solenoid hookPiston;
	CANTalon winchOne;
	CANTalon winchTwo;
	
	public Climber() {
		super("Climber");
		
		hookPiston = new Solenoid(RobotMap.PCM_MAIN, RobotMap.climberPiston);
		winchOne = new CANTalon(RobotMap.climberWinchOne);
		winchTwo = new CANTalon(RobotMap.climberWinchTwo);
		
		winchOne.changeControlMode(TalonControlMode.PercentVbus);
		winchTwo.changeControlMode(TalonControlMode.PercentVbus);
	}

    public void initDefaultCommand() {
    	//setDefaultCommand(new HoldWinch());
    }
    
    public void climberUp() {
    	winchOne.set(Statics.CLIMBER_UP_SPEED);
    	winchTwo.set(Statics.CLIMBER_UP_SPEED);
    }
    
    public void closePneumatics() {
    	hookPiston.set(true);
    }

}

