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
    
	Solenoid hookPiston;
	CANTalon winchOne;
	CANTalon winchTwo;
	
	public Climber() {
		super("Climber");
		
		hookPiston = new Solenoid(RobotMap.PCM_MAIN, RobotMap.climberPiston);
		winchOne = new CANTalon(RobotMap.climberWinchOne);
		winchTwo = new CANTalon(RobotMap.climberWinchTwo);
		
		winchOne.changeControlMode(TalonControlMode.PercentVbus);
		winchTwo.changeControlMode(TalonControlMode.Follower);
		winchTwo.set(RobotMap.climberWinchOne);
	}

    public void initDefaultCommand() {}
    
    public void climberUp() {
    	winchOne.set(Statics.getDouble("Climber Up Speed"));
    }
    
    public void closePneumatics() {
    	hookPiston.set(true);
    	RobotMap.hookState = true;
    }

}

