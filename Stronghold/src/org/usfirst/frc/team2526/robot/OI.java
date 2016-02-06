package org.usfirst.frc.team2526.robot;



import org.usfirst.frc.team2526.robot.commands.SwitchDrive;
import org.usfirst.frc.team2526.robot.commands.loader.RollBallIn;
import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoader;
import org.usfirst.frc.team2526.robot.commands.loader.LoaderIn;
import org.usfirst.frc.team2526.robot.commands.loader.LoaderOut;
import org.usfirst.frc.team2526.robot.commands.loader.RetractLoader;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	Joystick primaryStick = new Joystick(0);
	Joystick secondaryStick = new Joystick(1);
	Joystick thirdStick = new Joystick(2);
	Joystick fourthStick = new Joystick(3);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
	
	
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
	
	// Joystick get Commands
	
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
	
	// Primary Stick Buttons
	
	Button primaryStickOne = new JoystickButton(primaryStick,1);
	Button primaryStickThree = new JoystickButton(primaryStick,3);
	Button primaryStickFour = new JoystickButton(primaryStick,4);
	
	// Secondary Stick Buttons
	
	Button secondaryStickOne = new JoystickButton(secondaryStick,1);
	Button secondaryStickTwo = new JoystickButton(secondaryStick,2);
	
	// Third Stick Buttons
	
	Button thirdStickOne = new JoystickButton(thirdStick, 1);
	
	// Fourth Stick Buttons
	

	
	public Joystick getPrimaryValue() {
		return primaryStick;
	}
	
	public Joystick getSecondaryValue() {
		return secondaryStick;
	}
	
	public Joystick getThirdValue() {
		return thirdStick;
	}
	
	public Joystick getFourthValue() {
		return fourthStick;
	}
	
	public OI() {
	
		thirdStickOne.whenPressed(new SwitchDrive());
		thirdStickOne.whenReleased(new SwitchDrive());	
		
		// Grabber Commands
		primaryStickOne.whenPressed(new LoaderIn());
		primaryStickOne.whenReleased(new RetractLoader());
		
		secondaryStickOne.whenPressed(new LoaderOut());
		secondaryStickOne.whenReleased(new RetractLoader());
		
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

