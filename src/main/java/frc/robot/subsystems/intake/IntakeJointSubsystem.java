package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.IntakeConstants;

public class IntakeJointSubsystem extends SubsystemBase {
  private final VictorSPX leftMotor;
  private final VictorSPX rightMotor;
  private final DigitalInput limitUp;
  private final DigitalInput limitDown; 

  public IntakeJointSubsystem() {
    this.leftMotor = new VictorSPX(IntakeConstants.IntakeJointConstants.ID_MOTOR_LEFT);
    this.rightMotor = new VictorSPX(IntakeConstants.IntakeJointConstants.ID_MOTOR_RIGHT);
    this.limitUp  = new DigitalInput(IntakeConstants.IntakeJointConstants.ID_LIMIT_UP);
    this.limitDown = new DigitalInput(IntakeConstants.IntakeJointConstants.ID_LIMIT_DOWN);
  }

  public void setMotors(double percentOutput) {
    leftMotor.set(VictorSPXControlMode.PercentOutput, percentOutput);
    rightMotor.set(VictorSPXControlMode.PercentOutput, percentOutput);
  }

  @Override
  public void periodic() {}

}
 