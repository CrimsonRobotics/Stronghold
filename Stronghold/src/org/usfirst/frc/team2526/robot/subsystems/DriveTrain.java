package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.drive.Drive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	
	public CANTalon lMotor, rMotor, lMotorTwo, rMotorTwo;
	
	PIDOutputValues pidValues;

	RobotDrive drive;
	PIDController drivePID, turnPID; // Even though the talons can run PID, I am using my own controllers to avoid switching modes all the time.

	AnalogInput ultraSonic;
	
	double sumSensor = 0;
	double averageCount = 0;
	
	public static final double pDrive = 0.013, iDrive = 0, dDrive = 0.010;
	public static final double pTurn = 0.030, iTurn = 0, dTurn = 0.010;
	
    public void initDefaultCommand() { 
        setDefaultCommand(new Drive());
    }
    
    public DriveTrain (){
    	super("DriveTrain");
    	
    	
    	pidValues = new PIDOutputValues();
    	
    	ultraSonic = new AnalogInput(1);
    	
    	lMotor = new CANTalon(RobotMap.lMotorOne);
    	rMotor = new CANTalon(RobotMap.rMotorOne); 
    	lMotorTwo = new CANTalon(RobotMap.lMotorTwo);
    	rMotorTwo = new CANTalon(RobotMap.rMotorTwo);
    	
    	lMotorTwo.changeControlMode(TalonControlMode.Follower);
    	rMotorTwo.changeControlMode(TalonControlMode.Follower);
    	lMotorTwo.set(RobotMap.lMotorOne);
    	rMotorTwo.set(RobotMap.rMotorOne);
    	
    	
    	drivePID = new PIDController(pDrive, iDrive, dDrive, new PIDSource() {
    		PIDSourceType type = PIDSourceType.kDisplacement;
			
    		public void setPIDSourceType(PIDSourceType pidSource) {
				type = pidSource;
			}
			
			public PIDSourceType getPIDSourceType() {
				return type;
			}

			public double pidGet() {
				return -Robot.driveTrain.getRawLeftEncoder()/10.0;
			}
    		
    	}, new PIDOutput() {

			public void pidWrite(double output) {
				pidValues.setMagnitudeValue(output);
			}
    		
    	});
    	
    	turnPID = new PIDController(pTurn, iTurn, dTurn, new PIDSource() {
    		PIDSourceType type = PIDSourceType.kDisplacement;
			public void setPIDSourceType(PIDSourceType pidSource) {
				type = pidSource;
			}

			public PIDSourceType getPIDSourceType() {
				return type;
			}

			public double pidGet() {
				return Robot.imu.getAngleY();
			}
    		
    	}, new PIDOutput() {

			public void pidWrite(double output) {
				pidValues.setTurnValue(output);
			}
    		
    	});
    	
    	drivePID.setOutputRange(-0.5, 0.5);
    	drivePID.setOutputRange(-0.5, 0.5);
    	
    	turnPID.setAbsoluteTolerance(3.0);
    	drivePID.setAbsoluteTolerance(5);
    	
    	
    	drive = new RobotDrive(lMotor, rMotor);
    	
    }
    
    
    public boolean onDriveTarget() {
    	return drivePID.onTarget();
    }
    
    public boolean onTurnTarget() {
    	return turnPID.onTarget();
    }
    
    public void freeArcadeDrive() {
    	drivePID.disable();
    	turnPID.disable();
    	
    	if (RobotMap.primaryControl) {
    		// Main driver
    		drive.arcadeDrive(Robot.oi.getGamePad().getRawAxis(1), Robot.oi.getGamePad().getRawAxis(4));
    	} else {
    		// Co Driver
        	drive.arcadeDrive(-Robot.oi.getSecondaryStick().getY() * RobotMap.secondaryWeight, Robot.oi.getThirdStick().getX() * RobotMap.secondaryWeight);
    	}
    	
    }
    
    public void setDriveStraight(double inches, double startingAngle) {
    	double ticks = Statics.Inches.inchesToTicks(inches);
    	
    	lMotor.setEncPosition(0);
    	rMotor.setEncPosition(0);
    	
    	turnPID.setSetpoint(startingAngle);
    	drivePID.setSetpoint(-ticks);
    }
    
    public void setDriveAbsStraight(double absoluteTicks) {
    	drivePID.setSetpoint(-absoluteTicks);
    }
    
    public void setDriveRelativeStraight(double relativeTicks) {
    	lMotor.setEncPosition(0);
    	rMotor.setEncPosition(0);
    	Robot.imu.reset();
    	turnPID.setSetpoint(0);
    	drivePID.setSetpoint(-relativeTicks);
    }
    
    public void driveConstant(double speed) {
    	pidValues.setMagnitudeValue(-speed);
    	turnPID.setSetpoint(0);
    }
    
    public void stopDriving() {
    	drivePID.disable();
    	turnPID.disable();
    	
    	lMotor.set(0);
    	rMotor.set(0);
    }
    
    public void beginDriveHold() {
    	lMotor.disable();
    	rMotor.disable();
    	rMotorTwo.disable();
    	lMotorTwo.disable();
    }
    
    public void releaseDriveHold() {
    	lMotor.enable();
    	rMotor.enable();
    	rMotorTwo.enable();
    	lMotorTwo.enable();
    }
    
    public void setAngle(double angle) {
    	turnPID.setSetpoint(angle);
    }
    
    public double getRawLeftEncoder() {
    	return lMotor.getEncPosition();
    }
    
    public double getRawRightEncoder() {
    	return rMotor.getEncPosition();
    }
    
    public double getDistanceAwayFromFront() {
    	return ultraSonic.getAverageValue()*0.393701;
    }
    
    public void enableDrivePIDValues() {
    	drivePID.enable();
    }
    
    public void enableTurnPIDValues() {
    	turnPID.enable();
    }
    
    public void disableDrivePIDValues() {
    	drivePID.disable();
    }
    
    public void disableTurnPIDValues() {
    	turnPID.disable();
    }
    
    public void updatePIDValues() {
    	pidValues.updateSpeed(drive);
    }
    
    public void resetEncoders() {
    	lMotor.setEncPosition(0);
    	rMotor.setEncPosition(0);
    }
    
    public void update() {
    	sumSensor += ultraSonic.getValue();
    	averageCount++; 
    	
    	if (averageCount > 100) {
    		SmartDashboard.putNumber("UltraOut", sumSensor/averageCount);
    		averageCount = 0;
    		
    		sumSensor = 0;
    	}
    	
    	SmartDashboard.putData("DrivePID", drivePID);
    	SmartDashboard.putData("TurnPID", turnPID);
    	
    	SmartDashboard.putNumber("Left Encoder", getRawLeftEncoder());
    	SmartDashboard.putNumber("Right Encoder", getRawRightEncoder());
    	
    	SmartDashboard.putNumber("Angle Y", Robot.imu.getAngleY());
    	SmartDashboard.putNumber("Angle X", Robot.imu.getAngleX());
    	SmartDashboard.putNumber("Angle Z", Robot.imu.getAngleZ());
    	
    	SmartDashboard.putNumber("Ultrasonic Internal Average Value", ultraSonic.getAverageValue()* 0.393701);
    }
}

