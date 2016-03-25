package org.usfirst.frc.team2526.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public interface CrimsonControlStick {
	
	public double getTurnValue();

	public double getMagValue();
	
	public JoystickButton getOpenPorcullusButton();
	
	public JoystickButton getUnloadBallButton();
	
	
	
	public JoystickButton getLoadBallButton();
	
	public JoystickButton getShift();
	
}
