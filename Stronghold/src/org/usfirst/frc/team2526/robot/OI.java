package org.usfirst.frc.team2526.robot;



import org.usfirst.frc.team2526.robot.commands.SwitchDrive;
import org.usfirst.frc.team2526.robot.commands.catapult.FireGroup;
import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoader;
import org.usfirst.frc.team2526.robot.commands.loader.LoadBall;
import org.usfirst.frc.team2526.robot.commands.loader.RetractLoader;
import org.usfirst.frc.team2526.robot.commands.loader.RollersIn;
import org.usfirst.frc.team2526.robot.commands.loader.RollersOut;
import org.usfirst.frc.team2526.robot.commands.loader.UnloadBall;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick primaryStick = new Joystick(0);
	Joystick secondaryStick = new Joystick(1);
	Joystick thirdStick = new Joystick(2);
	Joystick fourthStick = new Joystick(3);
	// Joysticks
 
	
	public Joystick getPrimaryStick() {
		return primaryStick;
	}
	
	public Joystick getSecondaryStick() {
		return secondaryStick;
	}
	
	public Joystick getThirdStick() {
		return thirdStick;
	}
    
	public Joystick getFourthStick() {
		return fourthStick;
	}
	

	
	Button primaryStickOne = new JoystickButton(primaryStick,1);
	Button primaryStickThree = new JoystickButton(primaryStick,3);
	Button primaryStickFour = new JoystickButton(primaryStick,4);
	Button primaryStickSeven = new JoystickButton(primaryStick,7);
	Button primaryStickEight = new JoystickButton(primaryStick,8);
	// Primary Stick Buttons
	
	Button secondaryStickOne = new JoystickButton(secondaryStick,1);
	Button secondaryStickTwo = new JoystickButton(secondaryStick,2);
	// Secondary Stick Buttons
	
	Button thirdStickOne = new JoystickButton(thirdStick, 1);
	// Third Stick Buttons
	
	
	// Fourth Stick Buttons
	

	
	public OI() {
	
		thirdStickOne.whenPressed(new SwitchDrive());
		thirdStickOne.whenReleased(new SwitchDrive());	
		// Driver Control Commands
		
//		primaryStickOne.whenPressed(new LoadBall());
//		primaryStickOne.whenReleased(new RetractLoader());
//		secondaryStickOne.whenPressed(new LoaderOut());
//		secondaryStickOne.whenReleased(new RetractLoader());
		
		primaryStickOne.whileHeld(new RollersIn());
		primaryStickOne.whenPressed(new ExtendLoader());
		primaryStickOne.whenReleased(new LoadBall());
		
		primaryStickEight.whileHeld(new RollersOut());
		primaryStickEight.whenPressed(new UnloadBall());
		primaryStickEight.whenReleased(new RetractLoader());
		// Loader Commands

		
		primaryStickSeven.whenPressed(new FireGroup());
		// Catapult Commands
		
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

