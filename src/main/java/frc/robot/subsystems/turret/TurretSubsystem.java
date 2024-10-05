package frc.robot.subsystems.turret;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.IndexerConstants;

public class TurretSubsystem extends SubsystemBase {
    private TalonFX turretMotor;

    public TurretSubsystem() {
        this.turretMotor = new TalonFX(30);
    }

    public void setMotor(double speed) {
        turretMotor.set(speed);
    }

    public void stopMotor() {
        turretMotor.stopMotor();
    }

}
