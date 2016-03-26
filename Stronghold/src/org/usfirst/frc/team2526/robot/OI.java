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
	
	Button secondaryDriverOne = new JoystickButton(secondaryDriver,1);
	Button secondaryDriverTwo = new JoystickButton(secondaryDriver,2);
	Button secondaryDriverThree = new JoystickButton(secondaryDriver,3);


	
	
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
	
	

		secondaryDriverOne.whenPressed(new UnloadBall());
		secondaryDriverOne.whenReleased(new RetractLoader());
		
		secondaryDriverThree.whenPressed(new ExtendLoaderToLoad());
		secondaryDriverThree.whenReleased(new LoadBall());
		// Loader Commands
		
		secondaryDriverTwo.whenPressed(new OpenPortcullis());
		secondaryDriverTwo.whenReleased(new StopOpeningPortcullis());
		
		primaryDriverTwo.whenPressed(new ShiftUp());
		primaryDriverTwo.whenReleased(new ShiftDown());
	
	} 
	
}

