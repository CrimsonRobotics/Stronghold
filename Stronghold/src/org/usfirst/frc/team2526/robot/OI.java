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
import org.usfirst.frc.team2526.robot.commands.loader.RollersIn;
import org.usfirst.frc.team2526.robot.commands.loader.StopRollers;
import org.usfirst.frc.team2526.robot.commands.loader.UnloadBall;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.ExtendWheelie;
import org.usfirst.frc.team2526.robot.commands.wheeliebar.RetractWheelie;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	Joystick primaryDriver = new Joystick(0);
	Joystick secondaryDriver = new Joystick(1);
	Joystick secondaryStick = new Joystick(2);
	Joystick thirdStick = new Joystick(3);
 
	
	public Joystick getPrimaryDriver() {
		return primaryDriver;
	}
	
	public Joystick getSecondaryDriver() {
		return secondaryDriver;
	}
	
	public Joystick getSecondaryStick() {
		return secondaryStick;
	}
	
	public Joystick getThirdStick() {
		return thirdStick;
	}
	

	
	Button primaryDriverOne = new JoystickButton(secondaryStick,1);
	Button primaryDriverTwo = new JoystickButton(primaryDriver,2);
	Button primaryDriverFour = new JoystickButton(primaryDriver,4);
	Button primaryDriverFive = new JoystickButton(primaryDriver,5);
	Button primaryDriverSix = new JoystickButton(primaryDriver,6);
	Button primaryDriverNine = new JoystickButton(primaryDriver,9);
	
	Button secondaryDriverOne = new JoystickButton(secondaryDriver,1);
	Button secondaryDriverTwo = new JoystickButton(secondaryDriver,2);
	Button secondaryDriverThree = new JoystickButton(secondaryDriver,3);
	Button secondaryDriverFour = new JoystickButton(secondaryDriver,4);


	
	
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
		
		secondaryStickThree.whenPressed(new ExtendWheelie());
		secondaryStickThree.whenReleased(new RetractWheelie());
		
		secondaryStickFive.whenPressed(new ShiftUp());
		secondaryStickFive.whenReleased(new ShiftDown());
		
		thirdStickOne.whenPressed(new FireGroup());
	
	

		//Joystick Controls
		
		secondaryDriverOne.whenPressed(new UnloadBall());
		secondaryDriverOne.whenReleased(new RetractLoader());
		
		secondaryDriverThree.whenPressed(new ExtendLoaderToLoad());
		secondaryDriverThree.whenReleased(new LoadBall());
		// Loader Commands
		
		secondaryDriverFour.whenPressed(new RollersIn());
		secondaryDriverFour.whenReleased(new StopRollers());
		
		secondaryDriverTwo.whenPressed(new OpenPortcullis());
		secondaryDriverTwo.whenReleased(new StopOpeningPortcullis());
		
		primaryDriverTwo.whenPressed(new ShiftUp());
		primaryDriverTwo.whenReleased(new ShiftDown());
		
		//Gamepad Controls
		
/*		primaryDriverFive.whenPressed(new ExtendLoaderToLoad());
		primaryDriverFive.whenReleased(new LoadBall());
		
		primaryDriverTwo.whenPressed(new OpenPortcullis());
		primaryDriverTwo.whenReleased(new StopOpeningPortcullis());
		
		primaryDriverFour.whenPressed(new RollersIn());
		primaryDriverFour.whenReleased(new StopRollers());

		
		primaryDriverSix.whenPressed(new UnloadBall());
		primaryDriverSix.whenReleased(new RetractLoader());
		
		primaryDriverNine.whenPressed(new ShiftUp());
		primaryDriverNine.whenReleased(new ShiftDown());
	*/
	} 
	
}

