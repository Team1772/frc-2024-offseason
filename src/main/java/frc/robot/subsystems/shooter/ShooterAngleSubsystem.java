package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterAngleSubsystem extends SubsystemBase{
  private TalonFX motor;

  public ShooterAngleSubsystem(){
    this.motor = new TalonFX(0); //Trocar id

    this.motor.setInverted(true);
  }

  public void setMotor(double speed){
    this.motor.set(speed);
  }

  public void stopMotor(){
    this.motor.stopMotor();
  }
}