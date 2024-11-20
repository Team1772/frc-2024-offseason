package frc.robot.buttonBindings;

import frc.core.util.oi.SmartController;
import frc.robot.commands.indexer.IndexerPull;
import frc.robot.commands.indexer.IndexerPush;
import frc.robot.commands.intake.IntakeEatsNoteComand;
import frc.robot.commands.intake.IntakeJointAscend;
import frc.robot.commands.intake.IntakeJointDescend;
import frc.robot.commands.intake.IntakeJointManual;
import frc.robot.commands.shooter.AngleShooterManual;
import frc.robot.commands.shooter.Shoot;
import frc.robot.constants.HIDConstants;
import frc.robot.subsystems.indexer.IndexerSubsystem;
import frc.robot.subsystems.intake.IntakeEaterSubsystem;
import frc.robot.subsystems.intake.IntakeJointSubsystem;
import frc.robot.subsystems.shooter.ShooterAngleSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class OperatorButtonBindings {
  public static SmartController operator = new SmartController(HIDConstants.kOperatorControllerPort);
  private IntakeEaterSubsystem intakeEaterSubsystem;
  private IntakeJointSubsystem intakeJointSubsystem;
  private IndexerSubsystem indexerSubsystem;
  private ShooterSubsystem shooterSubsystem;
  private ShooterAngleSubsystem shooterAngleSubsystem;

  public OperatorButtonBindings(IntakeJointSubsystem intakeJointSubsystem, IntakeEaterSubsystem intakeEaterSubsystem,
      IndexerSubsystem indexerSubsystem, ShooterSubsystem shooterSubsystem,
      ShooterAngleSubsystem shooterAngleSubsystem) {
    this.intakeJointSubsystem = intakeJointSubsystem;
    this.intakeEaterSubsystem = intakeEaterSubsystem;
    this.indexerSubsystem = indexerSubsystem;
    this.shooterSubsystem = shooterSubsystem;
    this.shooterAngleSubsystem = shooterAngleSubsystem;
  }

  public void buttonBindingsIntake() {
    operator.whileRightBumper(new IntakeJointAscend(intakeJointSubsystem));
    operator.whileLeftBumper(new IntakeJointDescend(intakeJointSubsystem));
    operator.whileYButton(new IntakeEatsNoteComand(intakeEaterSubsystem));
    intakeJointSubsystem.setDefaultCommand(
        new IntakeJointManual(intakeJointSubsystem, () -> operator.getLeftY()));

    operator.whileXButton(new IndexerPull(indexerSubsystem));
    operator.whileBButton(new IndexerPush(indexerSubsystem));

    operator.whileRightTrigger(new Shoot(shooterSubsystem, 0.5));

    operator.whileXUp(new AngleShooterManual(shooterAngleSubsystem, 0.3));
    operator.whileXDown(new AngleShooterManual(shooterAngleSubsystem, -0.3));

  }

}
