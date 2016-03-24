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
//import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	CrimsonControlStick driver = new GamePadController(1);
	Joystick secondaryStick = new Joystick(2);
	Joystick thirdStick = new Joystick(3);
 
	
	public CrimsonControlStick getDriverControls() {
		return driver;
	}
	
	public Joystick getSecondaryStick() {
		return secondaryStick;
	}
	
	public Joystick getThirdStick() {
		return thirdStick;
	}
	
	public void setDriveControls(CrimsonControlStick drive) {
		this.driver = drive;
	}
    
	
//	Button gamePadA = new JoystickButton(gamePad,1);
//	Button gamePadB = new JoystickButton(gamePad,2);
//	Button gamePadX = new JoystickButton(gamePad,3);
//	Button gamePadY = new JoystickButton(gamePad,4);
//	Button gamePadLB = new JoystickButton(gamePad,5);
//	Button gamePadRB = new JoystickButton(gamePad,6);
//	Button gamePadBack = new JoystickButton(gamePad,7);
//	Button gamePadStart = new JoystickButton(gamePad,8);
//	Button gamePadLeftThumb = new JoystickButton(gamePad,9);
//	Button gamePadRightThumb = new JoystickButton(gamePad,10);
	// Gamepad Buttons
	
	Button secondaryStickOne = new JoystickButton(secondaryStick,1);
	Button secondaryStickTwo = new JoystickButton(secondaryStick,2);
	Button secondaryStickThree = new JoystickButton(secondaryStick,3);
	Button secondaryStickFive = new JoystickButton(secondaryStick,5);

	// Secondary Stick Buttons
	
	Button thirdStickOne = new JoystickButton(thirdStick, 1);
	Button thirdStickThree = new JoystickButton(thirdStick, 3);
	// Third Stick Buttons
	

	

	
	public OI() {
	
		secondaryStickOne.whenPressed(new SwitchDrive());
		secondaryStickOne.whenReleased(new SwitchDrive());	
		// Driver Control Commands
		
		secondaryStickThree.whenPressed(new ExtendWheelie());
		secondaryStickThree.whenReleased(new RetractWheelie());
		
//		primaryStickOne.whenPressed(new LoadBall());
//		primaryStickOne.whenReleased(new RetractLoader());
//		secondaryStickOne.whenPressed(new LoaderOut());
//		secondaryStickOne.whenReleased(new RetractLoader());
		
//		primaryStickOne.whileHeld(new RollersIn());
//		primaryStickOne.whenPressed(new ExtendLoader());
//		primaryStickOne.whenReleased(new LoadBall());
		
		driver.getUnloadBallButton().whenPressed(new UnloadBall());
		driver.getRetractLoaderButton().whenReleased(new RetractLoader());
		
		driver.getExtendLoaderToLoadButton().whenPressed(new ExtendLoaderToLoad());
		driver.getLoadBallButton().whenReleased(new LoadBall());
		// Loader Commands
		
		driver.getOpenPorcullusButton().whenPressed(new OpenPortcullis());
		driver.getOpenPorcullusButton().whenReleased(new StopOpeningPortcullis());
		
//		gamePadRightThumb.whenPressed(new ExtendWheelie());
//		gamePadRightThumb.whenReleased(new RetractWheelie());
		
//		gamePadY.whenPressed(new FireGroup());
		// Catapult Commands
		
		secondaryStickThree.whenPressed(new ExtendWheelie());
		secondaryStickThree.whenReleased(new RetractWheelie());
		
		secondaryStickFive.whenPressed(new ShiftUp());
		secondaryStickFive.whenReleased(new ShiftDown());
		
		thirdStickOne.whenPressed(new FireGroup());

		
		driver.getShiftDown().whenPressed(new ShiftDown());
		driver.getShiftUp().whenReleased(new ShiftUp());
		
		
		
	}
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
	
	
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

