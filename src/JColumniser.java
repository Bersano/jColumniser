import java.io.*;

public class JColumniser {

    private File inputFile;
    private String separator;

    private long valueOfLinesInFile;
    private int valueOfColumns;
    private String[][] allData;

    JColumniser(File a, String b) {

        inputFile = a;
        separator = b;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            valueOfLinesInFile = bufferedReader.lines().count();
            bufferedReader.close();
        }
        catch (FileNotFoundException fnfe) { fnfe.printStackTrace(); }
        catch (IOException ioe) { ioe.printStackTrace(); }


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            valueOfColumns = bufferedReader.readLine().split(separator).length;
            bufferedReader.close();
        }
        catch (FileNotFoundException fnfe) { fnfe.printStackTrace(); }
        catch (IOException ioe) { ioe.printStackTrace(); }

        allData = new String[(int)valueOfLinesInFile][(int)valueOfColumns];

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            for (int everyLine = 0; everyLine < valueOfLinesInFile; everyLine++) {

                String[] lineSplitted = bufferedReader.readLine().split(separator);

                for (int everyCol = 0; everyCol < lineSplitted.length; everyCol++)
                    allData[everyLine][everyCol] = lineSplitted[everyCol];
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException fnfe) {fnfe.printStackTrace();}
        catch (IOException ioe) {ioe.printStackTrace(); }
    }


    String[] getDataFromColumn(int col) {
        String[] result = new String[(int)valueOfLinesInFile];

        for (int everyLine = 0; everyLine < valueOfLinesInFile; everyLine++)
            result[everyLine] = allData[everyLine][col];

        return result;
    }
}