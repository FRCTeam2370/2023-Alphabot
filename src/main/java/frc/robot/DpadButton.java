// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** Add your docs here. */
public class DpadButton extends Trigger {

  private GenericHID controller;
  private int position;

  public DpadButton(GenericHID controller, int position){
    this.controller = controller;
    this.position = position;
  }

    @Override
    public boolean get() {
        return controller.getPOV() == position;
      // This returns whether the trigger is active
    }
  }
