package frc.robot.buttonBindings;

import frc.core.util.oi.SmartController;
import frc.robot.commands.intake.IntakeEatsNoteComand;
import frc.robot.commands.intake.IntakeJointAscend;
import frc.robot.commands.intake.IntakeJointDescend;
import frc.robot.constants.ControllerConstants;
import frc.robot.subsystems.intake.IntakeEaterSubsystem;
import frc.robot.subsystems.intake.IntakeJointSubsystem;

public class OperatorButtonBindings {
  public static SmartController operator = new SmartController(ControllerConstants.kOperatorControllerPort);
  private IntakeEaterSubsystem intakeEaterSubsystem;
  private IntakeJointSubsystem intakeJointSubsystem;

  public OperatorButtonBindings(IntakeJointSubsystem intakeJointSubsystem, IntakeEaterSubsystem intakeEaterSubsystem) {
    this.intakeJointSubsystem = intakeJointSubsystem;
    this.intakeEaterSubsystem = intakeEaterSubsystem;
  }

  public void buttonBindingsIntake() {
    operator.whileRightBumper(new IntakeJointAscend(intakeJointSubsystem));
    operator.whileLeftBumper(new IntakeJointDescend(intakeJointSubsystem));
    operator.whileYButton(new IntakeEatsNoteComand(intakeEaterSubsystem));
  }


}
