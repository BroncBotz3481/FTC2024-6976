package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team6976AutoPropMiddleBlueFar", group="6976")
public class Team6976AutoPropMiddleBlueFar extends LinearOpMode {

    Team6976HM2024 robot = new Team6976HM2024();
    ElapsedTime Time = new ElapsedTime();
        double multy = 0.5;
        @Override
        public void runOpMode() {
            double distance = 36; //Distance in inches to strafe
            multy = 0.5; //Power setting to all motors
            robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            double tick = (distance * 537.7)/(4 * Math.PI);
            Time.reset();
            robot.DriveRightFront.setPower(-multy); //Setting the power to (multy) variable created above (-multy for red side)
            robot.DriveLeftFront.setPower(-multy); //Link to Wheel Direction Mapping Below
            robot.DriveRightBack.setPower(-multy); //https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
            robot.DriveLeftBack.setPower(-multy);


            while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveLeftFront.getCurrentPosition() < tick) { //If Encoder is outputting incorrectly, motor will automatically stop if time in miliseconds has been reached
                telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition()); //Printing Telemtry values to the phone
                telemetry.update(); //Constantly updates telemetry to the phone
            }

            robot.DriveRightFront.setPower(0); //Sets power to all motors to 0 after desired distance has been reached
            robot.DriveLeftFront.setPower(0);
            robot.DriveRightBack.setPower(0);
            robot.DriveLeftBack.setPower(0);
            robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //Stops and resets the encoder to the 0 value for next use
            robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(1000);

            double backDistance = 36;
            robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            // Calculate target encoder tick count for moving backward
            double backwardTick = (backDistance * 537.7) / (4 * Math.PI);

            // Reset elapsed time
            Time.reset();

            // Set power for all motors to move backward
            robot.DriveRightFront.setPower(multy);
            robot.DriveLeftFront.setPower(-multy);
            robot.DriveRightBack.setPower(-multy);
            robot.DriveLeftBack.setPower(multy);

// Continue until the OpMode is active, elapsed time is less than 2000 milliseconds, and the left front motor's encoder position is greater than or equal to the target tick count
            while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveLeftFront.getCurrentPosition() > -backwardTick) {
                telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
                telemetry.update();
            }

            robot.DriveRightFront.setPower(0);
            robot.DriveLeftFront.setPower(0);
            robot.DriveRightBack.setPower(0);
            robot.DriveLeftBack.setPower(0);
            robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(1000);


            double sideDistance = 40;
            robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            // Calculate target encoder tick count for moving backward
            double sideTick = (sideDistance * 537.7) / (4 * Math.PI);

            // Reset elapsed time
            Time.reset();

            // Set power for all motors to move backward
            robot.DriveRightFront.setPower(-multy);
            robot.DriveLeftFront.setPower(multy);
            robot.DriveRightBack.setPower(multy);
            robot.DriveLeftBack.setPower(-multy);


            while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveLeftFront.getCurrentPosition() > sideTick) {
                telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
                telemetry.update();
            }

            robot.DriveRightFront.setPower(0);
            robot.DriveLeftFront.setPower(0);
            robot.DriveRightBack.setPower(0);
            robot.DriveLeftBack.setPower(0);
            robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(1000);
        }
}
