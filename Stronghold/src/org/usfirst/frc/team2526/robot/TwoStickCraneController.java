package org.usfirst.frc.team2526.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class TwoStickCraneController implements CrimsonControlStick {

	Joystick leftStick;
	Joystick rightStick;
	
	public TwoStickCraneController(int leftPort, int rightPort) {
		leftStick = new Joystick(leftPort);
		rightStick = new Joystick(rightPort);
	}

	public double getTurnValue() {
		return leftStick.getX();
	}

	public double getMagValue() {
		return rightStick.getY() * -1;
	}

	public JoystickButton getOpenPorcullusButton() {
		return null;
	}

	public JoystickButton getUnloadBallButton() {
		return new JoystickButton(leftStick, 2);
	}

	public JoystickButton getRetractLoaderButton() {
		return null;
	}

	public JoystickButton getExtendLoaderToLoadButton() {
		return null;
	}

	public JoystickButton getLoadBallButton() {
		return null;
	}

	public JoystickButton getShiftUp() {
		return null;
	}

	public JoystickButton getShiftDown() {
		return null;
	}

}
