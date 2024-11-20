package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
  private TalonFX motorRight;
  private TalonFX motorLeft;

  public ShooterSubsystem(){
    this.motorLeft = new TalonFX(0); //Trocar id
    this.motorRight = new TalonFX(0); //Trocar id

    this.motorLeft.setInverted(true);
    this.motorRight.setInverted(false);
  }

  public void setMotors(double speed){
    this.motorLeft.set(speed);
    this.motorRight.set(speed);
  }

  public void stopMotors(){
    this.motorLeft.stopMotor();
    this.motorRight.stopMotor();
  }
}
