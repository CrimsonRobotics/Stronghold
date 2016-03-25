package org.usfirst.frc.team2526.robot;



import org.usfirst.frc.team2526.robot.commands.OpenPortcullis;
import org.usfirst.frc.team2526.robot.commands.StopOpeningPortcullis;
import org.usfirst.frc.team2526.robot.commands.catapult.FireGroup;
import org.usfirst.frc.team2526.robot.commands.drive.ShiftDown;
import org.usfirst.frc.team2526.robot.commands.drive.ShiftUp;
import org.usfirst.frc.team2526.robot.commands.drive.SwitchDrive;
import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoaderToLoad;
import org.usfirst.frc.team2526.robot.commands.loader.LoadBall;
import org.usfirst.frc.team2526.robot.commands.loader.RetractLoader;
import org.usfirst.frc.team2526.robot.commands.loader.UnloadBall;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.ExtendWheelie;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.RetractWheelie;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	CrimsonControlStick driver = null;
	Joystick secondaryStick = new Joystick(2);
	Joystick thirdStick = new Joystick(3);
 
	SendableChooser driveChooser;
	
	public void updateDriverControls() {
		CrimsonControlStick currentDriver = (CrimsonControlStick) driveChooser.getSelected();
        
        if (driver == null || !(driver.getName().equals(currentDriver.getName()))) {
        	if (currentDriver == null) {
        		setDriveControls(new TwoStickCraneController(0, 1));
        	} else {
        		setDriveControls(currentDriver);
        	}
        }
	}
	
	public Joystick getSecondaryStick() {
		return secondaryStick;
	}
	
	public Joystick getThirdStick() {
		return thirdStick;
	}
	
	public void setDriveControls(CrimsonControlStick drive) {
		this.driver = drive;
		updateDriveButtons();
	}
	
	public CrimsonControlStick getDriveControls() {
		return driver;
	}
	
	
	Button secondaryStickOne = new JoystickButton(secondaryStick,1);
	Button secondaryStickTwo = new JoystickButton(secondaryStick,2);
	Button secondaryStickThree = new JoystickButton(secondaryStick,3);
	Button secondaryStickFive = new JoystickButton(secondaryStick,5);

	// Secondary Stick Buttons
	
	Button thirdStickOne = new JoystickButton(thirdStick, 1);
	Button thirdStickThree = new JoystickButton(thirdStick, 3);
	// Third Stick Buttons
	
	public OI() {
		
		driveChooser = new SendableChooser();
	    driveChooser.addDefault("Joysticks", new TwoStickCraneController(0, 1));
	    driveChooser.addObject("GamePad", new GamePadController(0));
	    SmartDashboard.putData("Drive Mode", driveChooser);
		
		secondaryStickOne.whenPressed(new SwitchDrive());
		secondaryStickOne.whenReleased(new SwitchDrive());	
		
		// Driver Control Commands
		secondaryStickThree.whenPressed(new ExtendWheelie());
		secondaryStickThree.whenReleased(new RetractWheelie());
		
		secondaryStickThree.whenPressed(new ExtendWheelie());
		secondaryStickThree.whenReleased(new RetractWheelie());
		
		secondaryStickFive.whenPressed(new ShiftUp());
		secondaryStickFive.whenReleased(new ShiftDown());
		
		thirdStickOne.whenPressed(new FireGroup());
	}
	
	private void updateDriveButtons() {
		driver.getUnloadBallButton().whenPressed(new UnloadBall());
		driver.getUnloadBallButton().whenReleased(new RetractLoader());
		
		driver.getLoadBallButton().whenPressed(new ExtendLoaderToLoad());
		driver.getLoadBallButton().whenReleased(new LoadBall());
		// Loader Commands
		
		driver.getOpenPorcullusButton().whenPressed(new OpenPortcullis());
		driver.getOpenPorcullusButton().whenReleased(new StopOpeningPortcullis());
		
		driver.getShift().whenPressed(new ShiftDown());
		driver.getShift().whenReleased(new ShiftUp());
	}
    
	
}

