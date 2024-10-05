package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.IntakeConstants;

public class IntakeEaterSubsystem extends SubsystemBase {

    private final TalonSRX rightMotor;
    private final VictorSPX leftMotor;
    private final DigitalInput infraredSensor;

    public IntakeEaterSubsystem() {
        this.rightMotor = new TalonSRX(IntakeConstants.IntakeEaterConstants.ID_MOTOR_RIGHT);
        this.leftMotor = new VictorSPX(IntakeConstants.IntakeEaterConstants.ID_MOTOR_LEFT);
        this.infraredSensor = new DigitalInput(IntakeConstants.IntakeEaterConstants.ID_INFRARED);

        this.rightMotor.setInverted(IntakeConstants.IntakeEaterConstants.IS_MOTOR_RIGHT_INVERTED);
        this.leftMotor.setInverted(IntakeConstants.IntakeEaterConstants.IS_MOTOR_LEFT_INVERTED);
    }
    
    public void setMotors (int percentOutput) {
        rightMotor.set(TalonSRXControlMode.PercentOutput, percentOutput);
        leftMotor.set(VictorSPXControlMode.PercentOutput, percentOutput);
    }

    @Override
    public void periodic() {}

}
