package org.usfirst.frc.team2526.robot.subsystems;

import org.usfirst.frc.team2526.robot.Robot;
import org.usfirst.frc.team2526.robot.RobotMap;
import org.usfirst.frc.team2526.robot.Statics;
import org.usfirst.frc.team2526.robot.commands.drive.DriveVBus;

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
        setDefaultCommand(new DriveVBus());
    }
    
    public DriveTrain (){
    	super("DriveTrain");
    	
    	pidValues = new PIDOutputValues();
    	
    	lMotor = new CANTalon(RobotMap.lMotorOne);
    	rMotor = new CANTalon(RobotMap.rMotorOne); 
    	lMotorTwo = new CANTalon(RobotMap.lMotorTwo);
    	rMotorTwo = new CANTalon(RobotMap.rMotorTwo);
    	
    	rMotor.reverseSensor(true);
    	lMotor.configEncoderCodesPerRev(360);
    	rMotor.configEncoderCodesPerRev(360);
    	
    	lMotor.configNominalOutputVoltage(+0.0f, -0.0f);
    	lMotor.configPeakOutputVoltage(+12.0f, -12.0f);
    	
    	rMotor.configNominalOutputVoltage(+0.0f, -0.0f);
    	rMotor.configPeakOutputVoltage(+12.0f, -12.0f);
    	
    	lMotor.setProfile(0);
    	lMotor.setF(0.48346);
    	lMotor.setP(0);
    	lMotor.setI(0);
    	lMotor.setD(0);
    	
    	rMotor.setProfile(0);
    	rMotor.setF(0.44171);
    	rMotor.setP(0);
    	rMotor.setI(0);
    	rMotor.setD(0);
    	
    	lMotor.changeControlMode(TalonControlMode.PercentVbus);
    	rMotor.changeControlMode(TalonControlMode.PercentVbus);
    	
    	
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
    	
    	drive.setSafetyEnabled(false);

    }
    
    
    public boolean onTurnTarget() {
    	return turnPID.onTarget();
    }
    
    public boolean isAtSetSpeed(double speed) {
    	return Math.abs(lMotor.get()) >= Math.abs(speed) 
    			&& Math.abs(rMotor.get()) >= Math.abs(speed);
    }
    
    public void increaseSpeed() {
    	lMotor.set(lMotor.get() + Statics.getDouble("Auto Speed Increase Rate"));
    	rMotor.set(rMotor.get() + Statics.getDouble("Auto Speed Increase Rate"));
    }
    
    public void freeArcadeDrive() {
    	turnPID.disable();
    	
    	if (RobotMap.primaryControl) {
    		// Main driver
    		drive.arcadeDrive(Robot.oi.getPrimaryDriver().getY(), Robot.oi.getSecondaryDriver().getX());
    	} else {
    		// Co Driver
        	drive.arcadeDrive(-Robot.oi.getSecondaryStick().getY() * RobotMap.secondaryWeight, Robot.oi.getThirdStick().getX() * RobotMap.secondaryWeight);
    	}
    	
    }
    
    public void velocityArcadeDrive() {
    	lMotor.changeControlMode(TalonControlMode.Speed);
    	rMotor.changeControlMode(TalonControlMode.Speed);
    	turnPID.disable();
    	
//    	double magnitude = Robot.oi.getDriverControls().getMagValue();
//    	double motorOutputL = lMotor.getOutputVoltage() / lMotor.getBusVoltage();
//    	double motorOutputR = rMotor.getOutputVoltage() / rMotor.getBusVoltage();
//    	
//    	String debug = "\tout L:";
//    	debug += motorOutputL;
//    	debug += "\tout R:";
//    	debug += motorOutputR;
//    	debug += "\tspd L:";
//    	debug += lMotor.getSpeed();
//    	debug += "\tspd R:";
//    	debug += rMotor.getSpeed();
    	
    	double magValue = Robot.oi.getPrimaryDriver().getY() * 900 * (RobotMap.primaryControl ? 1 : -1);
    	double turnValue = -Robot.oi.getSecondaryDriver().getX() * 900;
    	double leftMotorSpeed;
    	double rightMotorSpeed;
    	
    	if (magValue > 0.0) {
    	      if (turnValue > 0.0) {
    	        leftMotorSpeed = magValue - turnValue;
    	        rightMotorSpeed = Math.max(magValue, turnValue);
    	      } else {
    	        leftMotorSpeed = Math.max(magValue, -turnValue);
    	        rightMotorSpeed = magValue + turnValue;
    	      }
    	} else {
    	      if (turnValue > 0.0) {
    	        leftMotorSpeed = -Math.max(-magValue, turnValue);
    	        rightMotorSpeed = magValue + turnValue;
    	      } else {
    	        leftMotorSpeed = magValue - turnValue;
    	        rightMotorSpeed = -Math.max(-magValue, -turnValue);
    	      }
    	}
    	
    	lMotor.set(-leftMotorSpeed);
        rMotor.set(rightMotorSpeed);  
    	
//    	debug += "\terr L:";
//    	debug += lMotor.getClosedLoopError();
//    	
//    	debug += "\terr R:";
//    	debug += rMotor.getClosedLoopError();
//    	
//    	debug += "\trg:";
//    	debug += targetSpeed;
//    	
//    	System.out.println(debug);
    	
    		
    	SmartDashboard.putNumber("L Motor 1 Current", lMotor.getOutputCurrent());
    	SmartDashboard.putNumber("L Motor 2 Current", lMotorTwo.getOutputCurrent());
    	SmartDashboard.putNumber("R Motor 1 Current", rMotor.getOutputCurrent());
    	SmartDashboard.putNumber("R Motor 1 Current", rMotorTwo.getOutputCurrent());

    }
    
    public void driveWithTurnShift() {
    	if (RobotMap.primaryControl) {
    		// Main driver
    		
    		double magValue = -Robot.oi.getPrimaryDriver().getY();
        	double turnValue =  Robot.oi.getSecondaryDriver().getX();
    		
    		drive.arcadeDrive(magValue, turnValue);
    		
    		if (Math.abs(magValue) < 0.10) {
    			if (Math.abs(turnValue) > 0.3) {
    				Robot.sonic.shiftDown();
    			} else {
    				Robot.sonic.shiftUp();
    			}
    			
    		} else {
    			Robot.sonic.shiftUp();
    		}
    	} else {
    		// Co Driver
        	drive.arcadeDrive(-Robot.oi.getSecondaryStick().getY() * RobotMap.secondaryWeight, Robot.oi.getThirdStick().getX() * RobotMap.secondaryWeight);
    	}
    }
    
    public void noSubtractArcadeDrive() {
    	turnPID.disable();
    	
    	double magValue = Robot.oi.getPrimaryDriver().getY() * 900 * (RobotMap.primaryControl ? 1 : -1);
    	double turnValue = -Robot.oi.getSecondaryDriver().getX() * 900;
    	double leftMotorSpeed;
    	double rightMotorSpeed;
    	
    	if (magValue > 0.0) {
    	      if (turnValue > 0.0) {
    	        leftMotorSpeed = turnValue + magValue;
    	        rightMotorSpeed = magValue;
    	      } else {
    	        leftMotorSpeed = magValue;
    	        rightMotorSpeed = Math.abs(turnValue) + magValue;
    	      }
    	} else {
    		if (turnValue > 0.0) {
    	        leftMotorSpeed = -(turnValue + magValue);
    	        rightMotorSpeed = -magValue;
    	      } else {
    	        leftMotorSpeed = -magValue;
    	        rightMotorSpeed = -(Math.abs(turnValue) + magValue);
    	      }
    	}
    	
    	lMotor.set(-leftMotorSpeed);
        rMotor.set(rightMotorSpeed);  

    }
    
    public void driveConstant(double speed, double turnSpeed) {
    	drive.arcadeDrive(speed, turnSpeed);
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
    	
    	if (Statics.getDouble("Motor Recovery Enabled") == 1) {
    		if (lMotor.getFaultHardwareFailure() ==1 || rMotor.getFaultHardwareFailure() == 1) {
    			lMotor.disable();
    			rMotor.disable();
    		} else {
    			lMotor.enable();
    			rMotor.enable();
    		}
    		
    		if (lMotorTwo.getFaultHardwareFailure() ==1 || rMotorTwo.getFaultHardwareFailure() == 1) {
    			lMotorTwo.disable();
    			rMotorTwo.disable();
    		} else {
    			lMotorTwo.enable();
    			rMotorTwo.enable();
    		}
    	}
    }
}

