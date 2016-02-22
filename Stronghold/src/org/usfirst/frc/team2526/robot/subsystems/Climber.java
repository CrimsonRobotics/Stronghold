package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.climber.HoldWinch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid climber;
	CANTalon winchOne;
	CANTalon winchTwo;
	double goal;
	
	public Climber() {
		super("Climber");
		
		climber = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.climberPiston_A, RobotMap.climberPiston_B);
		winchOne = new CANTalon(RobotMap.climberWinchOne);
		winchTwo = new CANTalon(RobotMap.climberWinchTwo);
		
		winchOne.changeControlMode(TalonControlMode.Position);
		winchTwo.changeControlMode(TalonControlMode.Follower);
		winchOne.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		winchOne.setPID(RobotMap.climberP, RobotMap.climberI, RobotMap.climberD);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new HoldWinch());
    }
    
    public void closePneumatics() {
    	climber.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void getCurrentPosition() {
    	goal = winchOne.getEncPosition();
    }
    
    public void holdWinch() {
    	goal = winchOne.getEncPosition();
    	updateGoal();
    }
    
    public void winchUp() {
    	goal = winchOne.getEncPosition() + 100;
    	updateGoal();
    }
    
    public void winchDown() {
    	goal = winchOne.getEncPosition() - 100;
    	updateGoal();
    }
    
    public void updateGoal() {
    	winchOne.set(goal);
    }
}

