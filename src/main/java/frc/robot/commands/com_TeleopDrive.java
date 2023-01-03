// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Deadbands;
import frc.robot.RobotContainer;

public class com_TeleopDrive extends CommandBase {

  //private final sub_Drive m_drivetrain;
  //private final double m_speed;
  //private final double m_rotate;

  /** Creates a new com_TeleopDrive. */
  public com_TeleopDrive() {
  //public com_TeleopDrive(double speed, double rotate, sub_Drive drive) {
    //m_drivetrain = drive;
    //m_speed = speed;
    //m_rotate = rotate;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double MoveSpeed = Deadbands.SquaredDeadbands(RobotContainer.controller0, 0, 0.2);
    double RotateSpeed = Deadbands.SquaredDeadbands(RobotContainer.controller0,1,0.2);
    
    RobotContainer.m_drive.arcadeDrive(MoveSpeed, RotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
