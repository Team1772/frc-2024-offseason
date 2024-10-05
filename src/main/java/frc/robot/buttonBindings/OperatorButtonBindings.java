package frc.robot.buttonBindings;

import frc.core.util.oi.SmartController;
import frc.robot.commands.indexer.IndexerPull;
import frc.robot.commands.indexer.IndexerPush;
import frc.robot.commands.intake.IntakeEatsNoteComand;
import frc.robot.commands.intake.IntakeJointAscend;
import frc.robot.commands.intake.IntakeJointDescend;
import frc.robot.commands.intake.IntakeJointManual;
import frc.robot.constants.HIDConstants;
import frc.robot.subsystems.indexer.IndexerSubsystem;
import frc.robot.subsystems.intake.IntakeEaterSubsystem;
import frc.robot.subsystems.intake.IntakeJointSubsystem;

public class OperatorButtonBindings {
  public static SmartController operator = new SmartController( HIDConstants.kOperatorControllerPort);
  private IntakeEaterSubsystem intakeEaterSubsystem;
  private IntakeJointSubsystem intakeJointSubsystem;
  private IndexerSubsystem indexerSubsystem;

  public OperatorButtonBindings(IntakeJointSubsystem intakeJointSubsystem, IntakeEaterSubsystem intakeEaterSubsystem, IndexerSubsystem indexerSubsystem) {
    this.intakeJointSubsystem = intakeJointSubsystem;
    this.intakeEaterSubsystem = intakeEaterSubsystem;
    this.indexerSubsystem = indexerSubsystem;
  }

  public void buttonBindingsIntake() {
    operator.whileRightBumper(new IntakeJointAscend(intakeJointSubsystem));
    operator.whileLeftBumper(new IntakeJointDescend(intakeJointSubsystem));
    operator.whileYButton(new IntakeEatsNoteComand(intakeEaterSubsystem));
    operator.whileXButton(new IndexerPull(indexerSubsystem));
    operator.whileBButton(new IndexerPush(indexerSubsystem));

    intakeJointSubsystem.setDefaultCommand(
      new IntakeJointManual(intakeJointSubsystem, () -> operator.getLeftY())
    );
  }


}
