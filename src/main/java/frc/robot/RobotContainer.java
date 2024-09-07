// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.buttonBindings.DriverButtonBindings;
import frc.robot.buttonBindings.OperatorButtonBindings;
import frc.robot.subsystems.intake.IntakeJointSubsystem;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import java.io.File;

public class RobotContainer {

  private DriverButtonBindings driver;
  private OperatorButtonBindings operator;
  private final IntakeJointSubsystem intakeJointSubsystem;
  private final SwerveSubsystem drivebase = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
      "swerve"));

  public RobotContainer() {

    intakeJointSubsystem = new IntakeJointSubsystem();

    this.driver = new DriverButtonBindings(drivebase);
    this.operator = new OperatorButtonBindings(intakeJointSubsystem);

    configureBindings();
  }

  private void configureBindings() {
    driver.buttonBindingsDrivetain();
    operator.buttonBindingsIntake();
  }

  public Command getAutonomousCommand() {
    return drivebase.getAutonomousCommand("autoarthur");
  }

}