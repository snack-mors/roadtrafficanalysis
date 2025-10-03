/*
 *
 */

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc

/**
 * The Class RoadVolume.
 */
public class RoadVolume {

    /**
     * The date.
     */
    private Date date;

    /**
     * The time.
     */
    private String time;

    /**
     * The volume sensor 1.
     */
    private int volumeSensor1;

    /**
     * The volume sensor 2.
     */
    private int volumeSensor2;

    /**
     * The volume sensor 3.
     */
    private int volumeSensor3;

    /**
     * The volume sensor 4.
     */
    private int volumeSensor4;

    /**
     * Instantiates a new road volume.
     *
     * @param date          the date
     * @param time          the time
     * @param volumeSensor1 the volume sensor 1
     * @param volumeSensor2 the volume sensor 2
     * @param volumeSensor3 the volume sensor 3
     * @param volumeSensor4 the volume sensor 4
     */
    public RoadVolume(Date date, String time, int volumeSensor1, int volumeSensor2, int volumeSensor3,
                      int volumeSensor4) {
        super();
        this.date = date;
        this.time = time;
        this.volumeSensor1 = volumeSensor1;
        this.volumeSensor2 = volumeSensor2;
        this.volumeSensor3 = volumeSensor3;
        this.volumeSensor4 = volumeSensor4;
    }

    /**
     * Gets the file data.
     *
     * @return the file data
     */
    public String getFileData() {

        return this.getVolumeSensor1() + "," + this.getVolumeSensor2() + "," + this.getVolumeSensor3() + "," + this.getVolumeSensor4() + ",";
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
     * Prints the date.
     */
    public void printDate() {
        SimpleDateFormat currentFormat = new SimpleDateFormat("MM/dd/yy");
        Date date = this.getDate();
        String newDate = currentFormat.format(date);
        System.out.print(newDate);

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
     * Gets the volume sensor 1.
     *
     * @return the volume sensor 1
     */
    public int getVolumeSensor1() {
        return volumeSensor1;
    }

    /**
     * Sets the volume sensor 1.
     *
     * @param volumeSensor1 the new volume sensor 1
     */
    public void setVolumeSensor1(int volumeSensor1) {
        this.volumeSensor1 = volumeSensor1;
    }

    /**
     * Gets the volume sensor 2.
     *
     * @return the volume sensor 2
     */
    public int getVolumeSensor2() {
        return volumeSensor2;
    }

    /**
     * Sets the volume sensor 2.
     *
     * @param volumeSensor2 the new volume sensor 2
     */
    public void setVolumeSensor2(int volumeSensor2) {
        this.volumeSensor2 = volumeSensor2;
    }

    /**
     * Gets the volume sensor 3.
     *
     * @return the volume sensor 3
     */
    public int getVolumeSensor3() {
        return volumeSensor3;
    }

    /**
     * Sets the volume sensor 3.
     *
     * @param volumeSensor3 the new volume sensor 3
     */
    public void setVolumeSensor3(int volumeSensor3) {
        this.volumeSensor3 = volumeSensor3;
    }

    /**
     * Gets the volume sensor 4.
     *
     * @return the volume sensor 4
     */
    public int getVolumeSensor4() {
        return volumeSensor4;
    }

    /**
     * Sets the volume sensor 4.
     *
     * @param volumeSensor4 the new volume sensor 4
     */
    public void setVolumeSensor4(int volumeSensor4) {
        this.volumeSensor4 = volumeSensor4;
    }


}
