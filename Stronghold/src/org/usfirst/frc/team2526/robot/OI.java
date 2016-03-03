package org.usfirst.frc.team2526.robot;



import org.usfirst.frc.team2526.robot.commands.catapult.FireGroup;
import org.usfirst.frc.team2526.robot.commands.climber.ClimbUp;
import org.usfirst.frc.team2526.robot.commands.climber.ReleaseHook;
import org.usfirst.frc.team2526.robot.commands.drive.ShiftDown;
import org.usfirst.frc.team2526.robot.commands.drive.ShiftUp;
import org.usfirst.frc.team2526.robot.commands.drive.SwitchDrive;
import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoader;
import org.usfirst.frc.team2526.robot.commands.loader.RollersOut;
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
	
	Joystick gamePad = new Joystick(0);
	Joystick secondaryStick = new Joystick(1);
	Joystick thirdStick = new Joystick(2);
	
	// Joysticks
 
	
	public Joystick getGamePad() {
		return gamePad;
	}
	
	public Joystick getSecondaryStick() {
		return secondaryStick;
	}
	
	public Joystick getThirdStick() {
		return thirdStick;
	}
    
	
	Button gamePadA = new JoystickButton(gamePad,1);
	Button gamePadB = new JoystickButton(gamePad,2);
	Button gamePadX = new JoystickButton(gamePad,3);
	Button gamePadY = new JoystickButton(gamePad,4);
	Button gamePadLB = new JoystickButton(gamePad,5);
	Button gamePadRB = new JoystickButton(gamePad,6);
	Button gamePadBack = new JoystickButton(gamePad,7);
	Button gamePadStart = new JoystickButton(gamePad,8);
	Button gamePadLeftThumb = new JoystickButton(gamePad,9);
	Button gamePadRightThumb = new JoystickButton(gamePad,10);
	// Gamepad Buttons
	
	Button secondaryStickOne = new JoystickButton(secondaryStick,1);
	Button secondaryStickTwo = new JoystickButton(secondaryStick,2);
	Button secondaryStickThree = new JoystickButton(secondaryStick,3);
	// Secondary Stick Buttons
	
	Button thirdStickOne = new JoystickButton(thirdStick, 1);
	// Third Stick Buttons
	
	
	// Fourth Stick Buttons
	
	
	public double getGamePadLTrigger() {
		return gamePad.getRawAxis(2);
	}
	
	public double getGamePadRTrigger() {
		return gamePad.getRawAxis(3);
	}
	

	
	public OI() {
	
		thirdStickOne.whenPressed(new SwitchDrive());
		thirdStickOne.whenReleased(new SwitchDrive());	
		// Driver Control Commands
		
//		primaryStickOne.whenPressed(new LoadBall());
//		primaryStickOne.whenReleased(new RetractLoader());
//		secondaryStickOne.whenPressed(new LoaderOut());
//		secondaryStickOne.whenReleased(new RetractLoader());
		
//		primaryStickOne.whileHeld(new RollersIn());
//		primaryStickOne.whenPressed(new ExtendLoader());
//		primaryStickOne.whenReleased(new LoadBall());
		
		gamePadRB.whileHeld(new RollersOut());
		gamePadLB.whenPressed(new ExtendLoader());
		// Loader Commands
		
		gamePadRightThumb.whenPressed(new ExtendWheelie());
		gamePadRightThumb.whenReleased(new RetractWheelie());
		
		gamePadY.whenPressed(new FireGroup());
		// Catapult Commands
		
		secondaryStickThree.whenPressed(new ExtendWheelie());
		secondaryStickThree.whenReleased(new RetractWheelie());

		
		gamePadLeftThumb.whenPressed(new ShiftDown());
		gamePadLeftThumb.whenReleased(new ShiftUp());
		
		
		
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

