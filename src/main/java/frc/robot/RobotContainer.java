// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.com_TeleopDrive;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.sub_Drive;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public static final sub_Drive m_drive = new sub_Drive();

  public static GenericHID controller0 = new GenericHID(0);

  // Look at the DpadButton.java file.  Max extends the Trigger object to allow
  // use of the Dpad directions into buttons
  public static DpadButton DpadUp = new DpadButton(controller0, 0);
  public static DpadButton DpadRight = new DpadButton(controller0, 90);
  public static DpadButton DpadDown = new DpadButton(controller0, 180);
  public static DpadButton DpadLeft = new DpadButton(controller0, 270);
  
  public static JoystickButton A = new JoystickButton(controller0, 1);
  public static JoystickButton B = new JoystickButton(controller0, 2);
  public static JoystickButton X = new JoystickButton(controller0, 3);
  public static JoystickButton Y = new JoystickButton(controller0, 4);
  public static JoystickButton LB = new JoystickButton(controller0, 5);
  public static JoystickButton RB = new JoystickButton(controller0, 6);
  public static JoystickButton Select = new JoystickButton(controller0, 7);
  public static JoystickButton Start = new JoystickButton(controller0, 8);
  public static JoystickButton LStickButton = new JoystickButton(controller0, 9);
  public static JoystickButton RStickButton = new JoystickButton(controller0, 10);





  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    //m_drive.setDefaultCommand(new com_TeleopDrive(controller0.getRawAxis(0), controller0.getRawAxis(1), m_drive));
    m_drive.setDefaultCommand(new com_TeleopDrive());

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
