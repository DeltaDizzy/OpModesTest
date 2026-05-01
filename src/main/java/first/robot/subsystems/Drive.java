// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.subsystems;

import org.wpilib.command3.Mechanism;
import org.wpilib.drive.DifferentialDrive;
import org.wpilib.hardware.imu.OnboardIMU;
import org.wpilib.hardware.imu.OnboardIMU.MountOrientation;
import org.wpilib.hardware.motor.PWMTalonFX;
import org.wpilib.hardware.rotation.DutyCycle;
import org.wpilib.hardware.rotation.DutyCycleEncoder;

public class Drive extends Mechanism {
  // Hardware
  PWMTalonFX frontLeft, frontRight, backLeft, backRight;
  DutyCycleEncoder leftEncoder, rightEncoder;

  // Software
  OnboardIMU gyro;
  DifferentialDrive drive;

  /** Creates a new Drive. */
  public Drive() {
    frontLeft = new PWMTalonFX(0);
    frontRight = new PWMTalonFX(1);
    backLeft = new PWMTalonFX(2);
    backRight = new PWMTalonFX(3);

    frontLeft.addFollower(backLeft);
    frontRight.addFollower(backRight);

    leftEncoder = new DutyCycleEncoder(new DutyCycle(4));
    rightEncoder = new DutyCycleEncoder(new DutyCycle(5));

    gyro = new OnboardIMU(MountOrientation.FLAT);

    drive = new DifferentialDrive(frontLeft, frontRight);
  }

  public void arcadeDrive(double throttle, double turn) {
    drive.arcadeDrive(throttle, turn);
  }
}
