package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Team6976Auto1ParkingBlue", group="6976")

public class Team6976Auto1ParkingBlue extends LinearOpMode {
    Team6976HM2024 robot = new Team6976HM2024();
    ElapsedTime Time = new ElapsedTime();
    double multy = 0.5;

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        waitForStart();
                    moveForward(0.4 , 1335); //moves forward
                    moveBackward(0.4,1300); //backwards

        //Moves forward
        double distance = 22; //Distance in inches to strafe
        multy = 0.5; //Power setting to all motors
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double tick = (distance * 537.7)/(4 * Math.PI);

        Time.reset();
        robot.DriveRightFront.setPower(multy); //Setting the power to (multy) variable created above (+multy for Blue side)
        robot.DriveLeftFront.setPower(-multy); //Link to Wheel Direction Mapping Below
        robot.DriveRightBack.setPower(multy); //https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
        robot.DriveLeftBack.setPower(-multy);
        while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveRightFront.getCurrentPosition() < tick) { //If Encoder is outputting incorrectly, motor will automatically stop if time in miliseconds has been reached
            telemetry.addData("Encoder Val", robot.DriveRightFront.getCurrentPosition()); //Printing Telemtry values to the phone
            telemetry.update(); //Constantly updates telemetry to the phone
        }
        robot.DriveRightFront.setPower(0); //Sets power to all motors to 0 after desired distance has been reached
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //Stops and resets the encoder to the 0 value for next use
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void moveForward (double power, int time){
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(power);
        robot.DriveRightBack.setPower(-power);
        robot.DriveLeftBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
    public void moveBackward (double power, int time){
        robot.DriveRightFront.setPower(-power);
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightBack.setPower(power);
        robot.DriveLeftBack.setPower(power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
}