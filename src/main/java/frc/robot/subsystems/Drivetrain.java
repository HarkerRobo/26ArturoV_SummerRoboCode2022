public class Drivetrain extends SubsystemBase{

    private static Drivetrain instance;

    private static final int MOTOR_ID = 0;

    private HSTalon rightMasterMotor;
    private HSTalon leftMasterMotor;
    private VictorSPX rightFollowerMotor;
    private VictorSPX leftFollowerMotor;

    private static final int LEFT_MASTER = 0;
    private static final int LEFT_FOLLOWER = 0;
    private static final int RIGHT_MASTER = 0;
    private static final int RIGHT_FOLLOWER = 0;

    private Drivetrain() {
        rightMasterMotor = new HSTalon(RIGHT_MASTER);
        leftMasterMotor = new HSTalon(LEFT_MASTER);
        rightMasterMotor = new VictorSPX(RIGHT_FOLLOWER);
        leftFollowerMotor = new VictorSPX(LEFT_FOLLOWER);
    }

    public static Drivetrain getInstance() {
        if(instance == null) {
            instance = new Drivetrain();

        }
        return instance;
    }
}