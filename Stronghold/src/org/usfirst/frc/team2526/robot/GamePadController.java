package org.usfirst.frc.team2526.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class GamePadController implements CrimsonControlStick {

	Joystick gamePad;
	
	public GamePadController(int port) {
		this.gamePad = new Joystick(port);
	}

	public double getTurnValue() {
		return gamePad.getRawAxis(4);
	}

	public double getMagValue() {
		return gamePad.getRawAxis(1);
	}

	public JoystickButton getOpenPorcullusButton() {
		return new JoystickButton(gamePad,2);
	}

	public JoystickButton getUnloadBallButton() {
		return new JoystickButton(gamePad, 6);
	}

	public JoystickButton getRetractLoaderButton() {
		return new JoystickButton(gamePad,6);
	}

	public JoystickButton getExtendLoaderToLoadButton() {
		return new JoystickButton(gamePad,5);
	}

	public JoystickButton getLoadBallButton() {
		return new JoystickButton(gamePad,5);
	}

	public JoystickButton getShiftUp() {
		return new JoystickButton(gamePad,9);
	}

	public JoystickButton getShiftDown() {
		return new JoystickButton(gamePad,9);
	}

}
