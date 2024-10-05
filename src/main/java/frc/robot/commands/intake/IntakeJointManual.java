package frc.robot.commands.intake;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.IntakeJointSubsystem;

public class IntakeJointManual extends Command {
      private final IntakeJointSubsystem intakeJointSubsystem;
      private DoubleSupplier speed;

  public IntakeJointManual(IntakeJointSubsystem intakeJointSubsystem, DoubleSupplier speed) {
    this.intakeJointSubsystem = intakeJointSubsystem;
    this.speed = speed;

    addRequirements(intakeJointSubsystem);
  }

  @Override
  public void initialize() {
    intakeJointSubsystem.setMotors(0);
  }

  @Override
  public void execute() {
    intakeJointSubsystem.setMotors(speed.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    intakeJointSubsystem.setMotors(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
