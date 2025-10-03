import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// TODO: Auto-generated Javadoc

/**
 * The Class Project2.
 */
public class Project2 {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean inputValid = false;

        System.out.println("Enter in file pathways for volume data, AND then speed data: ");

        while (!inputValid)
            try {
                String volumeData = scnr.nextLine();
                String speedData = scnr.nextLine();
                System.out.println("Loading Volume Data...");
                List<RoadVolume> new1 = FileHandler.loadVolumeData(volumeData);
                System.out.println("Volume Data Loaded!");

                System.out.println("Loading Speed Data...");
                List<RoadSpeed> new2 = FileHandler.loadSpeedData(speedData);
                System.out.println("Speed Data Loaded!");

                System.out.println("Creating Road Section Data...");
                createRoadSections(new1, new2);
                System.out.println("Road Section Data Created!");
                inputValid = true;

//		for(RoadVolume currentRow : new1) {
//			currentRow.printDate();
//			System.out.print(" ");
//			System.out.print(currentRow.getTime());
//			System.out.print(" ");
//			System.out.print(currentRow.getVolumeSensor1());
//			System.out.print(" ");
//			System.out.print(currentRow.getVolumeSensor2());
//			System.out.print(" ");
//			System.out.print(currentRow.getVolumeSensor3());
//			System.out.print(" ");
//			System.out.print(currentRow.getVolumeSensor4());
//			System.out.println();
//			counter++;
//			
//		}


            } catch (FileNotFoundException e) {
                System.out.println("File not found! " + e + " Re-enter both paths: ");
            } catch (ParseException e) {
                System.out.println("Parse Exception! " + e + " Re-enter both paths: ");

            } catch (IOException e) {
                System.out.println("IO Exception!" + e + " Re-enter both paths: ");
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception! " + e + " Re-enter both paths: ");


            }
        scnr.close();
    }

    /**
     * Creates the road sections.
     *
     * @param volumeList the volume list
     * @param speedList  the speed list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void createRoadSections(List<RoadVolume> volumeList, List<RoadSpeed> speedList) throws IOException {
        List<RoadSection> roadSectionsArr = new ArrayList<>();
        // int matches = 0;
        for (RoadVolume set : volumeList) {

            for (RoadSpeed setOfSpeed : speedList) {

                // System.out.println("Speed Date: " + set.getDate() + " Volume Date: " + setOfSpeed.getDate());
                // System.out.println("Speed Time: " + set.getTime() + " Volume Time: " + setOfSpeed.getTime());

                if (set.getDate().equals(setOfSpeed.getDate()) && set.getTime().equals(setOfSpeed.getTime())) {
                    // System.out.println("These match!");
                    roadSectionsArr.add(new RoadSection(set, setOfSpeed));
                }

            }

        }
        // System.out.println(matches);

        FileHandler.writeRoadSectionData(roadSectionsArr);

    }


}
