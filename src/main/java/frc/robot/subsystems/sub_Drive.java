// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class sub_Drive extends SubsystemBase {
  
  WPI_TalonSRX LeftFrontDrive = null;
  WPI_TalonSRX LeftRearDrive = null;
  WPI_TalonSRX RightFrontDrive = null;
  WPI_TalonSRX RightRearDrive = null;
  DifferentialDrive m_drive = null;


  /** Creates a new sub_Drive. */
  public sub_Drive() {
    LeftFrontDrive = new WPI_TalonSRX(Constants.LeftFrontDriveMotorID);
    LeftRearDrive = new WPI_TalonSRX(Constants.LeftRearDriveMotorID);
    RightFrontDrive = new WPI_TalonSRX(Constants.RightFrontDriveMotorID);
    RightRearDrive = new WPI_TalonSRX(Constants.RightRearDriveMotorID);  
    m_drive = new DifferentialDrive(LeftFrontDrive, RightFrontDrive);
  
    // Reset all the motor configurations
    LeftFrontDrive.configFactoryDefault();
    LeftRearDrive.configFactoryDefault();
    RightFrontDrive.configFactoryDefault();
    RightRearDrive.configFactoryDefault();

    // Invert the right side so it drives straight
    //RightFrontDrive.setInverted(true);
    //RightRearDrive.setInverted(InvertType.FollowMaster);

    // Set up following
    LeftRearDrive.follow(LeftFrontDrive);
    RightRearDrive.follow(RightFrontDrive);

    // Set up for percent output
    // LeftFrontDrive.set(ControlMode.PercentOutput, 0);
    //RightFrontDrive.set(ControlMode.PercentOutput,0);
  }


  public void arcadeDrive(double speed, double rotate){
    m_drive.arcadeDrive(-speed, rotate);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Motor", LeftFrontDrive.getMotorOutputPercent());
    SmartDashboard.putNumber("Right Motor", RightFrontDrive.getMotorOutputPercent());
  }
}
