package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.loader.StopRollers;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoaderRollers extends Subsystem {
    
	
	CANTalon loaderMotor;

    public void initDefaultCommand() {
        setDefaultCommand(new StopRollers());
    }
    
    public LoaderRollers() {
    	super("GrabberIntake");
    	
    	loaderMotor = new CANTalon(RobotMap.loaderTalon);
    	
    	loaderMotor.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void rollersIn() {
    	loaderMotor.set(Statics.getDouble("Loader Speed In"));
    }
    
    public void rollersInVariable() {
    	loaderMotor.set(Robot.oi.getPrimaryDriver().getRawAxis(3));
    }
    
    public void rollersInFire() {
    	loaderMotor.set(Statics.getDouble("Loader Speed Fire"));
    }
    
    public void rollersOut() {
    	loaderMotor.set(Statics.getDouble("Loader Speed Out"));
    }

    
    public void rollersStop() {
    	loaderMotor.set(0);
    }

    
}

