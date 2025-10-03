/*
 *
 */

import java.util.Date;

// TODO: Auto-generated Javadoc

/**
 * The Class RoadSpeed.
 */
public class RoadSpeed {

    /**
     * The date.
     */
    private Date date;

    /**
     * The time.
     */
    private String time;

    /**
     * The speed sensor 1.
     */
    private double speedSensor1;

    /**
     * The speed sensor 2.
     */
    private double speedSensor2;

    /**
     * Instantiates a new road speed.
     *
     * @param date         the date
     * @param time         the time
     * @param speedSensor1 the speed sensor 1
     * @param speedSensor2 the speed sensor 2
     */
    public RoadSpeed(Date date, String time, double speedSensor1, double speedSensor2) {
        super();
        this.date = date;
        this.time = time;
        this.speedSensor1 = speedSensor1;
        this.speedSensor2 = speedSensor2;
    }

    /**
     * Gets the file data.
     *
     * @return the file data
     */
    public String getFileData() {
        return this.getSpeedSensor1() + "," + this.getSpeedSensor2() + ",";
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time.
     *
     * @param time the new time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets the speed sensor 1.
     *
     * @return the speed sensor 1
     */
    public double getSpeedSensor1() {
        return speedSensor1;
    }

    /**
     * Sets the speed sensor 1.
     *
     * @param speedSensor1 the new speed sensor 1
     */
    public void setSpeedSensor1(double speedSensor1) {
        this.speedSensor1 = speedSensor1;
    }

    /**
     * Gets the speed sensor 2.
     *
     * @return the speed sensor 2
     */
    public double getSpeedSensor2() {
        return speedSensor2;
    }

    /**
     * Sets the speed sensor 2.
     *
     * @param speedSensor2 the new speed sensor 2
     */
    public void setSpeedSensor2(double speedSensor2) {
        this.speedSensor2 = speedSensor2;
    }


}
