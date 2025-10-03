/*
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// TODO: Auto-generated Javadoc

/**
 * The Class FileHandler.
 */
public class FileHandler {

    /**
     * Load volume data.
     *
     * @param fileName the file name
     * @return the list
     * @throws FileNotFoundException the file not found exception
     * @throws ParseException        the parse exception
     */
    public static List<RoadVolume> loadVolumeData(String fileName) throws FileNotFoundException, ParseException {
        File volumeFile = new File(fileName);
        Scanner scnr = new Scanner(volumeFile);
        List<RoadVolume> volumeData = new ArrayList<>();
        scnr.nextLine();

        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            String[] input = line.split(",");
            SimpleDateFormat currentFormat = new SimpleDateFormat("MM/dd/yy");
            Date date = currentFormat.parse(input[0]);
            String time = input[1];
            int vol1 = Integer.parseInt(input[2]);
            int vol2 = Integer.parseInt(input[3]);
            int vol3 = Integer.parseInt(input[4]);
            int vol4 = Integer.parseInt(input[5]);

            volumeData.add(new RoadVolume(date, time, vol1, vol2, vol3, vol4));

        }


        scnr.close();
        return volumeData;
    }

    /**
     * Load speed data.
     *
     * @param fileName the file name
     * @return the list
     * @throws FileNotFoundException the file not found exception
     * @throws ParseException        the parse exception
     */
    public static List<RoadSpeed> loadSpeedData(String fileName) throws FileNotFoundException, ParseException {

        File speedFile = new File(fileName);
        Scanner scnr = new Scanner(speedFile);
        List<RoadSpeed> speedData = new ArrayList<>();
        scnr.nextLine();

        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            String[] input = line.split(",");
            SimpleDateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = currentFormat.parse(input[0]);
            String time = input[1];
            double vol1 = Double.parseDouble(input[2]);
            double vol2 = Double.parseDouble(input[3]);


            speedData.add(new RoadSpeed(date, time, vol1, vol2));

        }

        scnr.close();
        return speedData;
    }

    /**
     * Write road section data.
     *
     * @param sectionList the section list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void writeRoadSectionData(List<RoadSection> sectionList) throws IOException {
        FileWriter writer = new FileWriter("Road_Section_Data.csv");

        writer.write("Date,Time,Volume_Sensor_2003,Volume_Sensor_2004,Volume_Sensor_2005,Volume_Sensor,Speed_Sensor_2282,Speed_Sensor_2293,Volume_Total,Volume_Avg,Speed_Avg\n");
        for (RoadSection currentRow : sectionList) {
            writer.write(currentRow.getFileData() + "\n");
//		System.out.print("test ");
//		System.out.print(currentRow.getVolumeTotal());
//		System.out.print(" ");
//		System.out.print(currentRow.getVolumeAvg());
//		System.out.print(" ");
//		System.out.printf("%.2f", currentRow.getSpeedAvg());
//		System.out.print(" ");
//		// System.out.print(currentRow.getVolumeSensor3());
//		// System.out.print(" ");
//		// System.out.print(currentRow.getVolumeSensor4());
//		System.out.println();


        }
        writer.close();
    }


}
