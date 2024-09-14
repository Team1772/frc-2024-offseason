package frc.robot.buttonBindings;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import frc.core.util.oi.SmartController;
import frc.robot.commands.swervedrive.drivebase.AbsoluteDriveAdv;
import frc.robot.constants.HIDConstants;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;

public class DriverButtonBindings {

  private final SwerveSubsystem drivetrain;
  public static SmartController driver;

  public DriverButtonBindings(SwerveSubsystem drivetrain) {
    this.drivetrain = drivetrain;
    DriverButtonBindings.driver = new SmartController(HIDConstants.kDriverControllerPort);

    this.buttonBindingsDrivetain();
  }

  public void buttonBindingsDrivetain() {
    drivetrain.setDefaultCommand(
        !RobotBase.isSimulation() ? driveFieldOrientedAnglularVelocity() : driveFieldOrientedDirectAngleSim());
  }

  private Command driveFieldOrientedAnglularVelocity() {
    return drivetrain.driveCommand(
        () -> -MathUtil.applyDeadband((driver.getLeftY() * HIDConstants.Driver.JOYSTICK_LEFT_Y_AXIS_MODIFIER), HIDConstants.Operator.JOYSTICK_LEFT_Y_DEADBAND),
        () -> -MathUtil.applyDeadband((driver.getLeftX() * HIDConstants.Driver.JOYSTICK_LEFT_X_AXIS_MODIFIER), HIDConstants.Operator.JOYSTICK_LEFT_X_DEADBAND),
        () -> -driver.getRightX() * HIDConstants.Driver.JOYSTICK_RIGHT_X_AXIS_MODIFIER);
  }

  private AbsoluteDriveAdv closedAbsoluteDriveAdv() {
    return new AbsoluteDriveAdv(drivetrain,
        () -> -MathUtil.applyDeadband(driver.getLeftY(),
        HIDConstants.Operator.JOYSTICK_LEFT_Y_DEADBAND),
        () -> -MathUtil.applyDeadband(driver.getLeftX(),
        HIDConstants.Operator.JOYSTICK_LEFT_X_DEADBAND),
        () -> -MathUtil.applyDeadband(driver.getRightX(),
        HIDConstants.Operator.JOYSTICK_RIGHT_X_DEADBAND),
        driver.getYButton(),
        driver.getAButton(),
        driver.getXButton(),
        driver.getBButton());
  }

  private Command driveFieldOrientedDirectAngle() {
    return drivetrain.driveCommand(
        () -> MathUtil.applyDeadband(driver.getLeftY() * 1,
        HIDConstants.Operator.JOYSTICK_LEFT_Y_DEADBAND),
        () -> MathUtil.applyDeadband(driver.getLeftX() * 1,
        HIDConstants.Operator.JOYSTICK_LEFT_X_DEADBAND),
        () -> driver.getRightX(),
        () -> driver.getRightY());
  }

  private Command driveFieldOrientedDirectAngleSim() {
    return drivetrain.simDriveCommand(
        () -> MathUtil.applyDeadband(driver.getLeftY() * 0.8,
        HIDConstants.Operator.JOYSTICK_LEFT_Y_DEADBAND),
        () -> MathUtil.applyDeadband(driver.getLeftX() * 0.8,
        HIDConstants.Operator.JOYSTICK_LEFT_X_DEADBAND),
        () -> driver.getRightX());
  }

}