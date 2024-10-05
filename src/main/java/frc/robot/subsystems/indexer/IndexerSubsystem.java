package frc.robot.subsystems.indexer;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.IndexerConstants;

public class IndexerSubsystem extends SubsystemBase {
    private TalonFX indexerMotor;
    private DigitalInput infraredSensor;

    public IndexerSubsystem(){
        this.indexerMotor = new TalonFX(IndexerConstants.ID_MOTOR);
        this.infraredSensor = new DigitalInput(IndexerConstants.ID_INFRARED);

        this.indexerMotor.setInverted(IndexerConstants.IS_MOTOR_INVERTED);
    }

    public void setMotor(double speed){
        indexerMotor.set(speed);
    }

    public void stopMotor(){
        indexerMotor.stopMotor();
    }

    public boolean isInfraredSensor(){
        return infraredSensor.get();
    }
}

