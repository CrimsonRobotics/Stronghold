package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.commands.drive.Drive;

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
	PIDController turnPID;

	public static final double pTurn = 0.030, iTurn = 0, dTurn = 0.010;
	
    public void initDefaultCommand() { 
        setDefaultCommand(new Drive());
    }
    
    public DriveTrain (){
    	super("DriveTrain");
    	
    	
    	pidValues = new PIDOutputValues();
    	
    	lMotor = new CANTalon(RobotMap.lMotorOne);
    	rMotor = new CANTalon(RobotMap.rMotorOne); 
    	lMotorTwo = new CANTalon(RobotMap.lMotorTwo);
    	rMotorTwo = new CANTalon(RobotMap.rMotorTwo);
    	
    	lMotorTwo.changeControlMode(TalonControlMode.Follower);
    	rMotorTwo.changeControlMode(TalonControlMode.Follower);
    	lMotorTwo.set(RobotMap.lMotorOne);
    	rMotorTwo.set(RobotMap.rMotorOne);
    	
    	
    	
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
    	
    	turnPID.setAbsoluteTolerance(3.0);
    	turnPID.setOutputRange(-0.5, 0.5);
    	
    	drive = new RobotDrive(lMotor, rMotor);
    	
    }
    
    
    public boolean onTurnTarget() {
    	return turnPID.onTarget();
    }
    
    public void freeArcadeDrive() {
    	turnPID.disable();
    	
    	if (RobotMap.primaryControl) {
    		// Main driver
    		drive.arcadeDrive(Robot.oi.getDriverControls().getMagValue(), Robot.oi.getDriverControls().getTurnValue());
    	} else {
    		// Co Driver
        	drive.arcadeDrive(-Robot.oi.getSecondaryStick().getY() * RobotMap.secondaryWeight, Robot.oi.getThirdStick().getX() * RobotMap.secondaryWeight);
    	}
    	
    }
    
    
    
    public void driveConstant(double speed, double turnSpeed) {
    	pidValues.setMagnitudeValue(-speed);
    	pidValues.setTurnValue(turnSpeed);
    }
    
    public void stopDriving() {
    	turnPID.disable();
    	
    	lMotor.set(0);
    	rMotor.set(0);
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
    
    public void enableTurnPIDValues() {
    	turnPID.enable();
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
    	SmartDashboard.putData("TurnPID", turnPID);
    	
    	SmartDashboard.putNumber("Left Encoder", getRawLeftEncoder());
    	SmartDashboard.putNumber("Right Encoder", getRawRightEncoder());
    	
    	SmartDashboard.putNumber("Angle Y", Robot.imu.getAngleY());
    	SmartDashboard.putNumber("Angle X", Robot.imu.getAngleX());
    	SmartDashboard.putNumber("Angle Z", Robot.imu.getAngleZ());
    	
    }
}

