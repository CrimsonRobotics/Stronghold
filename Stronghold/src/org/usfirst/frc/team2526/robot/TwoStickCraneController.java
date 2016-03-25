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
		return rightStick.getX();
	}

	public double getMagValue() {
		return leftStick.getY() * -1;
	}

	public JoystickButton getOpenPorcullusButton() {
		return new JoystickButton(rightStick, 2);
	}

	public JoystickButton getUnloadBallButton() {
		return new JoystickButton(rightStick, 1);
	}


	public JoystickButton getLoadBallButton() {
		return new JoystickButton(rightStick, 3);
	}

	public JoystickButton getShift() {
		return new JoystickButton(leftStick, 2);
	}


}
