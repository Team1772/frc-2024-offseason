package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.IntakeJointSubsystem;

public class IntakeJointDescend extends Command {
  private final IntakeJointSubsystem m_IntakeJointSubsystem;

  public IntakeJointDescend(IntakeJointSubsystem intakeJointSubsystem) {
    m_IntakeJointSubsystem = intakeJointSubsystem;

    addRequirements(intakeJointSubsystem);
  }

  @Override
  public void initialize() {
    m_IntakeJointSubsystem.setMotors(0);
  }

  @Override
  public void execute() {
    m_IntakeJointSubsystem.setMotors(-5);
  }

  @Override
  public void end(boolean interrupted) {
    m_IntakeJointSubsystem.setMotors(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
