package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.climber.HoldWinch;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid climber;
	CANTalon winch;
	double goal;
	
	public Climber() {
		super("Climber");
		
		climber = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.climberPiston_A, RobotMap.climberPiston_B);
		winch = new CANTalon(RobotMap.climberWinch);
		
		winch.changeControlMode(CANTalon.TalonControlMode.Position);
		winch.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		winch.setPID(RobotMap.climberP, RobotMap.climberI, RobotMap.climberD);
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
    	goal = winch.getEncPosition();
    }
    
    public void holdWinch() {
    	goal = winch.getEncPosition();
    	updateGoal();
    }
    
    public void winchUp() {
    	goal = winch.getEncPosition() + 100;
    	updateGoal();
    }
    
    public void winchDown() {
    	goal = winch.getEncPosition() - 100;
    	updateGoal();
    }
    
    public void updateGoal() {
    	winch.set(goal);
    }
}

