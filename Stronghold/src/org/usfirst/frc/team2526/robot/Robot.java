
package org.usfirst.frc.team2526.robot;

import org.usfirst.frc.team2526.robot.commands.ResetGyro;
import org.usfirst.frc.team2526.robot.commands.autonomous.BackUpIncline;
import org.usfirst.frc.team2526.robot.commands.autonomous.DriveStraightThroughDefense;
import org.usfirst.frc.team2526.robot.commands.autonomous.LowbarAuto;
import org.usfirst.frc.team2526.robot.commands.catapult.ArmCatapult;
import org.usfirst.frc.team2526.robot.commands.catapult.FireCatapult;
import org.usfirst.frc.team2526.robot.commands.catapult.FireGroup;
import org.usfirst.frc.team2526.robot.commands.catapult.FireLaunch;
import org.usfirst.frc.team2526.robot.commands.catapult.FireReset;
import org.usfirst.frc.team2526.robot.commands.climber.ClimbUp;
import org.usfirst.frc.team2526.robot.commands.drive.DriveNoSubtract;
import org.usfirst.frc.team2526.robot.commands.drive.DriveVBus;
import org.usfirst.frc.team2526.robot.commands.drive.DriveVelocity;
import org.usfirst.frc.team2526.robot.commands.drive.ResetEncoders;
import org.usfirst.frc.team2526.robot.commands.drive.RotateTo;
import org.usfirst.frc.team2526.robot.commands.loader.ExtendLoader;
import org.usfirst.frc.team2526.robot.commands.loader.RetractLoader;
import org.usfirst.frc.team2526.robot.commands.loader.RollersIn;
import org.usfirst.frc.team2526.robot.commands.loader.RollersOut;
import org.usfirst.frc.team2526.robot.commands.vision.CalibrateOffset;
import org.usfirst.frc.team2526.robot.commands.vision.VisionShoot;
import org.usfirst.frc.team2526.robot.subsystems.Catapult;
import org.usfirst.frc.team2526.robot.subsystems.Climber;
import org.usfirst.frc.team2526.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2526.robot.subsystems.LoaderFrame;
import org.usfirst.frc.team2526.robot.subsystems.LoaderRollers;
import org.usfirst.frc.team2526.robot.subsystems.SonicShifters;
import org.usfirst.frc.team2526.robot.subsystems.VisionCamera;
import org.usfirst.frc.team2526.robot.subsystems.WheelieBar;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static VisionCamera camera;
	public static ADIS16448_IMU imu;
	
	public static Catapult catapult;
	public static LoaderFrame loaderFrame;
	public static LoaderRollers loaderRollers;
	public static Climber climber;
	public static SonicShifters sonic;
	public static WheelieBar wheelieBar;

	
	public static OI oi;


    Command autonomousCommand;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	new Compressor(RobotMap.PCM_MAIN).start();
    	Statics.getInstance();

    	imu = new ADIS16448_IMU();
       driveTrain = new DriveTrain();
       catapult = new Catapult();
       loaderFrame = new LoaderFrame();
       loaderRollers = new LoaderRollers();
       climber = new Climber();
       sonic = new SonicShifters();
       wheelieBar = new WheelieBar();
       camera = new VisionCamera();
       
       oi = new OI();
       
       SmartDashboard.putData(new BackUpIncline());
       SmartDashboard.putData(camera);
       SmartDashboard.putData(new ResetGyro());
       SmartDashboard.putData(new CalibrateOffset());
       SmartDashboard.putData(new VisionShoot());
       SmartDashboard.putData(new DriveStraightThroughDefense());
       SmartDashboard.putData(new RotateTo(90, 2));
       SmartDashboard.putData(new ExtendLoader());
       SmartDashboard.putData(new RetractLoader());
       SmartDashboard.putData(new FireCatapult());
       SmartDashboard.putData(new ArmCatapult());
       SmartDashboard.putData(new RollersIn());
       SmartDashboard.putData(new RollersOut());
       SmartDashboard.putData(new FireGroup());
       SmartDashboard.putData(new FireLaunch());
       SmartDashboard.putData(new FireCatapult());
       SmartDashboard.putData(new FireReset());
       SmartDashboard.putData(new ResetEncoders());
       SmartDashboard.putData(new ClimbUp());
       SmartDashboard.putData(new LowbarAuto());
       
       SmartDashboard.putData(new DriveVBus());
       SmartDashboard.putData(new DriveVelocity());
       SmartDashboard.putData(new DriveNoSubtract());
       
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = new LowbarAuto();
    	// schedule the autonomous command (example)
        if (autonomousCommand != null){
        	autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null){
        	autonomousCommand.cancel();
        }
        
        Robot.oi.updateDriverControls();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        Robot.oi.updateDriverControls();
        
        SmartDashboard.putBoolean("Wheelie Bar State", Robot.wheelieBar.getWheelieState());
        
        SmartDashboard.putNumber("X-Axis", imu.getAngleX());
        SmartDashboard.putNumber("Y-Axis", imu.getAngleY());
        SmartDashboard.putNumber("Z-Axis", imu.getAngleZ());
        
        loaderFrame.update();
        driveTrain.update();
        
        SmartDashboard.putNumber("Stick", Robot.oi.driver.getMagValue());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
