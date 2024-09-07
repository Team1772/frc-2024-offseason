package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.IntakeJointSubsystem;

public class IntakeJointAscend extends Command {
  private final IntakeJointSubsystem intakeJointSubsystem;

  public IntakeJointAscend(IntakeJointSubsystem intakeJointSubsystem) {
    this.intakeJointSubsystem = intakeJointSubsystem;

    addRequirements(intakeJointSubsystem);
  }

  @Override
  public void initialize() {
    intakeJointSubsystem.setMotors(0);
  }

  @Override
  public void execute() {
    intakeJointSubsystem.setMotors(10);
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
