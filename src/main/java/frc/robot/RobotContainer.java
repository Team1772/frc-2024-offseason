// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.buttonBindings.DriverButtonBindings;
import frc.robot.buttonBindings.OperatorButtonBindings;
import frc.robot.constants.IndexerConstants;
import frc.robot.subsystems.indexer.IndexerSubsystem;
import frc.robot.subsystems.intake.IntakeEaterSubsystem;
import frc.robot.subsystems.intake.IntakeJointSubsystem;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import java.io.File;

public class RobotContainer {
  SendableChooser<Command> chooser;
  private DriverButtonBindings driver;
  private OperatorButtonBindings operator;
  private final IntakeJointSubsystem intakeJointSubsystem;
  private final IntakeEaterSubsystem intakeEaterSubsystem;
  private final IndexerSubsystem indexerSubsystem;
  private final SwerveSubsystem drivebase = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
      "swerve"));

  public RobotContainer() {
    
    chooser = new SendableChooser<>();
    chooser.addOption("Curva", drivebase.getAutonomousCommand("Curva"));
    chooser.addOption("Reto", drivebase.getAutonomousCommand("Reto"));
    Shuffleboard.getTab("Autonomous").add(chooser);

    intakeJointSubsystem = new IntakeJointSubsystem();
    intakeEaterSubsystem = new IntakeEaterSubsystem();
    indexerSubsystem = new IndexerSubsystem();

    this.driver = new DriverButtonBindings(drivebase);
    this.operator = new OperatorButtonBindings(intakeJointSubsystem, intakeEaterSubsystem, indexerSubsystem);
    
    configureBindings();

  }

  private void configureBindings() {
    driver.buttonBindingsDrivetain();
    operator.buttonBindingsIntake();
  }

  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }

  public void setMotorBrake(boolean brake) {
    drivebase.setMotorBrake(brake);
  }
}

