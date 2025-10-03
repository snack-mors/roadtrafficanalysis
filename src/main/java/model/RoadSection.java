/*
 *
 */

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc

/**
 * The Class RoadSection.
 */
public class RoadSection {

    /**
     * The road volume.
     */
    private RoadVolume roadVolume;

    /**
     * The road speed.
     */
    private RoadSpeed roadSpeed;

    /**
     * The volume total.
     */
    private int volumeTotal;

    /**
     * The volume avg.
     */
    private double volumeAvg;

    /**
     * The speed avg.
     */
    private double speedAvg;


    /**
     * Instantiates a new road section.
     *
     * @param roadVolume the road volume
     * @param roadSpeed  the road speed
     */
    public RoadSection(RoadVolume roadVolume, RoadSpeed roadSpeed) {
        super();
        this.roadVolume = roadVolume;
        this.roadSpeed = roadSpeed;
        this.volumeTotal = calcVolumeTotal();
        this.volumeAvg = calcVolumeAvg();
        this.speedAvg = calcSpeedAvg();
    }

    /**
     * Gets the file data.
     *
     * @return the file data
     */
    public String getFileData() {
        String fileData = "";
        fileData = this.getDate();
        fileData = fileData + roadVolume.getTime() + ",";
        fileData = fileData + roadVolume.getFileData();
        fileData = fileData + roadSpeed.getFileData();
        fileData = fileData + this.getVolumeTotal() + "," + this.getVolumeAvg() + "," + this.getSpeedAvg();

        return fileData;
    }


    /**
     * Gets the road volume.
     *
     * @return the road volume
     */
    public RoadVolume getRoadVolume() {
        return roadVolume;
    }

    /**
     * Sets the road volume.
     *
     * @param roadVolume the new road volume
     */
    public void setRoadVolume(RoadVolume roadVolume) {
        this.roadVolume = roadVolume;
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public String getDate() {
        SimpleDateFormat currentFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = this.getRoadVolume().getDate();
        String newDate = currentFormat.format(date);
        return newDate + ",";

    }

    /**
     * Gets the road speed.
     *
     * @return the road speed
     */
    public RoadSpeed getRoadSpeed() {
        return roadSpeed;
    }


    /**
     * Sets the road speed.
     *
     * @param roadSpeed the new road speed
     */
    public void setRoadSpeed(RoadSpeed roadSpeed) {
        this.roadSpeed = roadSpeed;
    }


    /**
     * Gets the volume total.
     *
     * @return the volume total
     */
    public int getVolumeTotal() {


        return volumeTotal;
    }


    /**
     * Sets the volume total.
     *
     * @param volumeTotal the new volume total
     */
    public void setVolumeTotal(int volumeTotal) {
        this.volumeTotal = volumeTotal;
    }


    /**
     * Gets the volume avg.
     *
     * @return the volume avg
     */
    public double getVolumeAvg() {
        return volumeAvg;
    }


    /**
     * Sets the volume avg.
     *
     * @param volumeAvg the new volume avg
     */
    public void setVolumeAvg(double volumeAvg) {
        this.volumeAvg = volumeAvg;
    }


    /**
     * Gets the speed avg.
     *
     * @return the speed avg
     */
    public double getSpeedAvg() {
        return speedAvg;
    }


    /**
     * Sets the speed avg.
     *
     * @param speedAvg the new speed avg
     */
    public void setSpeedAvg(double speedAvg) {
        this.speedAvg = speedAvg;
    }

    /**
     * Calc volume total.
     *
     * @return the int
     */
    private int calcVolumeTotal() {


        int vol1 = this.getRoadVolume().getVolumeSensor1();
        int vol2 = this.getRoadVolume().getVolumeSensor2();
        int vol3 = this.getRoadVolume().getVolumeSensor3();
        int vol4 = this.getRoadVolume().getVolumeSensor4();
        int volumeTotal = vol1 + vol2 + vol3 + vol4;

        return volumeTotal;
    }

    /**
     * Calc volume avg.
     *
     * @return the double
     */
    private double calcVolumeAvg() {

        return (double) this.calcVolumeTotal() / 4;
    }

    /**
     * Calc speed avg.
     *
     * @return the double
     */
    private double calcSpeedAvg() {

        double sensor1 = this.getRoadSpeed().getSpeedSensor1();
        double sensor2 = this.getRoadSpeed().getSpeedSensor2();

        return (sensor1 + sensor2) / 2;
    }

}
