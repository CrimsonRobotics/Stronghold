package org.usfirst.frc.team2526.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public interface CrimsonControlStick {
	
	public double getTurnValue();

	public double getMagValue();
	
	public JoystickButton getOpenPorcullusButton();
	
	public JoystickButton getUnloadBallButton();
	
	public JoystickButton getRetractLoaderButton();
	
	public JoystickButton getExtendLoaderToLoadButton();
	
	public JoystickButton getLoadBallButton();
	
	public JoystickButton getShiftUp();
	
	public JoystickButton getShiftDown();
}
