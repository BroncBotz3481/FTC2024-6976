package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team6976AutoPropMiddleRed", group="6976")
public class Team6976AutoPropMiddleRed extends LinearOpMode {

    Team6976HM2024 robot = new Team6976HM2024();
    ElapsedTime Time = new ElapsedTime();


    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        robot.Intake.setPosition(0.1);
        robot.Intake2.setPosition(0.1);
        waitForStart();

        moveForward(0.8 , 2000); //moves forward
        moveArm(0.5, 2000);//the arm moves down
        robot.Intake.setPosition(0.3);//intake open
        robot.Intake2.setPosition(0);
        moveArm(-0.5, 2000);
        moveBackward(0.8 , 2000);
        moveLeft(0.8, 3500);











//        //Strafes Left
//        double distance = 20; //Distance in inches to strafe
//        multy = 0.4; //Power setting to all motors
//        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        double tick = (distance * 537.7)/(4 * Math.PI);
//        Time.reset();
//        robot.DriveRightFront.setPower(multy); //Setting the power to (multy) variable created above (-multy for red side)
//        robot.DriveLeftFront.setPower(multy); //Link to Wheel Direction Mapping Below
//        robot.DriveRightBack.setPower(-multy); //https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
//        robot.DriveLeftBack.setPower(-multy);
//        while(opModeIsActive() && Time.milliseconds() < 2000 && robot.DriveLeftFront.getCurrentPosition() < tick) { //If Encoder is outputting incorrectly, motor will automatically stop if time in miliseconds has been reached
//            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition()); //Printing Telemtry values to the phone
//            telemetry.update(); //Constantly updates telemetry to the phone
//        }
//        robot.DriveRightFront.setPower(0); //Sets power to all motors to 0 after desired distance has been reached
//        robot.DriveLeftFront.setPower(0);
//        robot.DriveRightBack.setPower(0);
//        robot.DriveLeftBack.setPower(0);
//        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //Stops and resets the encoder to the 0 value for next use
//        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        sleep(1000);
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
    public void moveLeft (double power, int time){
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightBack.setPower(power);
        robot.DriveLeftBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
    public void moveArm (double power, int time){
        robot.Arm2.setPower(power);
        robot.Arm2b.setPower(power);
        sleep(time);
        robot.Arm2.setPower(0);
        robot.Arm2b.setPower(0);

    }
}
