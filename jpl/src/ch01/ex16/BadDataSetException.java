import java.io.FileInputStream;
import java.io.IOException;

class BadDataSetException extends Exception {
    private Exception mException;
    private String mFailedDataName;
    BadDataSetException(Exception e,String failedDataName) {
        mException = e;
        mFailedDataName = failedDataName;
    }

    public Exception getException() {
        return mException;
    }

    public String getFailedDataName() {
        return mFailedDataName;
    }
}

class MyUtilities {
    public double [] getDataSet(String setName) throws BadDataSetException{
        String file = setName + ".dset";
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            return readDataset(in);
        } catch (IOException e) {
            throw new BadDataSetException(e,file);
        } finally {
            try{
                if (in != null)
                    in.close();
            } catch (IOException e) {
                //無視
            }
        }


    }

    private double[] readDataset(FileInputStream in) {
        return null;
    }

    public static void main(String args[]){
        try {
            new MyUtilities().getDataSet("testest");
        } catch (BadDataSetException e) {
            e.printStackTrace();
            System.out.println("failedDataName:" + e.getFailedDataName());
            System.out.println("Message:" + e.getException().getMessage());
        }

    }

}