package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LoaderFrame extends Subsystem {
    
	
	DoubleSolenoid piston;
	DigitalInput loaderSensor;

    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public LoaderFrame () {
    	super("GrabberFrame");
    	
    	piston = new DoubleSolenoid(RobotMap.PCM_MAIN, RobotMap.loaderPiston_A, RobotMap.loaderPiston_B);
    	loaderSensor = new DigitalInput(RobotMap.loaderSensor);
    	
    	
    	
    }
    
    public void ExtendLoader() {
    	piston.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void RetractLoader() {
    	piston.set(DoubleSolenoid.Value.kForward);
    }
    
    
    public boolean getLoaderState() {
    	return loaderSensor.get();
    }
    
    public void update() {
    	SmartDashboard.putBoolean("Loader Sensor", loaderSensor.get());
    }
}

