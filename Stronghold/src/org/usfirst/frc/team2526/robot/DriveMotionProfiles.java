package org.usfirst.frc.team2526.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Notifier;

public class DriveMotionProfiles {

	private CANTalon.MotionProfileStatus status = new CANTalon.MotionProfileStatus();
	private CANTalon.SetValueMotionProfile setValue = CANTalon.SetValueMotionProfile.Disable;
	
	private int state = 0;
	private int loopTimeout = -1;
	
	
	private static final int kMinPointsInTalon = 5;
	private static final int kNumLoopsTimeout = 10;
	
	private CANTalon talon;
	
	class PeriodicRunnable implements java.lang.Runnable {
	    public void run() {  
	    	talon.processMotionProfileBuffer();    
	    }
	}
	
	Notifier notifer = new Notifier(new PeriodicRunnable());
	
	public DriveMotionProfiles(CANTalon talon) {
		this.talon = talon;
		talon.changeMotionControlFramePeriod(5);
		notifer.startPeriodic(0.005);
	}

	public void reset() {
		talon.clearMotionProfileTrajectories();
		setValue = CANTalon.SetValueMotionProfile.Disable;
		
		/* When we do start running our state machine start at the beginning. */
		state = 0;
		loopTimeout = -1;
		/*
		 * If application wanted to start an MP before, ignore and wait for next
		 * button press
		 */
		//bStart = false;
	}
}
