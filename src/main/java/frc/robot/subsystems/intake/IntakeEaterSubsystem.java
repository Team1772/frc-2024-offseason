package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeEaterSubsystem extends SubsystemBase {

    private final TalonSRX rightMotor = new TalonSRX(6);
    private final VictorSPX leftMotor = new VictorSPX(7);

    public IntakeEaterSubsystem() {}
    
    public void setMotors (int percentOutput) {
        rightMotor.set(TalonSRXControlMode.PercentOutput, percentOutput);
        leftMotor.set(VictorSPXControlMode.PercentOutput, percentOutput);
    }

    @Override
    public void periodic() {}

}
